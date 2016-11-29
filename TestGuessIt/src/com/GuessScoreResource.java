package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

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

@Path("/guessit/score")
public class GuessScoreResource {

	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
 	public JsonRepresentation insertScore(Score entity) throws IOException
 	{
		System.out.println("inside");
		
 		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
 		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
 		DB db = mongoClient.getDB("guessit");
 		DBCollection gameCollection = db.getCollection("gameTable");
 		System.out.println("game"+entity.getPlayerName());
 	     DBObject foundGame = findGame(entity.getGameName());
 	    
 	        if (foundGame==null) 
 	        {
 	        	return new JsonRepresentation("Game Does Not Exists");
 	        }
 	        else
 	        {
 	        	BasicDBObject updateQuery = new BasicDBObject();
 	        	updateQuery.put("gameName", entity.getGameName());
 	            
 	            BasicDBObject updateCommand = new BasicDBObject();
 	            HashMap<String, Object> map = new HashMap<String, Object>();
 	            map.put("name",entity.getPlayerName());
 	            map.put("time", entity.getTime());
 	            map.put("moves",entity.getTurns());
 	            updateCommand.put( "$push", new BasicDBObject( "score", map ) );
 	            WriteResult result = gameCollection.update( updateQuery, updateCommand, true, true );
 	        	
 	            mongoClient.close();
 	        }
         	return new JsonRepresentation("");
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
