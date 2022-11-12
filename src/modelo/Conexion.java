
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/crud_java";
        String user="root";
        String pass="root";       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection (url,user,pass);
        } catch (Exception e){
            
        }
        return con;
    }
    
}
