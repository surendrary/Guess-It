import greenfoot.*;
/**
 * Write a description of class LessThanButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LessThanButton extends Actor
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class LessThanButton
     */
    public LessThanButton()
    {
        GreenfootImage image = new GreenfootImage("less than.png");
        setImage(image);
    }

        public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          getWorldOfType(GamePlayWorld.class).operator="lt";
          LabelBox box = getWorldOfType(GamePlayWorld.class).getObjects(LabelBox.class).get(0);
          box.updateImage("Less Than");
        }   
    }
}
