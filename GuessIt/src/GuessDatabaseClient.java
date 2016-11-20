import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Creates and launches a HTTP client invoking the server listening on port
 * 8080, and writing the response entity on the console.
 */

public class GuessDatabaseClient {
	private static String service_url = "http://localhost:8080/restlet/guessit/database";

	public static void main(String[] args) throws Exception {
		ClientResource guessDatabaseResource = new ClientResource(service_url);
		// Representation result = guessDatabaseResource.get();
		Form form = new Form();
		form.add("host", "sucheta");
		form.add("level", "Easy");
		form.add("gameName", "newGame123");

		Representation result = guessDatabaseResource.post(form);
		JsonRepresentation newResult = new JsonRepresentation(result);
		System.out.println(newResult);
	}

}
