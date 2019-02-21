package com.tresit.automation.utilidad.Herramientas;


import com.tresit.automation.utilidad.BD_Automatizacion.FormatData.FD_Excel;
import com.tresit.automation.utilidad.BD_Automatizacion.Tablas.EjecucionesLog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Texto {

    static EjecucionesLog Usuario = new EjecucionesLog();
    static ConfiguracionEjecucion configEjecucion = new ConfiguracionEjecucion();
    BufferedWriter bw = null;
    FileWriter fw = null;

    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            System.out.println(cadena);
        }
        b.close();
    }

    public static EjecucionesLog RetornaUsuariosEjecucion(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        Usuario = new EjecucionesLog();
        String default_ = "0";
        while ((cadena = b.readLine()) != null) {
            //System.out.println("Valor de Cadena: " + cadena);
            if (!cadena.equals(null) || !cadena.equals("")) {
                if (cadena.contains("ID_Proyecto")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_Proyecto(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("ID_Usuario")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_Usuario(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("ID_TestCase")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_TestCase(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("Status")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setStatus(parts.length > 1 ? parts[1] : "");
                }
                if (cadena.contains("ID_TestCycle")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setID_TestCycle(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("Sprint")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setSprint(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("Adjunto")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setAdjunto(Boolean.parseBoolean(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("IdTipoAmbiente")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setIdTipoAmbiente(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
                }
                if (cadena.contains("IdTipoEjecucion")) {
                    String[] parts = cadena.trim().split("=");
                    Usuario.setIdTipoEjecucion(Integer.parseInt(parts.length > 1 ? parts[1] : default_));
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

    public static ConfiguracionEjecucion RetornaConfiguracionEjecucion(String archivo) throws FileNotFoundException, IOException {

        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        configEjecucion = new ConfiguracionEjecucion();
        String default_ = "";
        while ((cadena = b.readLine()) != null) {
            //System.out.println("Valor de Cadena: " + cadena);
            if (!cadena.equals(null) || !cadena.equals("")) {
                if (cadena.contains("Carpeta")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setCarpeta(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("NombreCaso")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setNombreCaso(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("PathDescargasUsuario")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setPathDescargasUsuario(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("RutaArchivoCupo")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setRutaArchivoCupo(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("RutaArchivoPreliminar")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setRutaArchivoPreliminar(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("ArchivoResultado")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setArchivoResultado(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("ArchivoCupoResultado")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setArchivoResultadoCupo(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("ArchivoAlumnoResultado")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setArchivoResultadoAlumno(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("ArchivoAlumnoFaltanteResultado")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setArchivoResultadoAlumnoFaltante(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("ArchivoAlumnoFaltanteDetalleResultado")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setArchivoResultadoAlumnoFaltanteDetalle(parts.length > 1 ? parts[1] : default_);
                }
                if (cadena.contains("BROWSER")) {
                    String[] parts = cadena.trim().split("=");
                    configEjecucion.setBROWSER(parts.length > 1 ? parts[1] : default_);
                }
            }
        }
        b.close();
        return configEjecucion;
    }

    public void ArchivoResultadoComparacion(String data, String carpeta) {
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

    public void ArchivoFD(String DatoGenerado, String carpeta, String NombreFD) {
        try {
            File folder = new File(carpeta);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }

            File file = new File(carpeta + "\\" + NombreFD);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(DatoGenerado + "\n");
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
            EjecucionesLog log1 = new EjecucionesLog();
            ConfiguracionEjecucion log = new ConfiguracionEjecucion();
            //muestraContenido("C:\\Automatizacion\\Documentos Prueba\\Agregar por proyecto.txt");
            log = RetornaConfiguracionEjecucion("C:\\Automatizacion\\UDSGP-255\\MTC_US_UDSGP_05000\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE.txt");
            log.getArchivoResultado();
            log1 = RetornaUsuariosEjecucion("C:\\Automatizacion\\UDSGP-255\\MTC_US_UDSGP_05000\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE.txt");
            log1.getID_Usuario();
        } catch (IOException p) {
            System.out.println("Error: " + p.getMessage());
        }
    }
    */

}
