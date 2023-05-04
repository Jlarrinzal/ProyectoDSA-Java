package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

public interface GameManager {

    //Añadir Usuario
    public void addUsuario(String nombre, String correo, String password);
    //Añadir Objeto/Producto
    public void addObjeto(String nombre, String descripcion, double precio);
    //Login Usuario
    public void login(String correo, String password);
    // Metodo hacer una compra
    public Objeto hacerCompra(String Usuario, String nombreObjeto);
    //Registrar Usuario
    public Usuario registerUsuario(String correo, String password);

    //auxiliares
    Usuario getUsuarioPorCorreo(String correo);
    public int size();

    Usuario getUsuarioPorNombre(String nombreObjeto);

    Objeto getObjetoPorNombre(String nombreObjeto);
}
