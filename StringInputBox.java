import greenfoot.*;
import java.awt.Color;
 
public class StringInputBox extends Actor
{
    static final int NAME_INPUT_LENGTH = 20;
    String text = "";
     
    public StringInputBox()
    {
        updateImage();
        text = "";
    }
     
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(300, 30);
        image.setColor(Color.white);
        image.fill();
        GreenfootImage textImage = new GreenfootImage(text, 24, Color.black, null);
        image.drawImage(textImage, 30, 5);
        setImage(image);
    }
 
    public void act()
    {
        String key = Greenfoot.getKey();
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
       if (key == null) return;
        if ("enter".equals(key) && text.length() > 0)
        {
            System.out.println("You entered String "+text);
            text = "";
            updateImage();
            return;
        }
        if ("backspace".equals(key) && text.length() > 0) text = text.substring(0, text.length() - 1);
        if ("escape".equals(key)) text = "";
        if ("space".equals(key)) key = " ";
        if (key.length() == 1 && text.length() < NAME_INPUT_LENGTH ){
                        if( this.getX()-150 < mouse.getX() &&  mouse.getX() < this.getX()+150 && getWorld().getHeight()/2 > mouse.getY() && mouse.getY()> this.getY() -60)
                           text += key;                        
        }    
        updateImage();
    }
}