import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MultiPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//@rushin
public class MultiPlayer extends Actor
{
       /**
     * Constructor for objectsof class LessThanButton
     */
    public MultiPlayer()
    {
        GreenfootImage image = new GreenfootImage("multi player.png");
        setImage(image);
    }

    public void act()
    {
     if(Greenfoot.mousePressed(this)){
            Greenfoot.playSound("button_click.mp3");
            Greenfoot.setWorld(new MultiplayerHome());
      }     
    }      
}



