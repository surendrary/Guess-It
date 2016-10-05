import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuessButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuessButton extends Actor
{
    /**
     * Constructor for objects of class LessThanButton
     */
    public GuessButton()
    {
        GreenfootImage image = new GreenfootImage("guess.png");
        setImage(image);
    }

    public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          getWorldOfType(GamePlayWorld.class).operator="guess";
        }   
    }  
}
