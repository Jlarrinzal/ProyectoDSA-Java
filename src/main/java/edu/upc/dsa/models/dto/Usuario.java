package edu.upc.dsa.models.dto;

public class Usuario {

    String correo;

    String usuario;

    String password;

    public Usuario() {

    }
    public Usuario(String usuario, String correo, String password) {
        this.usuario=usuario;
        this.correo=correo;
        this.password=password;

    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
