import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
 
public class Button extends Actor
{
    public Button()
    {
        GreenfootImage image = new GreenfootImage("play_button.png");
        //image.scale(170,170);
        setImage(image);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            String userName = JOptionPane.showInputDialog("Enter Name");
            Greenfoot.setWorld(new GamePlayWorld(userName));
        } 
        if(Greenfoot.mousePressed(this)){
           String userName = JOptionPane.showInputDialog("Enter Name");
           Greenfoot.setWorld(new GamePlayWorld(userName));
        }
    }
}