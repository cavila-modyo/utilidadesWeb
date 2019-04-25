package com.tresit.automation.utilidad.Herramientas;

import java.io.File;
import java.io.IOException;

public class Carpeta {

    private String carpeta;

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    // Utilizará las mismas variables con las que se crea la clase
    public String CrearCarpeta(){
        String rutaCreacion = "";
        try {
            File folder = new File(getCarpeta());
            if (!folder.isDirectory()) {
                folder.mkdirs();
                rutaCreacion = "Carpeta Creada: " + getCarpeta();
            } else {
                rutaCreacion = "Carpeta Existente: " + getCarpeta();
            }
        }catch(Exception o){
            rutaCreacion = "Error al Crear Carpeta: " + getCarpeta() + ".\n" + o.getMessage();
        }
        return rutaCreacion;
    }

    public String CrearArchivo(String carpeta, String NombreArchivo){

        String ArchivoCreacion = "";
        try{
            File file = new File(carpeta + "\\" + NombreArchivo);
            if (!file.exists()) {
                file.createNewFile();
                ArchivoCreacion = "Archivo creado: " + carpeta + "\\" + NombreArchivo;
            }else{
                ArchivoCreacion = "Archivo Existente: " + carpeta + "\\" + NombreArchivo;
            }
        }catch(IOException p){
            ArchivoCreacion = "Error al Crear Archivo: " + carpeta + "\\" + NombreArchivo;
        }

        return ArchivoCreacion;
    }


}
