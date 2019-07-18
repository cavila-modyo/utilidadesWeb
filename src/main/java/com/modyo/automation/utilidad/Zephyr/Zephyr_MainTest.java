package com.modyo.automation.utilidad.Zephyr;

import com.modyo.automation.utilidad.Herramientas.Excel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Zephyr_MainTest {

    static Excel E = new Excel();
    static List<UserTestExcel> TestCases = new ArrayList<>();

    //Se pasan los user y pass desde un archivo excel
    // Implementar el uso de clave encriptada

    // de la clase
    //static int releaseTestScheduleId = 149;
    //static int key = 1;
    //static String value = "Valor x para testStep";
    //static int testerId = 2;

    static String IdUserLogueado = "";
    static String split;
    static String releaseTestScheduleId = "";
    static String TesterId = "";


    public static ObtenerToken tok = new ObtenerToken();
    public static getTestSchedulesByCriteria TestSchedule = new getTestSchedulesByCriteria();
    public static UpdateTestStatus UpdateTestCase  = new UpdateTestStatus();
    public static getUsersByCriteria getUser  = new getUsersByCriteria();

    static String ExcecutionTestCase = "1";

    public static void main(String[] args) {

        TestCases = listaTestCase(); // "C:\\Automatizacion\\Documentos Prueba\\PruebaExcel.xlsx"

        if(TestCases.size()>0) {

            // Sería como recorrer el archivo Excel
            for (int i = 0; i<TestCases.size(); i++ ) {
                String token = tok.RetornaToken_Zephyr(TestCases.get(i).getNombre(), TestCases.get(i).getPass());
                System.out.println("Token: " + token);

                if (token != "No hay Return") {
                    try {

                        double value1 = Double.parseDouble(TestCases.get(i).getId());
                        int id = (int) value1;

                        IdUserLogueado = getUser.EjecutarGetUsersByCriteria(token, TestCases.get(i).getNombre());
                        System.out.println("Id User logueado: " + IdUserLogueado);
                        System.out.println("Id TestCase a Buscar: " + id);

                        split = TestSchedule.EjecutarGetTesteSchudleByCriteria(token, String.valueOf(id));  // Se busca el id para actualizar el caso
                        String[] parts = split.split(",");
                        releaseTestScheduleId = parts[0];
                        TesterId = parts[1];
                        System.out.println("releaseTestScheduleId relacionado al TestCase: " + releaseTestScheduleId);
                        System.out.println("TesterId relacionado al releaseTestScheduleId: " + TesterId);

                        // Ejecutar el test
                        if (IdUserLogueado.equals(TesterId)) {// Se puede ejecutar el update
                            // String token , String releaseTestScheduleId, String testerId, String executionStatus
                            UpdateTestCase.EjecutarUpdate(token, releaseTestScheduleId, TesterId, ExcecutionTestCase, "No se usa, crear clase con rutas");
                        } else {
                            System.out.println("El id del usuario logueado y el id del test case que se desea cambiar el status no coinciden");
                        }
                        //  // Enviarle el idTestSchedule

                    } catch (Exception p) {
                        System.out.println("Error: " + p.getMessage());
                    }
                } else {
                    System.out.println("No se generó token.");
                }
            }
        }
    }

    public static List<UserTestExcel> listaTestCase(){

        List<UserTestExcel> TestCases = new ArrayList<>();
        try{

            File F = new File("C:\\Automatizacion\\Documentos Prueba\\PruebaExcel.xlsx");
            System.out.println("Extension archivo: " + E.obtenerExtension(F));

            TestCases = LeerExcel(F);
        }catch(Exception p){
            System.out.println("Error al obtener los TestCase: " + p.getMessage());
        }
        return TestCases;
    }


    static UserTestExcel TestCase = new UserTestExcel();

    public static List<UserTestExcel> LeerExcel(File archivo) {
        List<UserTestExcel> TestCases = new ArrayList<>();
        String extension = E.obtenerExtension(archivo);
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
                        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            if (hssfRow != null) {
                                TestCase = new UserTestExcel();
                                //(hssfRow.getCell(0).getCellType() == Cell.CELL_TYPE_STRING)?hssfRow.getCell(0).getStringCellValue():
                                if (rowNum == 0) {
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(0));
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(1));
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(2));
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(3));

                                }else{
                                    TestCase.setId(hssfRow.getCell(0).toString());
                                    TestCase.setNombre(hssfRow.getCell(1).toString());
                                    TestCase.setPass(hssfRow.getCell(2).toString());
                                    //TestCase.setExecStatus(hssfRow.getCell(3).toString());
                                    //System.out.println("Valor Fila: " + hssfRow.getCell(0));
                                    TestCases.add(TestCase);
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
                    for (int numSheet = 1; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                        HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                        if (hssfSheet == null) {
                            continue;
                        }
                        // Read the Row
                        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            if (hssfRow != null) {
                                if (rowNum == 0) {
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(0));
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(1));
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(2));
                                    System.out.println("Valor Encabezado: " + hssfRow.getCell(3));
                                }else{
                                    TestCase.setId(hssfRow.getCell(0).toString());
                                    TestCase.setNombre(hssfRow.getCell(1).toString());
                                    TestCase.setPass(hssfRow.getCell(2).toString());
                                    //TestCase.setExecStatus(hssfRow.getCell(3).toString());
                                    //System.out.println("Valor Fila: " + hssfRow.getCell(0));
                                    TestCases.add(TestCase);
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
        return TestCases;

    }


}
