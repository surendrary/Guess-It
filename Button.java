import greenfoot.*;
import java.awt.Color;
 
public class Button extends Actor
{
    public Button()
    {
        addImage("Begin to play...");
    }
     
    
    public void setText(String text)
    {
        addImage("Begin to play...");
    }
     
    private void addImage(String text)
    {
        setImage(new GreenfootImage("Begin to play...", 25, Color.white, Color.black ));
    }
    
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            
        } 
        if(Greenfoot.mousePressed(this)){
         
        }
    }
}