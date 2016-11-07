import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @Green Techies 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(850, 650, 1); 
        setUp();
       
    }
    
    private void setUp()
    {
    
        GreenfootImage backgroundImage = new GreenfootImage("GameOver4.jpg");
        setBackground(backgroundImage);
        //GreenfootImage image = new GreenfootImage("GameOver.png");
        //setImage(image);
        CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
      
        
    }
}
