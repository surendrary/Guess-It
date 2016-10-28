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
    
    private void setUp()
    {
    
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage);
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 20, 10);
        Greenfoot.setSpeed(50);
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString("Binary search is an effective algorithm for finding an item from a sorted list.", 50, 200);
        getBackground().drawString("We start at the midpoint of the range and repeatedly divide the portion in half until we find the number", 50, 300);
        getBackground().drawString("We can guess a number between 0 and 100 in atmost 7 turns", 50, 400);
        getBackground().drawString("The number of guesses is equal to the log base 2 of the max number", 50, 500);
        
        //Add a back button to back to game's main page
        BackButton backButton = new BackButton();
        addObject(backButton,getWidth()/2-300,(getHeight()-565));
        
    }
}