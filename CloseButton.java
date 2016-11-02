import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseButton extends Actor
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CloseButton(){
        GreenfootImage image = new GreenfootImage("close.png");
        image.scale(30,30);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          String message= "Do you really want to quit?";
          String title= "CONFIRM TO QUIT !!!";
          //Displaying confirmation dialog box. @rushin
          int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
          if (reply == JOptionPane.YES_OPTION)
          {
              System.exit(0); 
            }
          else
          {
            
            }
    }   
    }
}
