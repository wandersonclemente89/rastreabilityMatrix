package Database;

//STEP 1. Import required packages

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDb {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://136.225.94.125:3306/rm_db";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   public static Connection getConnection(){
   Connection conn = null;
   try{
       try {
           //STEP 2: Register JDBC driver
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           throw new RuntimeException("Connection Error: ", ex);
       }

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS); 
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }//end try
        return conn;
   }
   public static void closeConnection(Connection conn) {
       try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
   public static void closeConnection(Connection conn,PreparedStatement stmt) {
       closeConnection(conn);
        try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se){
          se.printStackTrace();
      }//
   }
   
   public static void closeConnection(Connection conn,PreparedStatement stmt, ResultSet rs){
       closeConnection(conn, stmt);
        try{
         if(rs!=null)
            rs.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
       
   }
}//end ConnectionDb