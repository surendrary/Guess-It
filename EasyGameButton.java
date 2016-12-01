import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;
import org.json.JSONObject;
import java.util.Random;

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
    //private static String service_url = "http://localhost:8080/TestGuessIt/rest/guessit/database";
    private static String service_url = "https://guessit-webservice.herokuapp.com/rest/guessit/database";
    /**
     * Constructor for objects of class EasyGameButton.
     * 
     */
    public EasyGameButton(String playerName,String gameName,boolean isMultiplayer, boolean isHost)
    {    
       this.playerName = playerName; 
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
        int guessedNumber = 80;
        if(Greenfoot.mousePressed(this)){
            Greenfoot.playSound("button_click.mp3");
            ClientResource guessDatabaseResource = new ClientResource(service_url);
            JSONObject obj = new JSONObject();
        if(this.isHost && this.isMultiplayer){
             obj.put("host", this.playerName);
         }
        else if(this.isMultiplayer){
             obj.put("host",this.playerName);
        }
        else{
            Random random = new Random();
            guessedNumber = random.nextInt(100)+2;
        }
        obj.put("level", "Easy");
        obj.put("gameName", this.gameName);
        try{
        Representation result = guessDatabaseResource.post(obj);
        String res = result.getText();
            if(res.contains("Error")){
            }
            else{
                guessedNumber = Integer.parseInt(res);
               }
        
        } 
         catch ( Exception e ) {
            e.printStackTrace(); 
         }         
        System.out.println("PLayerNAmeeasy="+this.playerName+"gamenameeasy="+this.gameName+"Multiplayereasy="+this.isMultiplayer+"hosteasy="+this.isMultiplayer);      
        Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"easy",getWorldOfType(GameLevelSelection.class).gameName,guessedNumber)); 
        }
    }   
}
