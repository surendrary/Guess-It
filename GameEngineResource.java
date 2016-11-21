 
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Resource which has only one representation.
 */
@Path("/guessit")
public class GameEngineResource {

	@GET
	@Produces("application/json")
	public Response guessNumber() throws JSONException {
		int computerGuess = new Random().nextInt(100) + 2;
		System.out.println("Guessed Number :: " + computerGuess);
		JSONObject guess = new JSONObject();
		guess.put("guessedNumber", computerGuess);
		return Response.status(200).entity(guess.toString()).build();
	}

}
