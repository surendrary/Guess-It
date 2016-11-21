import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class About here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class About extends Actor
{
    /**
     * Act - do whatever the About wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public About()
    {
        GreenfootImage image = new GreenfootImage("about.png");
        image.scale(40,40);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          Greenfoot.setWorld(new GameAbout());
          
    }    
}
}
/* The about page contains the description about the optimality algorithm */