import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
/**
 * Write a description of class MultiplayerHome here.
 * 
 * @author Rushin 
 * @version (a version number or a date)
 */
public class MultiplayerHome extends World
{
    String userName = "";
    /**
     * Constructor for objects of class MultiplayerHome.
     * 
     */
    public MultiplayerHome(String userName)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 650, 1);
        //this.playerName = playerName; 
        prepare();
        this.userName = userName;
       // setupGameTypeSelect();
    }
    
    private void prepare()
    {
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage); 
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        getBackground().drawString("GUESS IT", backgroundImage.getWidth()/2, 70);
        
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 30));
        getBackground().drawString("Please select one the options to initialize your game", 50, 170);
        
        Greenfoot.setSpeed(50);
        
        JoinGameButton joingame = new JoinGameButton();
        addObject(joingame,(backgroundImage.getWidth()/2)-100,backgroundImage.getHeight()+200);
    
        HostGameButton hostgame = new HostGameButton(userName);
        addObject(hostgame,(backgroundImage.getWidth()/2)+350,backgroundImage.getHeight()+200);
    
    }
}
