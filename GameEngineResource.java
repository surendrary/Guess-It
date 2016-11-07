/**import java.util.Random;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
*/
/**
 * Resource which has only one representation.
 */
/**
public class GameEngineResource extends ServerResource {

	@Get
	public JsonRepresentation represent() {
		int computerGuess = new Random().nextInt(100) + 2;
		System.out.println("Guessed Number :: " + computerGuess);
		JSONObject guess = new JSONObject();
		guess.put("guessedNumber", computerGuess);
		return new JsonRepresentation(guess);
	}

}*/
