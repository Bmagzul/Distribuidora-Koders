
package modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Producto>datos=new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Producto pro = new Producto();
                pro.setId(rs.getString(1));
                pro.setProducto(rs.getString(2));
                pro.setPrecio(rs.getFloat(3));
                pro.setExistencia(rs.getString(4));
                pro.setFecha(rs.getDate(5));
                datos.add(pro);
                
                
            }
        } catch (Exception e){
            
        }
        return datos;
    }
    
    public int agregar(Producto p){
        String sql = "INSERT INTO Producto(ID_PRODUCTO, NOMBRE_PRODUCTO, PRECIO_UNITARIO, CANTIDAD_EXISTENCIA, FECHA_CADUCIDAD) VALUES (?,?,?,?,?)";
       
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getId());
            ps.setString(2, p.getProducto());
            ps.setFloat(3, p.getPrecio());
            ps.setString(4, p.getExistencia());
            ps.setDate(5, p.getFecha());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return 1;
    }
    public int Actualizar(Producto p){
        int r=0;
        String sql = "UPDATE Producto SET NOMBRE_PRODUCTO=?, PRECIO_UNITARIO=?, CANTIDAD_EXISTENCIA=?, FECHA_CADUCIDAD=? WHERE ID_PRODUCTO=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, p.getId());
            ps.setString(1, p.getProducto());
            ps.setFloat(2, p.getPrecio());
            ps.setString(3, p.getExistencia());
            ps.setDate(4, p.getFecha());
            ps.setString(5, p.getId());
            r=ps.executeUpdate();
            if (r==1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    public void delete (int id){
        String sql = "DELETE FROM Producto WHERE ID_PRODUCTO="+id;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       
    }
    
    public Producto buscarCodigo(String codigo){
        Producto pro = new Producto();
        String sql = "select * from producto where id_producto = '"+codigo+"'";
        
        try {
            con = conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()) {
                pro.setId(rs.getString(1));
                pro.setProducto(rs.getString(2));
                pro.setPrecio(rs.getFloat(3));
                pro.setExistencia(rs.getString(4));
                pro.setFecha(rs.getDate(5));
            }
        } catch (Exception e){
            
        }
        
        return pro;
    }
    
}
