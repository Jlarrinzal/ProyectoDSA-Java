package edu.upc.dsa.models.dto;

public class Credencials {

    String correo;

    String password;

    public Credencials(){

    }
    public Credencials(String correo, String password){
        this.setCorreo(correo);
        this.setPassword(password);

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
}
