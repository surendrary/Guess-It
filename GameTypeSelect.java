import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
/**
 * Write a description of class GameTypeSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


// @rushin
public class GameTypeSelect extends World
{
    public static String gametype="single";
    String playerName = "";
    
    /**
     * Constructor for objects of class GameTypeSelect.
     * 
     */
    public GameTypeSelect(String playerName)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 650, 1);
        this.playerName = playerName; 
        prepare();
       // setupGameTypeSelect();
    }
    
    private void prepare()
    {
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage); 
        //getBackground().setColor(Color.red);
        //getBackground().setFont(new Font("", Font.BOLD, 50));
        //getBackground().drawString("GUESS IT", backgroundImage.getWidth()/2, 70);
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 20, 10);
        Greenfoot.setSpeed(50);
        
        SinglePlayer singleplayerbutton = new SinglePlayer();
        addObject(singleplayerbutton,(backgroundImage.getWidth()/2)-100,backgroundImage.getHeight()+200);
    
        MultiPlayer multiplayerbutton = new MultiPlayer(playerName);
        addObject(multiplayerbutton,(backgroundImage.getWidth()/2)+350,backgroundImage.getHeight()+200);
        
        CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
       
    }
}
