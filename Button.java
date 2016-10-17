import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
 
public class Button extends Actor
{
    
    public Button()
    {
        GreenfootImage image = new GreenfootImage("play_button.png");
        setImage(image);
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            
            
           String userName = JOptionPane.showInputDialog("Enter Name");
           if(userName.equals("")){
               JOptionPane.showMessageDialog(null, "Username is mandatory to start game");
            }
        else{
            Greenfoot.setWorld(new GameTypeSelect(userName));
            //saveUser(userName);
            }
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
}