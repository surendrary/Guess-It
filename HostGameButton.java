import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HostGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HostGameButton extends Actor
{
    
      public HostGameButton()
    {
        GreenfootImage image = new GreenfootImage("host game.png");
        setImage(image);
    }

    /**
     * Act - do whatever the HostGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
      if(Greenfoot.mousePressed(this)){
           //Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameTypeSelect.class).playerName));
            //getWorldOfType(GameTypeSelect.class).gametype="single";
            System.out.println(" host game initiated");
            }
        }
    }
