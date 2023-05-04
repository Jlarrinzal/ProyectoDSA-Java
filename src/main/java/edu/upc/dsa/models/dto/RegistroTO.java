package edu.upc.dsa.models.dto;

public class RegistroTO {

    String nombre;
    String correo;
    String password;
    /*String apellido;
    String apellido2;
    String fecha;

    double dsaCoins = 500;*/

    public RegistroTO() {

    }

    public RegistroTO(String correo, String password){
        this.setCorreo(correo);
        this.setPassword(password);
    }


    public RegistroTO(String nombre, String correo, String password) {
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setPassword(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public String getApellido() {
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
    }*/

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

    /*public double getDsaCoins() {
        return dsaCoins;
    }

    public void setDsaCoins(double dsaCoins) {
        this.dsaCoins = dsaCoins;
    }*/
}
