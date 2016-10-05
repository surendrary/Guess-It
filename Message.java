/**
 * Write a description of class Message here.
 * 
 * @author Sucheta Mandal
 * @version 1.1
 */
import greenfoot.*;
import java.awt.Color;

public class Message extends Actor 
{
    private String messageText;

    private void updateMessageText()
    {
        setImage(new GreenfootImage(this.messageText, 30, Color.black, Color.green));
    }
    
    public void setText(String text){  
      this.messageText = text;
      updateMessageText();
    } 
}
