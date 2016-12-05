import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;


/**
 * Write a description of class MyWorld here.
 * 
 * @author Green Techies 
 * @version 1.0
 */
public class GuessItWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GuessItWorld()
    {    
        super(850 , 650, 1); 
        setUpGame();
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void setUpGame()
    {
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage); 
        Greenfoot.setSpeed(50);
    }
    
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
    
    public void started()
    {
        GameTitle gametitle=new GameTitle(); 
        addObject(gametitle,307 ,0);
        Button playButton = new Button();
        addObject(playButton,400,1000); 
        
        GameDiagram gameDiagram = new GameDiagram();
        addObject(gameDiagram,410,0); 
        
        Rules rules = new Rules();
        addObject(rules,25,30);
        
        About about = new About();
        addObject(about,70,30);
    }
    
    

public void act() 
    {
        
    }
}