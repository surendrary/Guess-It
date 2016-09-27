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

    /**
     * Constructor for objects of class GamePlayWorld.
     * 
     */
    public GamePlayWorld()
    {    
       super(850, 650, 1); 
       setUpGame();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void setUpGame()
    {
        setBackground(new GreenfootImage("home_page_Background.jpg"));   
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        getBackground().drawString("Guess It!!", 380, 70);
        Greenfoot.setSpeed(50);
    }
}
