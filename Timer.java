import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This is class is used to display time on game play world.Timer will be stoped when user clicks on 'Guess' button.(For Easy Mode)
 * It is under construction
 * 
 * @author Green Techies 
 * @version 1.0
 */
public class Timer extends Actor
{
    private int count; 
    private int initialCount;
    private boolean running;
    
    public Timer(int timeBeforeEvent, boolean getsStarted)
    {
        setTimer(timeBeforeEvent);
        updateImage();
        running = getsStarted;
    }
    
     public void setTimer(int timeBeforeEvent)
    {
        initialCount = 60 * timeBeforeEvent;
        count = -initialCount;
    }
    
    private void updateImage()
    {
        String prefix = "T - ";
        if (count >= 0) prefix = "T + ";
        int time = count * (int)Math.signum(count);
        time = time / 60;
        int secs = time % 60;
        time = (time - secs) / 60;
        int mins = time % 60;
        int hrs = (time - mins) / 24;
        String h = "00"+hrs;
        while (h.length() > 2) h = h.substring(1);
        String m = "00"+mins;
        while (m.length() > 2) m = m.substring(1);
        String s = "00" + secs;
        while (s.length() > 2) s = s.substring(1);
        String text = prefix + h + "h : " + m + "m : " + s + "s";
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.black, new Color(0, 0, 0, 0));
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+20, textImage.getHeight()+10);
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, (image.getHeight()-textImage.getHeight())/2);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (running)
        {
            count++;
            if ((count + initialCount) % 60 == 0) updateImage();
        }
    }  
    
    public int getTime()
    {
      return (count + initialCount) / 60 - initialCount / 60;
    }
 
    public void start()
    {
        running = true;
    }
 
    public void stop()
    {
        running = false;
    }
}
