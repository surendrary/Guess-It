import greenfoot.*;
import java.awt.Color;
 
public class Button extends Actor
{
    public Button()
    {
        GreenfootImage image = new GreenfootImage("play_button.png");
        image.scale(170,170);
        setImage(image);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new GamePlayWorld());
        } 
        if(Greenfoot.mousePressed(this)){
          Greenfoot.setWorld(new GamePlayWorld());
        }
    }
}