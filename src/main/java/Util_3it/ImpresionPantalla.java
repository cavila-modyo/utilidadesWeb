package Util_3it;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImpresionPantalla {

    // Hacer que capture la pantalla
    static Date fechaActual = new Date();
    static long Milisegundos = fechaActual.getTime();
    static  java.sql.Date FechaCaptura = new java.sql.Date(Milisegundos);

    //static RutaCarpeta rutaCarpeta = new RutaCarpeta();
    //static String rutaFinalArchivo = rutaCarpeta.getWeb()+ nombreAtc + fec.getFecha() + fec.getHora() + "\\";
    //String rutaCarpetas = "C:\\Automatizacion\\ATC_TEST_ZEPHYR\\";

    public void CapturaPantalla(WebDriver driver, String nombreCaptura, String carpeta){

        Date fechaActual = new Date();
        long Milisegundos = fechaActual.getTime();
        java.sql.Date FechaCaptura = new java.sql.Date(Milisegundos);

        try{
            File folder = new File(carpeta);
            if (!folder.exists()) {
                // No se crea la carpeta porque ya existe
                this.takeSnapShot(driver,  folder + "\\" + nombreCaptura +  "_" + FechaCaptura + ".png") ;
            }else{
                // Se crea la carpeta
                folder.mkdir(); // esto crea la carpeta java, y requiere que exista la ruta
                this.takeSnapShot(driver,  folder + "\\" + nombreCaptura +  "_" + FechaCaptura + ".png") ;
                // folder.mkdirs(); // esto crea la carpeta java, independientemente que exista el path completo, si no existe crea toda la ruta necesaria
            }
        }catch (Exception P){
            System.out.println("Error al Crear carpeta: " + P.getMessage());
        }
    }

    public static void takeSnapShot(WebDriver webdriver,String UbicacionArchivo) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File(UbicacionArchivo);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }


}
