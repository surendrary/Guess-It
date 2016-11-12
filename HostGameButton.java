import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class HostGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HostGameButton extends Actor
{
    String username ="";
    String gameName ="";
    
      public HostGameButton(String playerName,boolean isMultiplayer, boolean isHost)
    {
        GreenfootImage image = new GreenfootImage("host game.png");
        setImage(image);
        this.username = username;
        System.out.println(" Host button " + this.username);
        this.gameName = gameName;
    }

    /**
     * Act - do whatever the HostGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
      if(Greenfoot.mousePressed(this)){
          String gameName = JOptionPane.showInputDialog("Enter Game ID to host");
           if(gameName.equals("")){
               JOptionPane.showMessageDialog(null, "Game id is mandatory to host a multiplayer game");
            }
           Greenfoot.setWorld(new GameLevelSelection(username,true,true,gameName));
      }
    }
    }
