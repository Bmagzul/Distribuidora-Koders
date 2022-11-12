//package abarroteria.la.economica;
/*
//import java.sql.*;

public class Negocio {

    public static void main(String[] args) {
        //Cadena de conexión de MySql, el parametrouseSSLes opcional
        String url = "jdbc:mysql://localhost:3306/inventario?useSSL=false";
        // Cargamos el driver de mysql
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Creamos el objeto conexion
            Connection conexion = (Connection) DriverManager.getConnection(url, "root", "admin");
            // Creamos un objeto Statement
            Statement instruccion = conexion.createStatement();
            // Creamos el query
            String sql = "select ID_PRODUCTO, NOMBRE_PRODUCTO, PRECIO_UNITARIO, CANTIDAD_EXISTENCIA, FECHA_CADUCIDAD from producto";
            ResultSet result = instruccion.executeQuery(sql);
            System.out.println("**********************************ABARROTERIA LA ECONOMICA*********************************");
            System.out.println("************Listado de Productos**************");
            while (result.next()) {
                System.out.println("___________________________________________________________________________________________");
                System.out.println("Codigo Producto:    "+result.getString(1));
                System.out.println("Nombre Producto:    " + result.getString(2));
                System.out.println("Costo Unitario:     "+"Q"+ result.getFloat(3));
                System.out.println("Existencia:         "+ result.getString(4));
                System.out.println("Fecha Vencimiento:  "+ result.getDate(5));
            }
            // Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
*/
