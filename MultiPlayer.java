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
    String userName = "";
       /**
     * Constructor for objectsof class LessThanButton
     */
    public MultiPlayer(String userName)
    {
        GreenfootImage image = new GreenfootImage("multi player.png");
        setImage(image);
        this.userName = userName;
        System.out.println(" Multi Plarer " + this.userName);
    }

    public void act()
    {
     if(Greenfoot.mousePressed(this)){
            Greenfoot.playSound("button_click.mp3");
            Greenfoot.setWorld(new MultiplayerHome(this.userName));
      }     
    }      
}



