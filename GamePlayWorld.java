import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class GamePlayWorld here.
 * 
 * @author Green Techies
 * @version 1.0
 */
public class GamePlayWorld extends World
{

    String playerName = "";
    String gameLevel = "";
    public static String operator = ""; // select operators i.e. >,<,/
    public static int enteredNumber = 0;
    public static int computerGuess;
    public static StringInputBox inputBox= new StringInputBox();
    public static LabelBox label= new LabelBox();
    public static GameEngine gameEngine= null;
    public static int numberOfGuess = 0;
    public static QueryResultBox queryResultBox = new QueryResultBox();
    public static Map<String,Boolean> previousQueryResultMap = new HashMap<String,Boolean>();
    
    /**
     * Constructor for objects of class GamePlayWorld.
     * 
     */
    public GamePlayWorld(String playerName,String gameLevel)
    {    
       super(850, 650, 1);
       this.playerName = playerName; 
       this.gameLevel = gameLevel;
       setUpGame();
    }
    
     //
    /*public void updateGuessNumber()
    {
        this.numberOfGuess+=1;
        System.out.println("new value:"+this.numberOfGuess);
    }*/
    
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
        //getBackground().setColor(Color.red);
        //getBackground().setFont(new Font("", Font.BOLD, 50));
        //getBackground().drawString("GUESS IT", backgroundImage.getWidth()/2, 70);
        GreenfootImage game_Name = new GreenfootImage("game_title_header.png");
        getBackground().drawImage(game_Name, backgroundImage.getWidth()/2 - 85, 10);
        
        //RUSHIN-----------------------------for name in top left
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString(this.playerName,5,30);
        getBackground().drawLine(0,35,100,35);
        getBackground().drawLine(100,0,100,35);
        
        Message Score = new Message();
        Score.setImage(new GreenfootImage("Guess: " + numberOfGuess, 34, Color.RED, Color.BLACK));
        this.addObject(Score,getWidth()-100,30);
        
       // getBackground().setFont(new Font("", Font.BOLD, 25));
       //getBackground().drawString(this.playerName+",start guessing!", backgroundImage.getWidth()/2 - 50, 120);
        
        Greenfoot.setSpeed(50);
        LessThanButton LessThan=new LessThanButton();
        addObject(LessThan,100,200);
        GreaterThanButton GreaterThan=new GreaterThanButton();
        addObject(GreaterThan,250,200);
        Mod mod = new Mod();
        addObject(mod,400,200);
        
       CloseButton closebutton = new CloseButton();
        addObject(closebutton,getWidth()/2+410,(getHeight()-640));
        
        label = new LabelBox();
        addObject(label, getWidth()/2-230, (getHeight()/2)+10);
        ////
        inputBox = new StringInputBox();
        addObject(inputBox, getWidth()/2-50, (getHeight()/2)+ 10);
        
        //Add guess and Query button
        QueryButton  queryButton = new QueryButton();
        addObject(queryButton,getWidth()/2-290,(getHeight()-200));
        
        GuessButton guessButton = new GuessButton();
        addObject(guessButton,getWidth()/2-80,(getHeight()-200));
        
        
        //Add lebel "Previous Query"
        Message queryResult = new Message();
        queryResult.setImage(new GreenfootImage("Previous Query Result", 25, Color.RED, Color.BLACK));
       this.addObject(queryResult,getWidth()-200,getHeight()-465);
        
        //Add Text Area to track previous queries
        addObject(queryResultBox, getWidth()-200, getHeight()-300);
        
        gameEngine = new GameEngine(this.playerName,this.gameLevel);
        
        //update number to zero on load
        this.numberOfGuess = 0;
        
        
        //rushin
        BackButton bb = new BackButton();
        addObject(bb,(backgroundImage.getWidth()/2)+350,backgroundImage.getHeight()+275);
        
    }
    
    public void UpdateGuess(){ 
    
        Message Score = new Message();
        Score.setImage(new GreenfootImage("Guess : " + numberOfGuess, 34, Color.RED, Color.BLACK));
        this.addObject(Score,getWidth()-100,30);
    }
}
    