package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.representation.Representation;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

@Path("/guessit/database")
public class GuessDatabaseResource {

	@GET
	@Produces("application/json")
	public Response represent() throws JSONException {
		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBObject query = BasicDBObjectBuilder.start().add("_id", 123).get();
		JSONObject gameObject = new JSONObject();

		DBCollection gameCollection = db.getCollection("gameTable");
		DBCursor cursor = gameCollection.find(query);
		DBObject gameDetails = null;
		if (cursor != null && cursor.hasNext()) {
			gameDetails = cursor.next();
			gameObject.put("game", gameDetails);
		} else {
			gameObject.put("message", "No game with this id exists. Please check!");
		}
		return Response.status(200).entity(gameObject).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String hostGame(Game entity) throws IOException, JSONException {
		Representation result = null;
		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");

		String host = entity.getHost();
		String gameLevel = entity.getLevel();
		String gameName = entity.getGameName();
		UUID id = UUID.randomUUID();

		DBObject foundGame = findGame(gameName);
		if (foundGame == null) {
			int computerGuess = 70;
			if (gameLevel.equalsIgnoreCase("easy"))
				computerGuess = new Random().nextInt(100) + 2;
			else
				computerGuess = new Random().nextInt(1000) + 2;

			BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
			BasicDBList asList1 = new BasicDBList();
			BasicDBList asList2 = new BasicDBList();
			docBuilder.append("_id", id);
			docBuilder.append("host", host);
			docBuilder.append("level", gameLevel);
			docBuilder.append("gameName", gameName);
			docBuilder.append("computerGuess", computerGuess);
			docBuilder.append("players", asList1);
			docBuilder.append("score", asList2);
			DBObject gameObject = docBuilder.get();
			gameCollection.insert(gameObject);
			mongoClient.close();
			return String.valueOf(computerGuess);
		}
		return "Error! Game already Exists";
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String joinGame(Game entity) throws JSONException {
		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");
		DBObject foundGame = findGame(entity.getGameName());

		if (foundGame == null) {
			return "Game Does Not Exists";
		} else {

			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.put("gameName", entity.getGameName());

			BasicDBObject updateCommand = new BasicDBObject();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("playerName", entity.getPlayerName());
			updateCommand.put("$push", new BasicDBObject("players", map));
			WriteResult result = gameCollection.update(updateQuery, updateCommand, true, true);

			mongoClient.close();
		}
		return foundGame.get("computerGuess").toString();
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
