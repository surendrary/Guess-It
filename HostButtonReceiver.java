import greenfoot.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class MainButtonReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HostButtonReceiver implements Receiver
{
    String username=""; 
    // instance variables - replace the example below with your own
    HostButtonReceiver(String Username)
    {
     this.username=Username;
    }
    public void doAction(){
        
        String gameName = JOptionPane.showInputDialog("Enter Game ID to host");
           if(gameName.equals("")){
               JOptionPane.showMessageDialog(null, "Game id is mandatory to host a multiplayer game");
            }
           else{
               System.out.println("Newly Added Text "+username);
               Greenfoot.setWorld(new GameLevelSelection(username,true,true,gameName)); 
           
        }
        
    }
}
