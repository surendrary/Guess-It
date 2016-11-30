import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;


/**
 * Write a description of class GuessButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuessButton extends Actor
{
    //private static String service_url = "http://localhost:8080/TestGuessIt/rest/guessit/score";
        private static String service_url = "https://guessit-webservice.herokuapp.com/rest/guessit/score";
    /**
     * Constructor for objects of class LessThanButton
     */
    public GuessButton()
    {
        GreenfootImage image = new GreenfootImage("guess.png");
        image.scale(90,90);
        setImage(image);
    }

    public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          if(getWorldOfType(GamePlayWorld.class).backgroundMusic!=null){
             getWorldOfType(GamePlayWorld.class).backgroundMusic.stop();
         }
         
         //clearing the hashmap
                //for(Map.Entry<String,Boolean> entrySet :getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet())
                QueryResultBox resultBox = getWorldOfType(GamePlayWorld.class).getObjects(QueryResultBox.class).get(0);
                StringBuilder queryTest = new StringBuilder(); 
                for(Iterator<Map.Entry<String,Boolean>> it =getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet().iterator();it.hasNext();)
                 {
                     Map.Entry<String,Boolean> entry = it.next();
                     it.remove();
                     System.out.println("a key removed");
                    }
                 resultBox.updateImage(queryTest.toString());
                
         
         
         
         
          Greenfoot.playSound("button_click.mp3");
          getWorldOfType(GamePlayWorld.class).operator="guess";
          GameEngine gameEngine = getWorldOfType(GamePlayWorld.class).gameEngine;
          gameEngine.enterendInput = getWorldOfType(GamePlayWorld.class).enteredNumber;
          gameEngine.computerGuess = getWorldOfType(GamePlayWorld.class).computerGuess;
          
          System.out.println("gameEngine.computerGuess"+gameEngine.computerGuess+"gameEngine.enterendInput"+gameEngine.enterendInput);
          int numberOfGuess = getWorldOfType(GamePlayWorld.class).numberOfGuess;
          String playerName = getWorldOfType(GamePlayWorld.class).playerName;
          String gameName = getWorldOfType(GamePlayWorld.class).gameName;
          int time = getWorldOfType(GamePlayWorld.class).time_elapsed;
          if(gameEngine.enterendInput <1 )
            JOptionPane.showMessageDialog(null, "Please Enter a number to guess");
          else if(gameEngine.enterendInput==gameEngine.computerGuess){
              
            //fetch time taken by the user to make the right guess
            System.out.println("Time taken: "+ getWorldOfType(GamePlayWorld.class).time_elapsed + " seconds");
            
            
            Message sampleMessage = new Message();
            Greenfoot.playSound("congratulations.mp3");
            sampleMessage.setText("Cogratulations!!!!.Your Guess is Right");
            getWorld().addObject(sampleMessage, 300, 300);
            ClientResource guessDatabaseResource = new ClientResource(service_url);
            JSONObject obj = new JSONObject();
            Form form = new Form();
            
            obj.put("playerName", playerName);
            obj.put("gameName", gameName);
            obj.put("turns", numberOfGuess);
            obj.put("time", getWorldOfType(GamePlayWorld.class).time_elapsed);
            
            Representation result = guessDatabaseResource.post(obj);
            
            Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"hard",gameName,2));
            
            
          }
          else{
              
            Message sampleMessage = new Message();
            sampleMessage.setText("Sorry. Your guess is wrong");
            getWorld().addObject(sampleMessage, 300, 300);
            Greenfoot.delay(50);
            getWorld().removeObject(sampleMessage);
            Greenfoot.setWorld(new GameOver());
            
            
          }
          LabelBox box = getWorldOfType(GamePlayWorld.class).getObjects(LabelBox.class).get(0);
          box.updateImage("");
        }   
    }  
}
