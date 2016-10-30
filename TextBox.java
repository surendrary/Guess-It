import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
 /**
  * This is the textbox class which is inherited by all the text boxes that are
  * a part of game. 
  */
public class TextBox extends Actor
{
    static int NAME_INPUT_LENGTH = 20;
    String text = "";
    int inputNumber;
     
    public TextBox()
    {
        updateImage();
        text = "";
    }
     
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(60, 30);
        image.setColor(Color.white);
        image.fill();
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.black, null);
        image.drawImage(textImage, 20, 5);
        setImage(image);
    }
 
    public void act()
    {
        
    }
    
     /**
     *@rushin 
     * Function to clear text once the search button has been clicked
    */
    public void clearText()
    {
            text = "";
            updateImage();
            return;
        }
}