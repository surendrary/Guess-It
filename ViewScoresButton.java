import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ViewScoresButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ViewScoresButton extends Actor
{
    private String service_url = "https://guessit-webservice.herokuapp.com/rest/guessit/score";
     String gameName= "";
     public ViewScoresButton(String gameName)
    {
        GreenfootImage image = new GreenfootImage("viewscore.png");
        this.gameName = gameName;
        setImage(image);
    }

    public void act() 
    {
       if(Greenfoot.mousePressed(this)){
           Greenfoot.playSound("button_click.mp3");
           String updatedURL = service_url+"/"+gameName;
           Greenfoot.setWorld(new ScoreBoardWorld(updatedURL));
          }
        }
    }    

