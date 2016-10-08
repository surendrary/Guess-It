import greenfoot.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This is the central class for implenting the Game
 * 
 * @author Green Techies
 * @version 1.0
 */
public class GameEngine extends Actor 
{
    // instance variables - replace the example below with your own
    private int computerGuess;
    public static int enterendInput;
    public static String chosedOperation = null;
    public String playerName = "";

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine(String playerName)
    {
      this.playerName = playerName;
      Random random = new Random();
      computerGuess = random.nextInt(100)+2;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void act()
    {
        //
    }
    
    public boolean query(){
        boolean queryResult = false;
        JOptionPane.showMessageDialog(null, "Only integer input is allowed! " + chosedOperation +" "+ enterendInput);
        switch(chosedOperation){
          case "gt":
           queryResult = (enterendInput > computerGuess);
           break;
          case "lt":
           queryResult = (enterendInput < computerGuess);
           break;
          case "mod":
           queryResult =(computerGuess % enterendInput) == 0;
           break;
        }
        return queryResult;
    }
    
    
}