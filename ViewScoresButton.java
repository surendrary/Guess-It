import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ViewScoresButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ViewScoresButton extends Actor
{
     public ViewScoresButton()
    {
        GreenfootImage image = new GreenfootImage("viewscore.png");
        setImage(image);
    }

    public void act() 
    {
       if(Greenfoot.mousePressed(this)){
           Greenfoot.setWorld(new ScoreBoardWorld());
            Greenfoot.playSound("button_click.mp3");
           System.out.println("view score clicked");
            }
        }
    }    

