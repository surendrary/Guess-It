import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;

/**
 * Write a description of class GamePlayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePlayWorld extends World
{

    String playerName = "";
    public static String operator = ""; // select operators i.e. >,<,/
    public static int enteredNumber = 0;
    public static int computerGuess;
    public static StringInputBox inputBox= new StringInputBox();
    public static LabelBox label= new LabelBox();
    public static GameEngine gameEngine= null;
    public static int numberOfGuess = 0;
    
    /**
     * Constructor for objects of class GamePlayWorld.
     * 
     */
    public GamePlayWorld(String playerName)
    {    
       super(850, 650, 1);
       this.playerName = playerName; 
       setUpGame();
    }
    
	 //
    public void updateGuessNumber()
    {
        this.numberOfGuess+=1;
        System.out.println("new value:"+this.numberOfGuess);
    }
    
    public int getnumberguess()
    {
        return this.numberOfGuess;
    }
    
	
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void setUpGame()
    {
        GreenfootImage backgroundImage = new GreenfootImage("home_page_Background.jpg");
        setBackground(backgroundImage); 
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        getBackground().drawString("GUESS IT", backgroundImage.getWidth()/2, 70);
        
        //RUSHIN-----------------------------for name in top left
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString(this.playerName,5,30);
        getBackground().drawLine(0,35,100,35);
        getBackground().drawLine(100,0,100,35);
        
        //For GuessCounter
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString("Guess"+this.getnumberguess(),getWidth()-200,30);
         

        
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString(this.playerName+",start guessing!", (backgroundImage.getWidth()/2), 100);
        
        Greenfoot.setSpeed(50);
        LessThanButton LessThan=new LessThanButton();
        addObject(LessThan,100,200);
        GreaterThanButton GreaterThan=new GreaterThanButton();
        addObject(GreaterThan,250,200);
        Equals equals = new Equals();
        addObject(equals, 400, 200);
        Mod mod = new Mod();
        addObject(mod,550,200);
        
        label = new LabelBox();
        addObject(label, getWidth()/2-150, (getHeight()/2)-50);
        
        inputBox = new StringInputBox();
        addObject(inputBox, getWidth()/2-10, (getHeight()/2)-50);
        
        //Add guess and Query button
        QueryButton  queryButton = new QueryButton();
        addObject(queryButton,getWidth()/4,(getHeight()-150));
        
        GuessButton guessButton = new GuessButton();
        addObject(guessButton,(3*getWidth())/4,(getHeight()-150));
        
        gameEngine = new GameEngine(this.playerName);
        
        //update number to zero on lo
        this.numberOfGuess = 0;
    }
}
    