package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONException;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Creates and launches a HTTP client invoking the server listening on port
 * 8080, and writing the response entity on the console.
 */
public class GameEngineClient {

	/*
	 * private static String service_url =
	 * "http://localhost:8080/restlet/guessit";
	 * 
	 * public static void main(String[] args) throws Exception { ClientResource
	 * gameEngineResource = new ClientResource(service_url); Representation
	 * result = gameEngineResource.get(); JsonRepresentation newResult = new
	 * JsonRepresentation(result); int number =
	 * (int)newResult.getJsonObject().get("guessedNumber");
	 * System.out.println(number); }
	 */

	private static String service_url = "http://localhost:8080/TestGuessIt/rest/guessit/score/1234";

	public static void main(String[] args) throws JSONException, IOException {
		ClientResource resource = new ClientResource(service_url);
		Representation result = resource.get();
		ObjectMapper mapper = new ObjectMapper();
		List<Score> list = new ArrayList<Score>();
		list = mapper.readValue(result.getText(),
				TypeFactory.defaultInstance().constructCollectionType(List.class, Score.class));

		for (Score sc : list) {
			System.out.println(sc.getMoves()+ " " +sc.getTime()+" "+sc.getName());
		}
	}
}
