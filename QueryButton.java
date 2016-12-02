import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;

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
        image.scale(90,90);
        setImage(image);
    }

    public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          GameEngine gameEngine = getWorldOfType(GamePlayWorld.class).gameEngine;
          gameEngine.chosedOperation = getWorldOfType(GamePlayWorld.class).operator;
          gameEngine.enterendInput = getWorldOfType(GamePlayWorld.class).enteredNumber;
          if(getWorldOfType(GamePlayWorld.class).operator == "" )
            JOptionPane.showMessageDialog(null, "Please select a operator");
          else if(gameEngine.enterendInput <1 )
            JOptionPane.showMessageDialog(null, "Please Enter a number");
          else{
          int isRightQuery = gameEngine.query((getWorldOfType(GamePlayWorld.class).numberOfGuess)+1);
          getWorldOfType(GamePlayWorld.class).numberOfGuess +=1;
          
          //gets the string box object and clears it for next input. @rushin
          StringInputBox sb=getWorldOfType(GamePlayWorld.class).getObjects(StringInputBox.class).get(0);
          sb.clearText();
          
          if(isRightQuery==1){
            Message sampleMessage = new Message();
            sampleMessage.setText("Right, Continue Guessing!!");
            getWorld().addObject(sampleMessage, 300, 300); 
            Greenfoot.delay(50);
            getWorld().removeObject(sampleMessage);
            getWorldOfType(GamePlayWorld.class).UpdateGuess();
           }
          else if(isRightQuery==0){
            Message sampleMessage = new Message();
            sampleMessage.setText(" No, Continue Guessing!!");
            getWorld().addObject(sampleMessage, 300, 300);
            Greenfoot.delay(50);
            List<Message> messageActors = getWorld().getObjects(Message.class);
            getWorld().removeObjects(messageActors);
            getWorldOfType(GamePlayWorld.class).UpdateGuess(); 
            } 
           else{
               Message sampleMessage = new Message();
                sampleMessage.setText("You lost!! Out of turns");
                getWorld().addObject(sampleMessage, 300, 300);
                Greenfoot.delay(100);
                List<Message> messageActors = getWorld().getObjects(Message.class);
                getWorld().removeObjects(messageActors);
                Greenfoot.setWorld(new GameOver()); 
               
               }
          // Now Remove all static variable values and also clears the text filed 
          World world = getWorld();
          getWorldOfType(GamePlayWorld.class).operator = "";
          getWorldOfType(GamePlayWorld.class).enteredNumber =0;
          LabelBox box = getWorldOfType(GamePlayWorld.class).getObjects(LabelBox.class).get(0);
          box.updateImage("");
          
          //Upadte Query Result
          QueryResultBox resultBox = getWorldOfType(GamePlayWorld.class).getObjects(QueryResultBox.class).get(0);
          StringBuilder queryTest = new StringBuilder();
          for(Map.Entry<String,Boolean> entrySet :getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet()){
              queryTest.append(entrySet.getKey() +" : "+entrySet.getValue());
              queryTest.append("\n");
            }
          resultBox.updateImage(queryTest.toString());  
        }
        }  
    }      
}
