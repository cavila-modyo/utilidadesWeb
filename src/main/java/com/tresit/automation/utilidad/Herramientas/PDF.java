package com.tresit.automation.utilidad.Herramientas;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class PDF {

/*
    public static void main(String [] Args){
        String carpeta = "C:\\Automatizacion\\ATC\\Imagenes";
        String nombrePDF = "ArchivoPrueba";
        GeneratePDF_Images(carpeta, nombrePDF);
    }
    */

    public static void GeneratePDF_Images(String carpeta, String NombreArchivo) {
        try {
            //File folderImages = new File("C:\\Automatizacion\\ATC\\Imagenes");
            File folderImages = new File(carpeta);

            if(!folderImages.exists()) {
                throw new RuntimeException("La carpeta no existe");
            }

            PDDocument document = new PDDocument();

            for(File imagen : folderImages.listFiles()) {

                if(imagen.getName().contains(".png")) {
                    FileInputStream in = FileUtils.openInputStream(imagen);
                    BufferedImage bimg = ImageIO.read(in);
                    //PDPage page = new PDPage(new PDRectangle(bimg.getWidth(), bimg.getHeight()));
                    PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(),PDRectangle.A4.getHeight()));
                    document.addPage(page);

                    PDImageXObject img = PDImageXObject.createFromFileByContent(imagen, document);

                    PDPageContentStream contentStream = new PDPageContentStream(document, page);
                    contentStream.drawImage(img, 70, 500, bimg.getWidth() / 3, bimg.getHeight() / 3);
                    contentStream.close();
                    in.close();
                }
            }

            document.save(carpeta + "\\" + NombreArchivo + ".PDF");
            document.close();

        }catch(Exception o){
            System.out.println("Error: " + o.getMessage());
        }

    }

}
