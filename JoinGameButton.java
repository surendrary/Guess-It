import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
import javax.swing.JOptionPane;

/**
 * This class implens the beviour of 'Join Game' button.On clicking this button, user will be asked to enter a existing active game id in option pain.
 * Afters words a validation check will be done, if user enters a valid game id, then user will be connected to that game instance
 * 
 * 
 * @author Green Techies
 * @version 1.0
 */
public class JoinGameButton extends Actor
{
    
/**
     * Constructor for objects of class LessThanButton
     */
    public JoinGameButton()
    {
        GreenfootImage image = new GreenfootImage("join game.png");
        setImage(image);
    }

    public void act()
    {
      if(Greenfoot.mousePressed(this)){
           Greenfoot.playSound("button_click.mp3");
           String userName = JOptionPane.showInputDialog("Enter Game ID to join");
           if(userName.equals("")){
               JOptionPane.showMessageDialog(null, "Game id is mandatory to join a multiplayer game");
            }
        else{
            // check validation of entered game id
            }
      }
    }
    
}
