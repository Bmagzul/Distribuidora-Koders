package modelo;

import java.sql.Date;
import java.util.logging.Logger;

public class Producto {
    String id;
    String producto;
    float precio;
    String existencia;
    Date fecha;
    
    public Producto(){
        
    }
    public Producto (String id, String producto, float precio, String existencia, Date fecha){
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.existencia = existencia;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    

   
    
}
