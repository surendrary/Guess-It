import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class QueryButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QueryButton extends Actor
{
    /**
     * Constructor for objects of class LessThanButton
     */
    public QueryButton()
    {
        GreenfootImage image = new GreenfootImage("query.png");
        setImage(image);
    }

    public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          GameEngine gameEngine = getWorldOfType(GamePlayWorld.class).gameEngine;
          gameEngine.chosedOperation = getWorldOfType(GamePlayWorld.class).operator;
          gameEngine.enterendInput = getWorldOfType(GamePlayWorld.class).enteredNumber;
          if(getWorldOfType(GamePlayWorld.class).operator == "" )
            JOptionPane.showMessageDialog(null, "Please select a operator");
          else{
          boolean isRightQuery = gameEngine.query();
          getWorldOfType(GamePlayWorld.class).numberOfGuess +=1;
          
          //gets the string box object and clears it for next input. @rushin
          StringInputBox sb=getWorldOfType(GamePlayWorld.class).getObjects(StringInputBox.class).get(0);
          sb.clearText();
          
          if(isRightQuery){
            Message sampleMessage = new Message();
            sampleMessage.setText("Right, Continue Guessing!!");
            getWorld().addObject(sampleMessage, 300, 300); 
            Greenfoot.delay(50);
            getWorld().removeObject(sampleMessage);
           }
          else{
            Message sampleMessage = new Message();
            sampleMessage.setText(" No, Continue Guessing!!");
            getWorld().addObject(sampleMessage, 300, 300);
            Greenfoot.delay(50);
            getWorld().removeObject(sampleMessage); 
            } 
          // Now Remove all static variable values and also clears the text filed 
          World world = getWorld();
          getWorldOfType(GamePlayWorld.class).operator = "";
          getWorldOfType(GamePlayWorld.class).enteredNumber =0;
        }
        }  
    }      
}
