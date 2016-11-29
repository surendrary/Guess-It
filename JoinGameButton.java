import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
import javax.swing.JOptionPane;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;
import org.json.JSONObject;

/**
 * This class implens the beviour of 'Join Game' button.On clicking this button, user will be asked to enter a existing active game id in option pain.
 * Afters words a validation check will be done, if user enters a valid game id, then user will be connected to that game instance
 * 
 * 
 * @author Green Techies
 * @version 1.0
 */
public class JoinGameButton extends Actor
{
    
     /**
     * Constructor for objects of class LessThanButton
     */
    private static String service_url = "https://guessit-webservice.herokuapp.com/rest/guessit/database";
    //private static String service_url = "http://localhost:8080/TestGuessIt/rest/guessit/database";
    boolean isMultiplayer;
    String playerName = "";
    boolean isHost;
    public JoinGameButton(String playerName)
    {
        GreenfootImage image = new GreenfootImage("join game.png");
        setImage(image);
        this.playerName=playerName;
    }

    public void act()
    {
        int guessedNumber = 80;
      if(Greenfoot.mousePressed(this)){
           Greenfoot.playSound("button_click.mp3");
           String gameName = JOptionPane.showInputDialog("Enter Game ID to join");
           if(gameName.equals("")){
               JOptionPane.showMessageDialog(null, "Game id is mandatory to join a multiplayer game");
            }
        else{    
        Greenfoot.playSound("button_click.mp3");
        ClientResource guessDatabaseResource = new ClientResource(service_url);
        JSONObject obj = new JSONObject();
        obj.put("playerName",this.playerName);
        obj.put("gameName",gameName);
        try{
        Representation result = guessDatabaseResource.put(obj);
        String res = result.getText();
            if(res.contains("Not")){
            }
            else{
                guessedNumber = Integer.parseInt(res);
             }
        }
         catch ( Exception e ) {
            e.printStackTrace(); 
         }       
        Greenfoot.setWorld(new GamePlayWorld(playerName,"easy",gameName,guessedNumber));
        }
      }
    }
    
}
