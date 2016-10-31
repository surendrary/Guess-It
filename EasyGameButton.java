import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EasyGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyGameButton extends Actor
{
    /**
     * Act - do whatever the EasyGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
          Greenfoot.playSound("button_click.mp3");
          Greenfoot.setWorld(new GamePlayWorld(getWorldOfType(GameLevelSelection.class).playerName,"easy"));
          }
    }   
}
