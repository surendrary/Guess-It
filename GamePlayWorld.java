import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;

/**
 * Write a description of class GamePlayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePlayWorld extends World
{

    String playerName = "";
    /**
     * Constructor for objects of class GamePlayWorld.
     * 
     */
    public GamePlayWorld(String playerName)
    {    
       super(850, 650, 1);
       this.playerName = playerName;
       setUpGame();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void setUpGame()
    {
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage); 
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        getBackground().drawString("GUESS IT", backgroundImage.getWidth()/2, 70);
        
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString(this.playerName+",start guessing!", (backgroundImage.getWidth()/2), 100);
        
        Greenfoot.setSpeed(50);
        LessThanButton LessThan=new LessThanButton();
        addObject(LessThan,100,200);
        GreaterThanButton GreaterThan=new GreaterThanButton();
        addObject(GreaterThan,250,200);
        
        GameEngine gameEngine = new GameEngine(this.playerName);
    }
}
