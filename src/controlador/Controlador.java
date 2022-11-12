package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoDAO;
import modelo.Producto;
import vista.vista;
import javax.swing.JLabel;

public class Controlador implements ActionListener {
    
    ProductoDAO dao = new ProductoDAO();
    Producto pro = new Producto();
    vista vista = new vista();
    DefaultTableModel modelo = new DefaultTableModel();
    

    public Controlador(vista v) {
        this.vista=v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnguardar.addActionListener(this);
        this.vista.btneditar.addActionListener(this);
        this.vista.btnok.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==vista.btnListar) {
            System.out.println("------ Buscando.");
            limpiarTabla();
            listar(vista.tabla);
        }
        if (ae.getSource()==vista.btnguardar) {
            agregar();
            limpiarTabla();
            listar(vista.tabla);
        }
        if (ae.getSource()==vista.btneditar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila==-1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            }else{
                //String id=Integer.parseInt((String)vista.tabla.getValueAt(fila, 0).toString());
                String id=(String)vista.tabla.getValueAt(fila, 0);
                String producto=(String)vista.tabla.getValueAt(fila, 1);
                float precio=(float)vista.tabla.getValueAt(fila, 2);
                String existencia=(String)vista.tabla.getValueAt(fila, 3);
                Date  fecha=(Date)vista.tabla.getValueAt(fila, 4);
                vista.txtid.setText(id);
                vista.txtproducto.setText(producto);
                vista.txtPrecio.setText(""+precio);
                vista.txtexistencia.setText(existencia);
                vista.txtFecha.setText(""+fecha);
            }
        }
        if (ae.getSource()==vista.btnok) {
            Actualizar();
            limpiarTabla();
            listar(vista.tabla);
        }
        if (ae.getSource()==vista.btnEliminar) {
            
            delete();
            //limpiarTabla();
            //listar(vista.tabla);
        }
        if (ae.getSource()==vista.btnBuscar) {
            buscarCodigo(vista.inputResultado);
        }
    }
     public void delete(){
        
        int fila=vista.tabla.getSelectedRow();
        if (fila==-1) {
            JOptionPane.showMessageDialog(vista, "Debe de seleccionar un producto");
        }else{

            int id= Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString());
            dao.delete(id);
            JOptionPane.showMessageDialog(vista, "Producto Eliminado");
            listar(vista.tabla);
        }
    }
    void limpiarTabla(){
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i=i-1;
        }
    }
   
    public void Actualizar(){
        String id=vista.txtid.getText();
        String producto=vista.txtproducto.getText();
        Float precio=Float.parseFloat(vista.txtPrecio.getText());
        String existencia=vista.txtexistencia.getText();
        Date fecha=Date.valueOf(vista.txtFecha.getText());
        pro.setId(id);
        pro.setProducto(producto);
        pro.setPrecio(precio);
        pro.setExistencia(existencia);
        pro.setFecha(fecha);
        int r=dao.Actualizar(pro);
        if (r==1) {
            JOptionPane.showMessageDialog(vista,"Producto Actualizado con Exito!!!");
        }else{
            JOptionPane.showMessageDialog(vista,"Error");
        }
    }
    public void agregar(){
        String id=vista.txtid.getText();
        String producto=vista.txtproducto.getText();
        Float precio=Float.parseFloat(vista.txtPrecio.getText());
        String existencia=vista.txtexistencia.getText();
        Date fecha=Date.valueOf(vista.txtFecha.getText());
        pro.setId(id);
        pro.setProducto(producto);
        pro.setPrecio(precio);
        pro.setExistencia(existencia);
        pro.setFecha(fecha);
        int r=dao.agregar(pro);
        if (r==1) {
            JOptionPane.showMessageDialog(vista,"Producto Agregado con Exito");
        }else{
            JOptionPane.showMessageDialog(vista,"Error");
        }
        
    }
    
    public void listar (JTable tabla){
        
        modelo = (DefaultTableModel)tabla.getModel();
        int rowCount = modelo.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        List<Producto>lista=dao.listar();
        Object[]object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getProducto();
            object[2]=lista.get(i).getPrecio();
            object[3]=lista.get(i).getExistencia();
            object[4]=lista.get(i).getFecha();
            modelo.addRow(object);
            
        }
        vista.tabla.setModel(modelo);
    }
    
    public void buscarCodigo(JLabel resultado) {
        String codigo = vista.txtBuscar.getText();
        resultado.setText("");
        Producto prod = dao.buscarCodigo(codigo);
        
        if (prod.getId() != null) {
            resultado.setText("<html>"
                + "Codigo: " + prod.getId()
                + "<br>Nombre: " + prod.getProducto()
                + "<br>Precio unitario: " + prod.getPrecio()
                + "<br>Existencia: " + prod.getExistencia()
                + "<br>Vencimiento: " + prod.getFecha()
                + "</html>"
            );
        } else {
            resultado.setText("No se encontro un producto con el codigo ingresado ");
        }
    }
    
}
