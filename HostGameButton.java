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
    private ConcreteCommand command; 
      public HostGameButton(String playerName,boolean isMultiplayer, boolean isHost)
    {
        GreenfootImage image = new GreenfootImage("host game.png");
        setImage(image);
        this.username = playerName;
    }

    /**
     * Act - do whatever the HostGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
      if(Greenfoot.mousePressed(this)){
          command = new ConcreteCommand();
            command.setReceiver(new HostButtonReceiver(username));
            
            InvokerImpl in = new InvokerImpl();
            in.setCommand(command);
            
            in.invoke(); 
          
      }
    }
    }
