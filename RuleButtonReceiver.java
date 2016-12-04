import greenfoot.*;
/**
 * Write a description of class RuleButtonReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RuleButtonReceiver implements Receiver
{ 
    RuleButtonReceiver()
    {
   
    }
    public void doAction(){
       
          Greenfoot.playSound("button_click.mp3");
          Greenfoot.setWorld(new GameRules());
    

    
}
}
