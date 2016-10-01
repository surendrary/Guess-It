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
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        getBackground().drawString("GUESS IT", backgroundImage.getWidth()/2, 70);
        Greenfoot.setSpeed(50);
        
        Button playButton = new Button();
        addObject(playButton,(backgroundImage.getWidth()/2)+100,backgroundImage.getHeight()+200);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GameDiagram gameDiagram = new GameDiagram();
        addObject(gameDiagram,410,319);
    }

public void act() 
    {
//String inputValue = JOptionPane.showInputDialog("Please input a name");
}
}