import greenfoot.*;

/**
 * Write a description of class Diag1 here.
 * 
 * @author Green Techies 
 * @version 1.1
 */
public class GameDiagram  extends Actor 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Diag1
     */
    public GameDiagram()
    {
        GreenfootImage image = new GreenfootImage("image_operands.png");
        setImage(image);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
