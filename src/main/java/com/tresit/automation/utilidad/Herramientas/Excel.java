package com.tresit.automation.utilidad.Herramientas;

import com.tresit.automation.utilidad.ClasesUtilesUdla.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import com.tresit.automation.utilidad.BD_Automatizacion.FormatData.FD_Excel;

public class Excel {

    /*CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR */

    /*for (int c = 0; c < (cols = hssfRow.getLastCellNum()); c++) {
    cellValue = hssfRow.getCell(c) == null?"":
    (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_STRING)?hssfRow.getCell(c).getStringCellValue():
    (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_NUMERIC)?"" + hssfRow.getCell(c).getNumericCellValue():
    (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BOOLEAN)?"" + hssfRow.getCell(c).getBooleanCellValue():
    (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_BLANK)?"BLANK":
    (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_FORMULA)?"FORMULA":
    (hssfRow.getCell(c).getCellType() == Cell.CELL_TYPE_ERROR)?"ERROR":"";
    System.out.print("[Column " + c + ": " + cellValue + "] ");
    }*/

    private static List<Object> DATA;

    static {
        DATA = Arrays.asList(new Object[] {
                new Object[] { "PlayStation 4 (PS4) - Consola 500GB", new BigDecimal("340.95"), "https://www.amazon.es/PlayStation-4-PS4-Consola-500GB/dp/B013U9CW8A" },
                new Object[] { "Raspberry Pi 3 Modelo B (1,2 GHz Quad-core ARM Cortex-A53, 1GB RAM, USB 2.0)", new BigDecimal("41.95"), "https://www.amazon.es/Raspberry-Modelo-GHz-Quad-core-Cortex-A53/dp/B01CD5VC92/" },
                new Object[] { "Gigabyte Brix - Barebón (Intel, Core i5, 2,6 GHz, 6, 35 cm (2.5\"), Serial ATA III, SO-DIMM) Negro ", new BigDecimal("421.36"), "https://www.amazon.es/Gigabyte-Brix-Bareb%C3%B3n-Serial-SO-DIMM/dp/B00HFCTUPM/" }
        });
    }


/*
    public static void main(String args[]){
        //Csv_Leer();
        // C:\Automatizacion\Documentos Prueba\PruebaExcel.xls
        // C:\Automatizacion\Documentos Prueba\PruebaExcel.xlsx
        //File f = new File("C:\\Users\\3it\\Downloads\\Resultado.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls

        //File f = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\ReporteCupos.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //List<ReporteCupoInternado> lista = LeerExcelConClaseCupoInternado(f);

        //File p = new File("C:\\Automatizacion\\Documentos Prueba\\PruebaExcel.xls");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //LeerExcel(p);

        File p = new File("C:\\Automatizacion\\ATC\\FD_Automatic\\Ste_FD.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        List<FD_Excel> Lista  = LeerExcelFD(p,2); // Considerar que el indice es menos 1.. Osea la posicion real sería la 3

        for (int i = 0; i<=(Lista.size()-1);i++){
            System.out.print(Lista.get(i).getNombreCampo());
            System.out.print(" " + Lista.get(i).getDescripcionCampo());
            System.out.print(" " + Lista.get(i).getTipoDato());
            System.out.print(" " + Lista.get(i).getFormatoIflex());
            System.out.print(" " + Lista.get(i).getLargo());
            System.out.println("");
        }

    }
    */

