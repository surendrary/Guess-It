import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HostGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HostGameButton extends Actor
{
    String username ="";
    
      public HostGameButton(String username)
    {
        GreenfootImage image = new GreenfootImage("host game.png");
        setImage(image);
        this.username = username;
    }

    /**
     * Act - do whatever the HostGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
      if(Greenfoot.mousePressed(this)){
           Greenfoot.setWorld(new GameLevelSelection(username));
         }
        }
    }
