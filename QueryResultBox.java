import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QueryResultBox here.
 * 
 * @author Green Techies
 * @version 1.0
 */
public class QueryResultBox extends TextBox
{
    /**
     * Act - do whatever the QueryResultBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public QueryResultBox(){
        updateImage(text);
        text = "";
    }
    
    public void updateImage(String text)
    {
        GreenfootImage image = new GreenfootImage(300, 300);
        image.setColor(Color.white);
        image.fill();
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.red, null);
        image.drawImage(textImage, 20, 5);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
