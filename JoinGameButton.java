import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
/**
 * Write a description of class JoinGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
           //Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameTypeSelect.class).playerName));
           //getWorldOfType(GameTypeSelect.class).gametype="single";
           System.out.println(" join game initiated");
            }
        }
    
}
