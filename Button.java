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
            
            
            /*    Greenfoot.playSound("button_click.mp3");
               String userName = JOptionPane.showInputDialog("Enter Name");
               if(userName==null || userName.equals("")){
                   JOptionPane.showMessageDialog(null, "Username is mandatory to start game");
                }
            else{
                 System.out.println(userName+" Game Level selection");
                Greenfoot.setWorld(new GameTypeSelect(userName));
                } */
        }
        if(stopfall()==true)
        {
           setLocation(getX()+dy,getY());
           dy=dy+(int)g; 
        }  
    }
    
    private Connection getConnection(){
        
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
         System.out.println("conn"+conn);
         
        return conn;
    }
    private void saveUser(String username){
        Connection connection = getConnection();
        try{
        String sql = "Insert into guessdb.user(user_name) values('"+username+ "')";
        PreparedStatement st = null; 
        st = connection.prepareStatement(sql); 
        st.execute(sql);
        //ResultSet rs = st.executeQuery(sql);
          //  while (rs.next()){
            //        System.out.println(rs.getInt(1));
              //}
        }
        catch(Exception e){
            System.out.println(e); 
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