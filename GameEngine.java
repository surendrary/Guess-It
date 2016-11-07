import greenfoot.*;
import java.util.Random;
import javax.swing.JOptionPane;
/**import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;
import org.restlet.ext.json.JsonRepresentation;
*/
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
            //ClientResource gameEngineResource = new ClientResource(service_url); 
            //Representation result = gameEngineResource.get(); 
            //JsonRepresentation newResult = new JsonRepresentation(result);
            //computerGuess = (int)newResult.getJsonObject().get("guessedNumber");
            System.out.println("Guess is ::"+ computerGuess);
            } catch ( Exception e ) {
                 //
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
    
    public boolean query(){
        boolean queryResult = false;
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("Guessed Number ");
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
        getWorldOfType(GamePlayWorld.class).previousQueryResultMap.put(queryBuilder.toString(),queryResult);
        return queryResult;
    }
    
    
}