    public static List<FD_Excel> LeerExcelFD(File archivo, int FilaDatos) {

        List<FD_Excel> listaFD = new ArrayList<>();
        FD_Excel FD;
        String extension = obtenerExtension(archivo);
        try {
            InputStream targetStream = new FileInputStream(archivo);
            if (extension.equals("xlsx")) {
                try {
                    System.out.println("Ruta del Archivo: " + archivo.getPath());
                    XSSFWorkbook workbook = new XSSFWorkbook(archivo.getPath());
                    StringBuffer sb = new StringBuffer("");
                    // Read the Sheet
                    for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                        XSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                        if (hssfSheet == null) {
                            continue;
                        }
                        // Read the Row
                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            //int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo
                                if (hssfRow != null) {
                                    if (rowNum >= FilaDatos) {
                                        FD = new FD_Excel();

                                        FD.setNombreCampo(hssfRow.getCell(0).toString());
                                        FD.setFormatoIflex(hssfRow.getCell(1).toString());
                                        FD.setTipoDato(hssfRow.getCell(2).toString());
                                        FD.setDescripcionCampo(hssfRow.getCell(3).toString());
                                        FD.setPosicionInicial(hssfRow.getCell(4).toString());
                                        FD.setPosicionFinal(hssfRow.getCell(5).toString());
                                        FD.setLargo(hssfRow.getCell(6).toString());
                                        listaFD.add(FD);
                                    }
                                }

                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer_ xlsx: " + e.getMessage());
                    e.printStackTrace();
                }catch (NoClassDefFoundError notFound){
                    System.out.println("Error al leer_ xlsx: " + notFound);
                }
            }

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return listaFD;
    }



    public static void LeerExcel(File archivo) {
        String extension = obtenerExtension(archivo);
        try {
            InputStream targetStream = new FileInputStream(archivo);
            if (extension.equals("xlsx")) {
                try {
                    System.out.println("Ruta del Archivo: " + archivo.getPath());
                    XSSFWorkbook workbook = new XSSFWorkbook(archivo.getPath());
                    StringBuffer sb = new StringBuffer("");
                    // Read the Sheet
                    for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                        XSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                        if (hssfSheet == null) {
                            continue;
                        }
                        // Read the Row
                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo

                            for (int i= 0; i<= (celdas-1); i++){
                                if (hssfRow != null){
                                    if (rowNum == 0) {
                                        System.out.println("Valor Encabezado: " + hssfRow.getCell(i));
                                    }else{
                                        System.out.println("Valor Fila[" + i + "] : " + hssfRow.getCell(i));
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer_ xlsx: " + e.getMessage());
                    e.printStackTrace();
                }catch (NoClassDefFoundError notFound){
                    System.out.println("Error al leer_ xlsx: " + notFound);
                }
            }
            else if (extension.equals("xls")) {
                try {
                    HSSFWorkbook workbook = new HSSFWorkbook(targetStream);
                    StringBuffer sb = new StringBuffer("");
                    // Read the Sheet
                    for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                        HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                        if (hssfSheet == null) {
                            continue;
                        }
                        // Read the Row
                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLS(hssfSheet); // cantidad de celdas de archivo

                            for (int i= 0; i<= (celdas-1); i++){
                                if (hssfRow != null){
                                    if (rowNum == 0) {
                                        System.out.println("Valor Encabezado: " + hssfRow.getCell(i));
                                    }else{
                                        System.out.println("Valor Fila[" + i + "] : " + hssfRow.getCell(i));
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    /** Count max number of nonempty cells in sheet rows */
    private static int getColumnsCountXLSX(XSSFSheet xssfSheet) {
        int result = 0;
        Iterator<Row> rowIterator = xssfSheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<Cell> cells = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                cells.add(cellIterator.next());
            }
            for (int i = cells.size(); i >= 0; i--) {
                Cell cell = cells.get(i-1);
                if (cell.toString().trim().isEmpty()) {
                    cells.remove(i-1);
                } else {
                    result = cells.size() > result ? cells.size() : result;
                    break;
                }
            }
        }
        return result;
    }

    /** Count max number of nonempty cells in sheet rows */
    private static int getColumnsCountXLS(HSSFSheet  hssffSheet) {
        int result = 0;
        Iterator<Row> rowIterator = hssffSheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<Cell> cells = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                cells.add(cellIterator.next());
            }
            for (int i = cells.size(); i >= 0; i--) {
                Cell cell = cells.get(i-1);
                if (cell.toString().trim().isEmpty()) {
                    cells.remove(i-1);
                } else {
                    result = cells.size() > result ? cells.size() : result;
                    break;
                }
            }
        }
        return result;
    }

    private static String retornoStringHSSF(HSSFRow  hssffRow, int posicion){
        String retorno = "";
        try{
            retorno = hssffRow.getCell(posicion).toString();
        }catch(Exception e){
            //System.out.println("Error Valor Celda:" + e.getMessage());
            retorno = "";
        }
        return retorno;
    }

    private static String retornoStringXSSF(XSSFRow xssfRow, int posicion){
        String retorno = "";
        try{
            retorno = xssfRow.getCell(posicion).toString();
        }catch(Exception e){
            //System.out.println("Error Valor Celda:" + e.getMessage());
            retorno = "";
        }
        return retorno;
    }

    // Retorna el valor de la extension
    public static String obtenerExtension(File archivo) {

        String retorno = "";
        try {
            // "C:\\Automatizacion\\ArchivoXML_Ejemplo\\datos.xml"
            String filename = archivo.getName().toLowerCase();
            //System.out.println("Nombre Archivo: " + filename);
            if (filename.endsWith(".xlsx") ) {
                retorno = "xlsx";
            }
            if(filename.endsWith(".xls")){
                retorno = "xls";
            }
            if( !(filename.endsWith(".xls") || filename.endsWith(".xlsx")) ){
                retorno = "No es Excel";
            }
        } catch (Exception p) {
            System.out.println("Error: " + p.getMessage());
        }
        return retorno;
    }


    public void CrearExcel_XLSX (){

        // Creamos el archivo donde almacenaremos la hoja
        // de calculo, recuerde usar la extension correcta,
        // en este caso .xlsx
        File archivo = new File("reporte.xlsx");

        // Creamos el libro de trabajo de Excel formato OOXML
        Workbook workbook = new XSSFWorkbook();

        // La hoja donde pondremos los datos
        Sheet pagina = workbook.createSheet("Reporte de productos");

        // Creamos el estilo paga las celdas del encabezado
        CellStyle style = workbook.createCellStyle();
        // Indicamos que tendra un fondo azul aqua
        // con patron solido del color indicado
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        String[] titulos = {"Identificador", "Consumos",
                "Precio Venta", "Precio Compra"};
        Double[] datos = {1.0, 10.0, 45.5, 25.50};

        // Creamos una fila en la hoja en la posicion 0
        Row fila = pagina.createRow(0);

        // Creamos el encabezado
        for (int i = 0; i < titulos.length; i++) {
            // Creamos una celda en esa fila, en la posicion
            // indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            // Indicamos el estilo que deseamos
            // usar en la celda, en este caso el unico
            // que hemos creado
            celda.setCellStyle(style);
            celda.setCellValue(titulos[i]);
        }

        // Ahora creamos una fila en la posicion 1
        fila = pagina.createRow(1);

        // Y colocamos los datos en esa fila
        for (int i = 0; i < datos.length; i++) {
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            celda.setCellValue(datos[i]);
        }

        // Ahora guardaremos el archivo
        try {
            // Creamos el flujo de salida de datos,
            // apuntando al archivo donde queremos
            // almacenar el libro de Excel
            FileOutputStream salida = new FileOutputStream(archivo);

            // Almacenamos el libro de
            // Excel via ese
            // flujo de datos
            workbook.write(salida);

            // Cerramos el libro para concluir operaciones
            workbook.close();

            //LOGGER.log(Level.INFO, "Archivo creado existosamente en {0}", archivo.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            //LOGGER.log(Level.SEVERE, "Archivo no localizable en sistema de archivos");
            System.out.println("Archivo no exncontrado: " + ex.getMessage());
        } catch (IOException ex) {
            //LOGGER.log(Level.SEVERE, "Error de entrada/salida");
            System.out.println("Exception: " + ex.getMessage());
        }

    }


    public static void writeExcel() throws Exception {

        // Data es statico y ze implementa para pasar los datos...

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Hoja excel");

        String[] headers = new String[]{
                "Producto",
                "Precio",
                "Enlace"
        };

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }

        for (int i = 0; i < DATA.size(); ++i) {
            HSSFRow dataRow = sheet.createRow(i + 1);

            Object[] d = (Object[]) DATA.get(i);
            String product = (String) d[0];
            BigDecimal price = (BigDecimal) d[1];
            String link = (String) d[2];

            dataRow.createCell(0).setCellValue(product);
            dataRow.createCell(1).setCellValue(price.doubleValue());
            dataRow.createCell(2).setCellValue(link);
        }

        HSSFRow dataRow = sheet.createRow(1 + DATA.size());
        HSSFCell total = dataRow.createCell(1);
        //total.setCellType(CellType.FORMULA);
        total.setCellStyle(style);
        // Añade la sumatoria de
        total.setCellFormula(String.format("SUM(B2:B%d)", 1 + DATA.size()));

        FileOutputStream file = new FileOutputStream("data.xls");
        workbook.write(file);
        file.close();
    }


    /*
    public static void main (String args[]){
        String rutaArchivos = "C:\\Automatizacion\\UDSGP-255\\Prueba";
        String path = "C:\\Users\\3it\\Downloads";
        List<File> listaExcel = ArchivosExcelDeCarpeta(path);
        for (File child : listaExcel ){
            cortarPegarArchivo(child,rutaArchivos);
        }
    }*/

    public static List<File> ArchivosExcelDeCarpeta(String path){

        // Definir la ruta donde quedan las descargas por usuario
        //path = "C:\\Users\\3it\\Downloads";
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        List<File> listaExcel = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++){
            if (listOfFiles[i].isFile()){
                files = listOfFiles[i].getName();
                if (files.contains("xls")){
                    listaExcel.add(listOfFiles[i]); //System.out.println(files);
                }}
        }
        return listaExcel;
    }

    // Cambiar para que reciba de un archivo excel y nos retorne la ruta del path
    public static String cortarPegarArchivo(File Excel, String path){

        try{
            File folder = new File(path);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }
            //for (File child : listaExcel ){
                boolean success = Excel.renameTo(new File(path, Excel.getName()));
                if (!success) {
                    System.out.println("error en la copia de archivo.");
                }else{
                    System.out.println("Archivo: " + Excel.getName() + " copiado a ruta.. " + path);
                }
            //}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return path + "\\" + Excel.getName();
    }

}
