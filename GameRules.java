import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;


/**
 * Write a description of class GameRules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameRules extends World
{

    /**
     * Constructor for objects of class GameRules.
     * 
     */
    public GameRules()
    {    
        super(850, 650, 1); 
        setUp();
       
    }
    
    private void setUp()
    {
    
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage);
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 20, 10);
        Greenfoot.setSpeed(50);
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString("The computer will pick a unique number.", 50, 200);
        getBackground().drawString("Use your logic to guess the secret number.", 50, 300);
        getBackground().drawString("If the numbers don't match, the computer will give you a hint!", 50, 400);
        getBackground().drawString("Let's see how many turns it takes for you to win.", 50, 500);
        
        //Add a back button to back to game's main page
        BackButton backButton = new BackButton();
        addObject(backButton,getWidth()/2-300,(getHeight()-565));
        
        CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
        
    }
}