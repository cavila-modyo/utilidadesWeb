package Util_3it.Herramientas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    BufferedWriter bw = null;
    FileWriter fw = null;

    // Como utilizar el loguer. Crea Archivo si no existe para el dia de la ejecucion.
    // Inserta fila con la data que se pasa por parametro.
    // Dentro de la data que se debe envia, debemos informar el usuario, la fehca, el caso de prueba ejecutado
    // Los endpoint consumidos y las respuestas.
    public void AgregarLoguerDia(String data, String carpeta){
        try {
            //String ruta = "C:\\Automatizacion\\ATC_TEST_ZEPHYR\\" + carpeta;
            //Carpeta = ruta raiz (RutaCarpeta.java) + WEB o MOBILE
            //System.out.println("Valor de carpeta: " + carpeta);

            File folder = new File(carpeta);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }

            File file = new File(carpeta + "\\app_log.log");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write("" + "\n" + data);
            //System.out.println("Se agrega fila en archivo: " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
