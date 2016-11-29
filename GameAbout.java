import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;


/**
 * Write a description of class GameRules here.
 * 
 * @Green Techies 
 * @version (a version number or a date)
 */
public class GameAbout extends World
{

    /**
     * Constructor for objects of class GameRules.
     * 
     */
    public GameAbout()
    {    
        super(850, 650, 1); 
        setUp();
       
    }
    
     /**
     * Prepares the world.
     */
    private void setUp()
    {
    
        GreenfootImage backgroundImage = new GreenfootImage("about.jpg");
        setBackground(backgroundImage);
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 300, 30);
        Greenfoot.setSpeed(50);
       
        
        //Add a back button to back to game's main page
        BackButton backButton = new BackButton();
        addObject(backButton,35,backgroundImage.getHeight()+275);
        
        CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
        
    }
}