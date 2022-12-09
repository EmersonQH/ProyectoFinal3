package com.example.proyectofinal1.Model;

public class User {
    private String UserName;
    private String correo;
    private String password;

    public User(String userName, String correo, String password) {
        UserName = userName;
        correo = correo;
        password = password;
    }

    public User(){

    }

    public String getUserName() {
        return UserName;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
