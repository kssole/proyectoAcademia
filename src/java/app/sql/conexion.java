package app.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
  static String bd = "academia";
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost:3306/academia";

   Connection conn = null;

   public conexion(){
       try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+" OK");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
    
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
}

