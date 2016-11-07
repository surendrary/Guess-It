import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
/**
 * ScoreBoardWorld is the greenfoot world where the final scoreboard is displayed.
 * 
 * @Green Techies
 * @version (a version number or a date)
 */


public class ScoreBoardWorld extends World
{
    /**
     * Constructor for objects of class ScoreBoardWorld.
     * 
     */
    public ScoreBoardWorld()
    {    
        super(850, 650, 1);
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
        getBackground().drawString("High Scores :", backgroundImage.getWidth()/2, 140);
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 20, 10);
        Greenfoot.setSpeed(50);
        
        CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
        
    
}
}
