package edu.upc.dsa.models.dto;

public class Login {

    String correo;

    String password;

    public Login(){

    }
    public Login(String correo, String password){
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
