import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;
import org.json.JSONObject;

/**
 * Write a description of class HardGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardGameButton extends Actor
{
    String playerName = "";
    String level = "";
    boolean isMultiplayer;
    boolean isHost;
    String gameName= "";
    private static String service_url = "https://guessit-webservice.herokuapp.com/rest/guessit/database";
    
     /**
     * Constructor for objects of class EasyGameButton.
     * 
     */
    public HardGameButton(String playerName,String gameName,boolean isMultiplayer, boolean isHost)
    {    
       this.playerName = playerName; 
       System.out.println(this.playerName+" Hard Game button");
       this.gameName = gameName;
       this.isMultiplayer = isMultiplayer;
       this.isHost = isHost;
    }
    
    /**
     * Act - do whatever the HardGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            Greenfoot.playSound("button_click.mp3");
            ClientResource guessDatabaseResource = new ClientResource(service_url);
            JSONObject obj = new JSONObject();
        Form form = new Form();
        if(this.isHost && this.isMultiplayer){
             obj.put("host", this.playerName);
         }
        else if(this.isMultiplayer){
             obj.put("host",this.playerName);
        }
        obj.put("level", "Hard");
        obj.put("gameName", this.gameName);
        Representation result = guessDatabaseResource.post(obj);
        Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"hard",gameName));
        }
    }    
}
