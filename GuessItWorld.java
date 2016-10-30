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
        super(850, 650, 1); 
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
        //getBackground().setColor(Color.red);
        //getBackground().setFont(new Font("", Font.BOLD, 50));
        //getBackground().drawString("GUESS IT", 
        //GreenfootImage game_Name = new GreenfootImage("game_title.png");
        //addObject(game_Name,backgroundImage.getWidth()/2, 70);
        // getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 85, 20);
        Greenfoot.setSpeed(50);
        
        //Button playButton = new Button();
        //addObject(playButton,(backgroundImage.getWidth()/2)+100,backgroundImage.getHeight()+200);
        
        Rules rules = new Rules();
        addObject(rules,getWidth()/2-300,(getHeight()-565));
        
        About about = new About();
        addObject(about,getWidth()/2-250,(getHeight()-565));
        
        
        
        
    }
    
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GameDiagram gameDiagram = new GameDiagram();
        addObject(gameDiagram,410,319);
        //GameTitle gametitle=new GameTitle();
        //addObject(gametitle,307 ,0); 
    }
    
    public void started()
    {
    
        GameTitle gametitle=new GameTitle(); 
        addObject(gametitle,307 ,0);
        //Greenfoot.delay(10);
        Button playButton = new Button();
        addObject(playButton,0 ,550); 
        
    }
    
    

public void act() 
    {
        
    }
}