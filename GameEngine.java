import greenfoot.*;
import java.util.Random;
import javax.swing.JOptionPane;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.json.JSONObject; 

/**
 * This is the central class for implenting the Game
 * 
 * @author Green Techies
 * @version 1.0
 */
public class GameEngine extends Actor 
{
    // instance variables - replace the example below with your own
    public int computerGuess;
    public static int enterendInput = 0;
    public static String chosedOperation = null;
    public String playerName = "";
    public String gameLevel="";
    private final String service_url = "http://localhost:8080/restlet/guessit";
    public static int maxTurns = 20;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine(String playerName, String gameLevel)
    {
      this.playerName = playerName;
      this.gameLevel =gameLevel;
      Random random = new Random();
      //if(gameLevel.equals("hard")){
      //computerGuess = random.nextInt(1000)+2;
      //}
      //else{
        //computerGuess = random.nextInt(100)+2;
      //}
      try {
          
           ClientResource resource = new ClientResource("http://guessit-webservice.herokuapp.com/rest/guessit");
           Representation repr = resource.get();
            JsonRepresentation jsonRepresentation = new JsonRepresentation(repr); 
            JSONObject jsonObj = jsonRepresentation.getJsonObject();
            String guess = jsonObj.get("guessedNumber").toString();
            computerGuess=Integer.parseInt(guess); 
         } 
         catch ( Exception e ) {
            e.printStackTrace(); 
         }
      getWorldOfType(GamePlayWorld.class).computerGuess = computerGuess; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void act()
    {
        //
    }
    
    public int query(int numberOfGuess){
        boolean queryResult = false;
        int resp = 0;
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("Guessed Number ");
        if(numberOfGuess>maxTurns){
            resp = 2;
        }
        else{
        switch(chosedOperation){
          case "gt":
           queryResult = (computerGuess > enterendInput);
           queryBuilder.append("> " + enterendInput);
           break;
          case "lt":
           queryResult = (computerGuess < enterendInput);
           queryBuilder.append("< " + enterendInput);
           break;
          case "mod":
           queryResult =(computerGuess % enterendInput) == 0;
           queryBuilder.append(" / by " + enterendInput);
           break;
        }
         if(queryResult)
            resp=1;
    }
        getWorldOfType(GamePlayWorld.class).previousQueryResultMap.put(queryBuilder.toString(),queryResult);
        return resp;
    }
    
    
}
