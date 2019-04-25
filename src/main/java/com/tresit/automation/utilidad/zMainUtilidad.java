package com.tresit.automation.utilidad;

import com.tresit.automation.utilidad.Herramientas.*;

import java.io.File;

public class zMainUtilidad {

    public static void main (String args[]){

        Carpeta c= new Carpeta();
        c.setCarpeta("C:\\Users\\3it\\Downloads\\test");
        System.out.println("Retorno: " + c.CrearCarpeta());
        File f = new File("Saaale.docx");
        System.out.println(c.CrearArchivo(c.getCarpeta(), f.toString()));

    }

}
