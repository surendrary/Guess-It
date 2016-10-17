import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;
import com.mysql.jdbc.*; 

/**
 * Write a description of class DBConnection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DBConnection  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DBConnection
     */
    public DBConnection()
    {
        String dbUrl = "jdbc:mysql://localhost:3306/";
        System.out.println("starting connection");
//        Class.forName(driver);
        try{
        Class.forName ("com.mysql.jdbc.Driver").newInstance (); 
        System.out.println("driver loaded");
        connection = DriverManager.getConnection(dbUrl, "root", "blitz");
       }
       catch(Exception e){
           System.out.println(e);
        }
    }

    Connection connection;
     
    public Connection getConnection(){
        return connection;
    }
    
    String dbName;
    String tableName;
     
    public DBConnection(String dbUrl, String userName, String password, String driver/*, String dbName*/) throws Exception {
        //this.dbName = dbName;
        System.out.println("starting connection");
        Class.forName(driver);
        System.out.println("driver loaded");
        connection = DriverManager.getConnection(dbUrl, userName, password);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
