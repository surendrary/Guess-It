import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
 
public class Button extends Actor
{
    public Button()
    {
        GreenfootImage image = new GreenfootImage("play_button.png");
        setImage(image);
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
           String userName = JOptionPane.showInputDialog("Enter Name");
           if(userName.equals("")){
               JOptionPane.showMessageDialog(null, "Username is mandatory to start game");
            }
        else{
            Greenfoot.setWorld(new GamePlayWorld(userName));
            }
        }
    }
}