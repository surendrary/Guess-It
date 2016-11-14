import java.awt.List;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

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
import com.sun.javafx.collections.MappingChange.Map;

public class GuessDatabaseResource extends ServerResource {

	@Get
	public JsonRepresentation represent() {
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
		return new JsonRepresentation(gameObject);
	}

	@Post
	public JsonRepresentation hostGame(Representation entity) throws IOException {
		Representation result = null;
		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");

		Form userForm = new Form(entity);
		String host = userForm.getFirstValue("host");
		String gameLevel = userForm.getFirstValue("level");
		String gameName = userForm.getFirstValue("gameName");
		UUID id = UUID.randomUUID();

		DBObject foundGame = findGame(gameName);
		if (foundGame == null) {
			BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
			BasicDBList asList = new BasicDBList();
			docBuilder.append("_id", id);
			docBuilder.append("host", host);
			docBuilder.append("level", gameLevel);
			docBuilder.append("gameName", gameName);
			docBuilder.append("players", asList);
			DBObject gameObject = docBuilder.get();
			gameCollection.insert(gameObject);
			mongoClient.close();
			return new JsonRepresentation(gameObject);
		} else {
			return new JsonRepresentation("Already Exist");
		}
	}

	/**
	 * Method to join a game. 
	 * Ex:
	 * {
    	"_id": {
        "$uuid": "07e85c5c-9524-41e4-9e7d-586698ea67fa"
	    },
	    "host": "",
	    "level": "Easy",
	    "gameName": "test2",
	    "players": [
	        {
	            "playername": "testuser"
	        },
	        {
	            "playername": "rushin"
	        }
	    ]
	}
	 * 
	 * @author GreenTechies
	 * @param entity
	 * @return
	 */
	@Put
	public JsonRepresentation joinGame(Representation entity) {

		String dbURI = "mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		DB db = mongoClient.getDB("guessit");
		DBCollection gameCollection = db.getCollection("gameTable");

		 Form userForm = new Form(entity);
		 String gameId = userForm.getFirstValue("gameId");
		 String playername = userForm.getFirstValue("playername");
				 
	     DBObject foundGame = findGame(userForm.getFirstValue("gameId"));
	    
	        if (foundGame==null) {
	        	return new JsonRepresentation("Game Does Not Exists");
	        }
	        else{
	        	
	        	BasicDBObject updateQuery = new BasicDBObject();
	            updateQuery.put( "gameName", gameId );
	            
	            BasicDBObject updateCommand = new BasicDBObject();
	            HashMap<String, String> map = new HashMap<String, String>();
	            map.put("playername", playername);
	            updateCommand.put( "$push", new BasicDBObject( "players", map ) );
	            WriteResult result = gameCollection.update( updateQuery, updateCommand, true, true );
	        	
	            mongoClient.close();
	        }
        	return new JsonRepresentation("");
	}

	private DBObject findGame(String gameName) {
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
