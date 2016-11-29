import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;
import org.json.JSONObject;
/**
 * Write a description of class GuessButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuessButton extends Actor
{
    private static String service_url = "http://localhost:8080/TestGuessIt/rest/guessit/score";
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
          Greenfoot.playSound("button_click.mp3");
          getWorldOfType(GamePlayWorld.class).operator="guess";
          GameEngine gameEngine = getWorldOfType(GamePlayWorld.class).gameEngine;
          gameEngine.enterendInput = getWorldOfType(GamePlayWorld.class).enteredNumber;
          gameEngine.computerGuess = getWorldOfType(GamePlayWorld.class).computerGuess;
          int numberOfGuess = getWorldOfType(GamePlayWorld.class).numberOfGuess;
          String playerName = getWorldOfType(GamePlayWorld.class).playerName;
          String gameName = getWorldOfType(GamePlayWorld.class).gameName;
          if(gameEngine.enterendInput <1 )
            JOptionPane.showMessageDialog(null, "Please Enter a number to guess");
          else if(gameEngine.enterendInput==gameEngine.computerGuess){
            Message sampleMessage = new Message();
            Greenfoot.playSound("congratulations.mp3");
            sampleMessage.setText("Cogratulations!!!!.Your Guess is Right");
            getWorld().addObject(sampleMessage, 300, 300);
            ClientResource guessDatabaseResource = new ClientResource(service_url);
            JSONObject obj = new JSONObject();
            Form form = new Form();
            
            obj.put("playerName", playerName);
            obj.put("gameName", gameName);
            obj.put("numberOfGuess", numberOfGuess);
            
            Representation result = guessDatabaseResource.post(obj);
            
            Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"hard"));
            
            
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
