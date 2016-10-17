import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
 
public class StringInputBox extends TextBox
{
    static final int NAME_INPUT_LENGTH = 3;
    String text = "";
    int inputNumber;
     
    public StringInputBox()
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
        String key = Greenfoot.getKey();
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
       if (key == null) return; 
       else if( this.getX()-150 < mouse.getX() &&  mouse.getX() < this.getX()+150 && getWorld().getHeight()/2 > mouse.getY() && mouse.getY()> this.getY() -60)
       {
           
           try{
               if ("backspace".equals(key) && text.length() > 0){
                   text = text.substring(0, text.length() - 1);
                   updateImage();
                }
               else if ("escape".equals(key)) key = "";
               else if ("space".equals(key)) key = "";
                else if ("enter".equals(key)) key = "";    
                else if(key.length() == 1){
                    inputNumber = Integer.parseInt(key);
                    if (text.length() < NAME_INPUT_LENGTH )
                        text += key;                        
                    updateImage();
                    inputNumber = Integer.parseInt(text);
                    getWorldOfType(GamePlayWorld.class).enteredNumber = inputNumber;    
                }
            }
            catch(NumberFormatException nfException){
                   JOptionPane.showMessageDialog(null, "Only integer input is allowed!");
            } 
        } 
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