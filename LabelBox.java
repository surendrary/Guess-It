import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
 
public class LabelBox extends TextBox
{
    static final int NAME_INPUT_LENGTH = 40;
    String text = "";
    int inputNumber;
     
    public LabelBox()
    {
        updateImage(text);
        text = "";
    }
     
    private void updateImage(String text)
    {
        GreenfootImage image = new GreenfootImage(200, 30);
        image.setColor(Color.white);
        image.fill();
        GreenfootImage textImage = new GreenfootImage(text, 200, Color.black, null);
        image.drawImage(textImage, 200, 5);
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
            updateImage(text);
            return;
        }
}