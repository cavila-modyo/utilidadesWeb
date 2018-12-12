package com.tresit.automation.utilidad.Herramientas;


import com.tresit.automation.utilidad.BD_Automatizacion.Tablas.EjecucionesLog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Texto {

    static EjecucionesLog Usuario = new EjecucionesLog();

    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    public static EjecucionesLog RetornaUsuariosEjecucion(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        Usuario = new EjecucionesLog();
        while((cadena = b.readLine())!= null) {
            //System.out.println("Valor de Cadena: " + cadena);
            if(!cadena.equals(null) || !cadena.equals("")) {
                if (cadena.contains("ID_Proyecto")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_Proyecto(Integer.parseInt(parts[1]));
                }
                if (cadena.contains("ID_Usuario")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_Usuario(Integer.parseInt(parts[1]));
                }
                if (cadena.contains("ID_TestCase")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_TestCase(Integer.parseInt(parts[1]));
                }
                //if (cadena.contains("Status")) {
                    Usuario.setStatus("");
                //}
                if (cadena.contains("ID_TestCycle")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_TestCycle(Integer.parseInt(parts[1]));
                }
                if (cadena.contains("Sprint")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setSprint(Integer.parseInt(parts[1]));
                }
                if (cadena.contains("Adjunto")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setAdjunto(Boolean.parseBoolean(parts[1]));
                }
                if (cadena.contains("IdTipoAmbiente")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setIdTipoAmbiente(Integer.parseInt(parts[1]));
                }
                if (cadena.contains("IdTipoEjecucion")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setIdTipoEjecucion(Integer.parseInt(parts[1]));
                }
            }
            //if (Usuario.getID_Usuario() != null && Usuario.getID_TestCase() != null) {
            //    Usuarios.add(Usuario);
            //    Usuario = new EjecucionesLog();
            //}
        }
        b.close();
        return Usuario;
    }

    BufferedWriter bw = null;
    FileWriter fw = null;

    public void ArchivoResultadoComparacion(String data, String carpeta){
        try {
            File folder = new File(carpeta);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }

            File file = new File(carpeta + "\\ArchivoComparacion.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write("" + "\n" + data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    /*
        public static void main(String[] args) {
            try {
                EjecucionesLog log = new EjecucionesLog();
                //muestraContenido("C:\\Automatizacion\\Documentos Prueba\\Agregar por proyecto.txt");
                log = RetornaUsuariosEjecucion("C:\\Automatizacion\\Documentos Prueba\\Agregar por proyecto.txt");
            }catch(IOException p) {
                System.out.println("Error: " + p.getMessage());
            }
        }
    */
}
