package com.modyo.automation.utilidad.BD_Automatizacion.Tablas;

public class UsuarioAutomatizador {

    private Integer ID_Usuario;
    private String Nombre_Usuario;
    private Boolean Activo;
    private String Nombre;
    private String Email;

    public Integer getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(Integer ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
