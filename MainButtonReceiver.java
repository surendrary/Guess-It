import greenfoot.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class MainButtonReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainButtonReceiver  implements Receiver
{
    // instance variables - replace the example below with your own
    public void doAction(){
        Greenfoot.playSound("button_click.mp3");
           String userName = JOptionPane.showInputDialog("Enter Name");
           if(userName==null || userName.equals("")){
               JOptionPane.showMessageDialog(null, "Username is mandatory to start game");
            }
        else{
            Greenfoot.setWorld(new GameTypeSelect(userName));
            }
         
    }
}
     