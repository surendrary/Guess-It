import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Button extends Actor
{
    
    int dy=0;
    float g=1.0f;  
    private ConcreteCommand command;
    public Button()
    {
        GreenfootImage image = new GreenfootImage("play_button.png");
        image.scale(150,150);
        setImage(image);
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            command = new ConcreteCommand();
            command.setReceiver(new MainButtonReceiver());
            
            InvokerImpl in = new InvokerImpl();
            in.setCommand(command);
            
            in.invoke();       
        }
        if(stopfall()==true)
        {
           setLocation(getX()+dy,getY());
           dy=dy+(int)g; 
        }  
    }
    
    public boolean stopfall()
    {
        if(getX()>400)    
        {
         return false;
        }
        else
        {
         return true;
        }
    }
}