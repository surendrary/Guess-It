import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SinglePlayer here.
 * 
 * @GreenTechies 
 * @version (a version number or a date)
 */

//@rushin
public class SinglePlayer extends Actor
{
     /**
     * Constructor for objects of class LessThanButton
     */
    public SinglePlayer()
    {
        GreenfootImage image = new GreenfootImage("single player.png");
        setImage(image);
    }

    public void act()
    {
      if(Greenfoot.mousePressed(this)){
          Greenfoot.playSound("button_click.mp3");
          Greenfoot.setWorld(new GameLevelSelection(getWorldOfType(GameTypeSelect.class).playerName,false,true,"singlePlayerGame"));
        }
    }
}



