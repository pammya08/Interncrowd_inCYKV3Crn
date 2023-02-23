package javaapplication4;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class JavaApplication4 {
    static Connection conn=null;
public static Connection ConnecrDb(){
    try{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_ticket_system","root","Pravin08@");
		System.out.println("connection succesful");
        return conn;
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    
return null;
}

   
}
