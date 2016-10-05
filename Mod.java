import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mod extends Actor
{
    /**
     * Act - do whatever the Mod wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Mod()
    {
        GreenfootImage image = new GreenfootImage("division.png");
        image.scale(90,90);
        setImage(image);
    }
    
        public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          getWorldOfType(GamePlayWorld.class).operator="mod";
      }   
    }    
}
