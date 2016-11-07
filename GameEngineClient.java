import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Creates and launches a HTTP client invoking the server listening on port
 * 8080, and writing the response entity on the console.
 */
public class GameEngineClient {
	
	private static String service_url = "http://localhost:8080/restlet/guessit";

	public static void main(String[] args) throws Exception {		
		ClientResource gameEngineResource = new ClientResource(service_url); 
        Representation result = gameEngineResource.get(); 
        JsonRepresentation newResult = new JsonRepresentation(result);
        int number = (int)newResult.getJsonObject().get("guessedNumber");
        System.out.println(number);
	}
}
