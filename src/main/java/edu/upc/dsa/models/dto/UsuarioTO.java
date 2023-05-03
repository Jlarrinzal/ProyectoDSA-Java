package edu.upc.dsa.models.dto;

import edu.upc.dsa.models.Objeto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTO {

    String nombre;
    String apellido;
    String apellido2;
    String fecha;
    String correo;
    String password;
    double dsaCoins = 500;

    public UsuarioTO() {

    }

    public UsuarioTO(String correo, String password){
        this.setCorreo(correo);
        this.setPassword(password);
    }


    public UsuarioTO(String nombre, String apellido, String apellido2, String fecha, String correo, String password) {
        setNombre(nombre);
        setApellido(apellido);
        setApellido2(apellido2);
        setFecha(fecha);
        setCorreo(correo);
        setPassword(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getDsaCoins() {
        return dsaCoins;
    }

    public void setDsaCoins(double dsaCoins) {
        this.dsaCoins = dsaCoins;
    }
}
