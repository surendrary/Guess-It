import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
import javax.swing.JOptionPane;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;

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
    private static String service_url = "http://localhost:8080/restlet/guessit/database";
     boolean isMultiplayer;
     String playerName = "";
    boolean isHost;
    public JoinGameButton(String playerName)
    {
        GreenfootImage image = new GreenfootImage("join game.png");
        System.out.println(this.playerName+"Join Button ");
        setImage(image);
        System.out.println(playerName);
        this.playerName=playerName;
    }

    public void act()
    {
      if(Greenfoot.mousePressed(this)){
           Greenfoot.playSound("button_click.mp3");
           String userName = JOptionPane.showInputDialog("Enter Game ID to join");
           if(userName.equals("")){
               JOptionPane.showMessageDialog(null, "Game id is mandatory to join a multiplayer game");
            }
        else{
           
        Greenfoot.playSound("button_click.mp3");
        ClientResource guessDatabaseResource = new ClientResource(service_url);
        Form form = new Form(); 
        form.add("playername",this.playerName);
            form.add("gameId",userName);
		Representation result = guessDatabaseResource.put(form);
		System.out.println("Helllo");
        Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"easy"));
         }
      }
    }
    
}
