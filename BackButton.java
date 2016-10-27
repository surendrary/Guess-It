import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BackButton(){
        GreenfootImage image = new GreenfootImage("back_button.png");
        image.scale(60,60);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          Greenfoot.setWorld(new GuessItWorld());
          
    }   
    }
}
