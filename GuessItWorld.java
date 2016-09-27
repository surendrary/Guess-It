import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;


/**
 * Write a description of class MyWorld here.
 * 
 * @author Green Techies 
 * @version 1.0
 */
public class GuessItWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GuessItWorld()
    {    
        super(850, 650, 1); 
        setUpGame();
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void setUpGame()
    {
        setBackground(new GreenfootImage("home_page_Background.jpg"));   

        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 50));
        getBackground().drawString("Guess It!!", 380, 70);
        Greenfoot.setSpeed(50);
        //Greenfoot.start();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        StringInputBox stringinputbox = new StringInputBox();
        addObject(stringinputbox,421,300);
        stringinputbox.setLocation(492,301);
        Button button = new Button();
        addObject(button,403,368);
        button.setLocation(402,418);
        stringinputbox.setLocation(715,524);
        button.setLocation(726,575);
        Diag1 diag1 = new Diag1();
        addObject(diag1,431,278);
        stringinputbox.setLocation(498,118);
        button.setLocation(448,508);
        button.setLocation(482,510);
        removeObject(diag1);
        Diag1 diag12 = new Diag1();
        addObject(diag12,437,324);
        diag12.setLocation(410,319);
    }

public void act() 
    {
//String inputValue = JOptionPane.showInputDialog("Please input a name");
}
}