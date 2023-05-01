package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;

public interface GameManager {

    //Añadir Usuario
    public void addUsuario(String nombre, String apellido, String apellido2, String fecha, String correo, String password);
    //Añadir Objeto/Producto
    public void addObjeto(String nombre, String descripcion, double precio);
    //Login Usuario
    public void login(String correo, String password);
    // Metodo hacer una compra
    public Objeto hacerCompra(String Usuario, String nombreObjeto);

    public int size();
}
