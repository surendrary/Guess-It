import greenfoot.*;
import java.awt.Color;
 
public class StringInputBox extends Actor
{
    static final int NAME_INPUT_LENGTH = 20;
    String text = "Enter your name";
     
    public StringInputBox()
    {
        updateImage();
        text = "";
    }
     
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(15*NAME_INPUT_LENGTH, 30);
        image.setColor(new Color(128, 0, 0));
        image.fill();
        image.setColor(Color.lightGray);
        //image.fillRect(3, 3, image.getWidth()-6, 24);
        GreenfootImage textImage = new GreenfootImage(text, 24, Color.black, null);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, 15-textImage.getHeight()/2);
        setImage(image);
    }
 
    public void act()
    {
        String key = Greenfoot.getKey();
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
        if (key.length() == 1 && text.length() < NAME_INPUT_LENGTH) text += key;
        updateImage();
    }
}