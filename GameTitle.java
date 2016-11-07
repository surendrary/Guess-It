import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameTitle here.
 * 
 * @Green Techies
 * @version (a version number or a date)
 */
public class GameTitle extends Actor
{
    
    int dy=0;
    int g=1;  
    
    /**
     * 
     * Act - do whatever the GameTitle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GameTitle()
    {
        
        
        GreenfootImage image = new GreenfootImage("game_title_header.png");
        image.scale(400,150); 
        setImage(image);
        
        
    
    }
    
    public void act() 
    {
       
       if(stopfall()==true)
       {
           setLocation(getX()+dy,getY()+ dy);
           dy=dy+g; 
       } 
                   
        
    }  
    
    public boolean stopfall()
    {
        if(getY()>150)     
        {
         return false;
        }
        else
        {
         return true;
        }
    }
    
}
