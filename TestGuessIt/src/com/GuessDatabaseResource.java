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
			BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
			docBuilder.append("_id", id);
			docBuilder.append("host", host);
			docBuilder.append("level", gameLevel);
			docBuilder.append("gameName", gameName);
			DBObject gameObject = docBuilder.get();
			gameCollection.insert(gameObject);
			mongoClient.close();
			return "Game Hosted";
		}
		return "Error! Game already Exists";
	}

	@Put
	public JsonRepresentation joinGame(Representation entity) throws JSONException {

		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");

		Form userForm = new Form(entity);
		DBObject foundGame = findGame(userForm.getFirstValue("gameId"));

		if (foundGame == null) {
			return new JsonRepresentation("Game Does Not Exists");
			/// JSONObject gameObject = new JSONObject(foundGame);
			// JSONArray userArray = gameObject.getJSONArray("users");

			// int length = userArray.length();
			// userArray[length]serForm.getFirstValue("user");
		}
		return new JsonRepresentation("");
	}
	
	@Post
	@Path("/updateScore")
 	public JsonRepresentation insertScore(Representation entity) throws IOException
 	{
 		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
 		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
 		DB db = mongoClient.getDB("guessit");
 		DBCollection gameCollection = db.getCollection("gameTable");
 
 		 Form userForm = new Form(entity);
 		 String gameId = userForm.getFirstValue("gameId");
 		 String time = userForm.getFirstValue("time");
 		 String moves = userForm.getFirstValue("moves");
 				 
 	     DBObject foundGame = findGame(userForm.getFirstValue("gameId"));
 	    
 	        if (foundGame==null) 
 	        {
 	        	return new JsonRepresentation("Game Does Not Exists");
 	        }
 	        else
 	        {
 	        	BasicDBObject updateQuery = new BasicDBObject();
 	            updateQuery.put( "gameName", gameId );
 	            
 	            BasicDBObject updateCommand = new BasicDBObject();
 	            HashMap<String, String> map = new HashMap<String, String>();
 	            map.put("time", time);
 	            map.put("moves",moves);
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
