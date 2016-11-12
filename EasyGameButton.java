import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;

/**
 * Write a description of class EasyGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyGameButton extends Actor
{
    
    String playerName = "";
    String level = "";
    boolean isMultiplayer;
    boolean isHost;
    String gameName= "";
    private static String service_url = "http://localhost:8080/restlet/guessit/database";
 
    /**
     * Constructor for objects of class EasyGameButton.
     * 
     */
    public EasyGameButton(String playerName,String gameName,boolean isMultiplayer, boolean isHost)
    {    
       this.playerName = playerName; 
       System.out.println(this.playerName+" Easy Game button");
       this.gameName = gameName;
       this.isMultiplayer = isMultiplayer;
       this.isHost = isHost;
    }
    
    
    /**
     * Act - do whatever the EasyGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            Greenfoot.playSound("button_click.mp3");
            ClientResource guessDatabaseResource = new ClientResource(service_url);
		// Representation result = guessDatabaseResource.get();
		Form form = new Form();
		if(this.isHost && this.isMultiplayer){
		     form.add("host", this.playerName);
         }
        else if(this.isMultiplayer){
             form.add("host",this.playerName);
        }
		form.add("level", "Easy");
		form.add("gameName", this.gameName);
		Representation result = guessDatabaseResource.post(form);
        Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"easy"));
        }
    }   
}
