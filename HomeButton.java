import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeButton extends Actor
{
    /**
     * Act - do whatever the HomeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public HomeButton(){
        GreenfootImage image = new GreenfootImage("home_button.png");
        //image.scale(60,60);
        setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
         MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          World world = getWorld();
          GuessItWorld w=new GuessItWorld();
          w.started();
          Greenfoot.setWorld(w);       
               
    }    
}
}