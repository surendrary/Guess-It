import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.data.Form;
import org.json.JSONObject;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONException;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
/**
 * ScoreBoardWorld is the greenfoot world where the final scoreboard is displayed.
 * 
 * @Green Techies
 * @version (a version number or a date)
 */


public class ScoreBoardWorld extends World
{
    private String service_url = null;
    /**
     * Constructor for objects of class ScoreBoardWorld.
     * 
     */
    public ScoreBoardWorld(String service_url)
    {    
        super(850, 650, 1);
        this.service_url = service_url;
        prepare();
     
    }
    
    /**
     * Prepares the world.
     */
     private void prepare()
    {
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage); 
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 20, 10);
        Greenfoot.setSpeed(50);
        
        CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
        
        //Display Scores from server
        ClientResource scoreResouce = new ClientResource(service_url);
        try{
        Representation result = scoreResouce.get();
        String res = result.getText();
		ObjectMapper mapper = new ObjectMapper();
		List<Score> list = new ArrayList<Score>();
		list = mapper.readValue(res,
				TypeFactory.defaultInstance().constructCollectionType(List.class, Score.class));
		int x = 50;
		int y =200;

		int count = 1;
		 for (Score sc : list) {
			getBackground().setFont(new Font("", Font.BOLD, 25));
			getBackground().drawString(count++ + ". Name: " + sc.getName()+" || Moves: "+sc.getMoves()+ " || Time: " +sc.getTime(),x,y);
			y = y +50;
		   }  
		
        } 
         catch ( Exception e ) {
            e.printStackTrace(); 
         } 
}
}
