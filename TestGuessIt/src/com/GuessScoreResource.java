package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

@Path("/guessit/score")
public class GuessScoreResource {

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public JsonRepresentation insertScore(Score entity) throws IOException {
		System.out.println("inside");

		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");
		System.out.println("game" + entity.getName());
		DBObject foundGame = findGame(entity.getGameName());

		if (foundGame == null) {
			return new JsonRepresentation("Game Does Not Exists");
		} else {
			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.put("gameName", entity.getGameName());

			BasicDBObject updateCommand = new BasicDBObject();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", entity.getName());
			map.put("time", entity.getTime());
			map.put("moves", entity.getMoves());
			updateCommand.put("$push", new BasicDBObject("score", map));
			WriteResult result = gameCollection.update(updateQuery, updateCommand, true, true);

			mongoClient.close();
		}
		return new JsonRepresentation("");
	}

	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/{gameName}/")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getScore(@PathParam("gameName") String gameName)
			throws JsonParseException, JsonMappingException, JSONException, IOException {
		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		List<Score> list = new ArrayList<Score>();
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");
		DBObject foundGame = findGame(gameName);
		if (foundGame != null) {
			ObjectMapper mapper = new ObjectMapper();
			JSONObject gameJSON = new JSONObject(JSON.serialize(foundGame));
			list = mapper.readValue(gameJSON.get("score").toString(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, Score.class));
			list.sort(new Comparator<Score>() {
				@Override
				public int compare(Score o1, Score o2) {
					// TODO Auto-generated method stub
					if(o1.getMoves()< o2.getMoves())
						return -1;
					else if(o1.getMoves() == o2.getMoves())
						return o1.getTime()<o2.getTime() ? -1 :1;
					else return 0;
				}
			});
		}
		JSONArray scoreArray = new JSONArray();
		for (Score sc : list) {
			JSONObject scoreObject = new JSONObject();
			scoreObject.put("name", sc.getName());
			scoreObject.put("moves", sc.getMoves());
			scoreObject.put("time", sc.getTime());

			scoreArray.put(scoreObject);
		}

		return scoreArray.toString();
	}

	private DBObject findGame(String gameName) throws JSONException {
		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBObject query = BasicDBObjectBuilder.start().add("gameName", gameName).get();
		JSONObject gameObject = new JSONObject();

		DBCollection gameCollection = db.getCollection("gameTable");
		DBCursor cursor = gameCollection.find(query);
		DBObject gameDetails = null;
		if (cursor != null && cursor.hasNext()) {
			gameDetails = cursor.next();
			gameObject.put("game", gameDetails);
			mongoClient.close();
		}
		return gameDetails;
	}

}
