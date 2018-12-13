package com.tresit.automation.utilidad.ClasesUtilesUdla;

import com.tresit.automation.utilidad.Herramientas.Texto;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompararArchivos {



    public static void main(String args[]){
        //Csv_Leer();
        // C:\Automatizacion\Documentos Prueba\PruebaExcel.xls
        // C:\Automatizacion\Documentos Prueba\PruebaExcel.xlsx
        //File f = new File("C:\\Users\\3it\\Downloads\\Resultado.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls

        //File f = new File("C:\\Automatizacion\\ATC_TEST\\Descargas\\Resultado.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File f = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\ReporteCupos.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File f = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\ReporteAlumnos.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File f = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\AlumnosFaltantes.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File f = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\AlumnosFaltantesDetalle.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File p = new File("C:\\Automatizacion\\ATC_TEST\\Descargas\\Resultado_comparar.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File p = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\ReporteCupos_comparar.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File p = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\ReporteAlumnos_comparar.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File p = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\AlumnosFaltantes_comparar.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //File p = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\AlumnosFaltantesDetalle_comparar.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls


        File f = new File("C:\\Automatizacion\\UDSGP-255\\MTC_US_UDSGP_05000\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_52\\Descargas\\Resultado_2018-12-13 09_52_30.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        File p = new File("C:\\Automatizacion\\UDSGP-255\\MTC_US_UDSGP_05000\\Resultado (20).xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        comparaListasResultado(f,p,"C:\\Automatizacion\\UDSGP-255\\MTC_US_UDSGP_05000\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_52\\Descargas");

        //comparaListasResultado(f,p,"C:\\Automatizacion\\ATC_TEST\\Descargas");
        //comparaListasResultadoCupo(f,p,"C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas");
        //comparaListasResultadoAlumnoFaltantesDetalle(f,p,"C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas");

        //File f = new File("C:\\Automatizacion\\ATC_TEST\\UDLA\\ATC_US_UDSGP_05000_Validar_Regla_General_SEDE_ID_4\\Descargas\\ReporteCupos.xlsx");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //List<ReporteCupoInternado> lista = LeerExcelConClaseCupoInternado(f);

        //File p = new File("C:\\Automatizacion\\Documentos Prueba\\PruebaExcel.xls");  // Enfermeria - Internado - Cupo_NO_ASIG_EN - copia.xls
        //LeerExcel(p);
    }


    public static void comparaListasResultado(File f, File p, String rutaArchivoComparacion){

        Texto t = new Texto();
        try{
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_1: " + f.getPath(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_2: " + p.getPath(), rutaArchivoComparacion);

            List<ResultadoInternado> lista1 = LeerExcelConClaseResultadoInternado(f);
            List<ResultadoInternado> lista2 = LeerExcelConClaseResultadoInternado(p);

            long cantidadFilasLista1 = lista1.size();
            long cantidadFilasLista2 = lista2.size();
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 1: " + cantidadFilasLista1, rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 2: " + cantidadFilasLista2, rutaArchivoComparacion);

            // ARCHIVOS COMPARADOS (La clase tiene 17 campos)
            for(int i=0; i<=(cantidadFilasLista1-1); i++){
                if(!(lista1.get(i).getSede().equals(lista2.get(i).getSede()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Sede Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getNombreCarrera().equals(lista2.get(i).getNombreCarrera()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreCarrera Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getCarrera().equals(lista2.get(i).getCarrera()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Carrera Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getRut().equals(lista2.get(i).getRut()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Rut Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getNombreCompleto().equals(lista2.get(i).getNombreCompleto()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreCompleto Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getPeriodo().equals(lista2.get(i).getPeriodo()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Periodo Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getCodigoAsignatura().equals(lista2.get(i).getCodigoAsignatura()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoAsignatura Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getNRC().equals(lista2.get(i).getNRC()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NRC Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getNombrePractica().equals(lista2.get(i).getNombrePractica()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombrePractica Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getNombreConvenio().equals(lista2.get(i).getNombreConvenio()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreConvenio Valores Distintos" , rutaArchivoComparacion);
                }
                // FALTA CAMPO CONVENIO
                if(!(lista1.get(i).getESTABLECIMIENTO().equals(lista2.get(i).getESTABLECIMIENTO()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo ESTABLECIMIENTO Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getEstablecimiento_int().equals(lista2.get(i).getEstablecimiento_int()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Establecimiento_int Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getFechaDeInicio().equals(lista2.get(i).getFechaDeInicio()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaDeInicio Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getFechaDeTermino().equals(lista2.get(i).getFechaDeTermino()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaDeTermino Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getRutTutor().equals(lista2.get(i).getRutTutor()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo RutTutor Valores Distintos" , rutaArchivoComparacion);
                }
                if(!(lista1.get(i).getHORARIO().equals(lista2.get(i).getHORARIO()))){
                    t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo HORARIO Valores Distintos" , rutaArchivoComparacion);
                }
            }
            // Recorrer la lista.. Luego los campos de la lista
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);

        }catch(Exception l){
            System.out.println("Error: " + l.getMessage());
            t.ArchivoResultadoComparacion("Error: " + l.getMessage(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
        }

    }

    public static void comparaListasResultadoCupo(File f, File p, String rutaArchivoComparacion){

        Texto t = new Texto();
        try{
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_1: " + f.getPath(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_2: " + p.getPath(), rutaArchivoComparacion);

            List<ReporteCupoInternado> lista1 = LeerExcelConClaseCupoInternado(f);
            List<ReporteCupoInternado> lista2 = LeerExcelConClaseCupoInternado(p);

            long cantidadFilasLista1 = lista1.size();
            long cantidadFilasLista2 = lista2.size();
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 1: " + cantidadFilasLista1, rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 2: " + cantidadFilasLista2, rutaArchivoComparacion);

            // ARCHIVOS COMPARADOS (La clase tiene 17 campos)
            for(int i=0; i<=(cantidadFilasLista1-1); i++){

                if(!(lista1.get(i).getCodigoCarrera().equals(lista2.get(i).getCodigoCarrera()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoCarrera Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getIdCarrera().equals(lista2.get(i).getIdCarrera()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo IdCarrera Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCodigoAsignatura().equals(lista2.get(i).getCodigoAsignatura()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoAsignatura Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getActividad().equals(lista2.get(i).getActividad()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Actividad Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getEstandarGrupoEstudiante().equals(lista2.get(i).getEstandarGrupoEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo EstandarGrupoEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getConvenio().equals(lista2.get(i).getConvenio()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Convenio Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCodigoConvenio().equals(lista2.get(i).getCodigoConvenio()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoConvenio Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getIdConvenio().equals(lista2.get(i).getIdConvenio()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo IdConvenio Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getPrioridad().equals(lista2.get(i).getPrioridad()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Prioridad Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getPago().equals(lista2.get(i).getPago()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Pago Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getEstablecimiento().equals(lista2.get(i).getEstablecimiento()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Establecimiento Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getIdEstablecimientoServicio().equals(lista2.get(i).getIdEstablecimientoServicio()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo IdEstablecimientoServicio Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCritico().equals(lista2.get(i).getCritico()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Critico Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getComuna().equals(lista2.get(i).getComuna()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Comuna Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getHorario().equals(lista2.get(i).getHorario()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Horario Valores Distintos" , rutaArchivoComparacion);}

                if(!(lista1.get(i).getDocente().equals(lista2.get(i).getDocente()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Docente Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getRutDocente().equals(lista2.get(i).getRutDocente()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo RutDocente Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getTipoDocente().equals(lista2.get(i).getTipoDocente()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo TipoDocente Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getFechaRotacion1().equals(lista2.get(i).getFechaRotacion1()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaRotacion1 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCuposRotacion1().equals(lista2.get(i).getCuposRotacion1()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CuposRotacion1 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMinimoCuposRotacion1().equals(lista2.get(i).getMinimoCuposRotacion1()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo MinimoCuposRotacion1 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getFechaRotacion2().equals(lista2.get(i).getFechaRotacion2()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaRotacion2 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCuposRotacion2().equals(lista2.get(i).getCuposRotacion2()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CuposRotacion2 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMinimoCuposRotacion2().equals(lista2.get(i).getMinimoCuposRotacion2()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo MinimoCuposRotacion2 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getFechaRotacion3().equals(lista2.get(i).getFechaRotacion3()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaRotacion3 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCuposRotacion3().equals(lista2.get(i).getCuposRotacion3()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CuposRotacion3 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMinimoCuposRotacion3().equals(lista2.get(i).getMinimoCuposRotacion3()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo MinimoCuposRotacion3 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getFechaRotacion4().equals(lista2.get(i).getFechaRotacion4()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaRotacion4 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCuposRotacion4().equals(lista2.get(i).getCuposRotacion4()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CuposRotacion4 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMinimoCuposRotacion4().equals(lista2.get(i).getMinimoCuposRotacion4()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo MinimoCuposRotacion4 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getFechaRotacion5().equals(lista2.get(i).getFechaRotacion5()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo FechaRotacion5 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCuposRotacion5().equals(lista2.get(i).getCuposRotacion5()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CuposRotacion5 Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMinimoCuposRotacion5().equals(lista2.get(i).getMinimoCuposRotacion5()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo MinimoCuposRotacion5 Valores Distintos" , rutaArchivoComparacion);}

                if(!(lista1.get(i).getVacunaInfluenza().equals(lista2.get(i).getVacunaInfluenza()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo VacunaInfluenza Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getVacunaHepatitisB().equals(lista2.get(i).getVacunaHepatitisB()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo VacunaHepatitisB Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getSerologiaVaricela().equals(lista2.get(i).getSerologiaVaricela()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo SerologiaVaricela Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCoprocultivo().equals(lista2.get(i).getCoprocultivo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Coprocultivo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getExamenParasitologico().equals(lista2.get(i).getExamenParasitologico()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo ExamenParasitologico Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCultivoNasofaringeo().equals(lista2.get(i).getCultivoNasofaringeo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CultivoNasofaringeo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCertificadoAntecedentes().equals(lista2.get(i).getCertificadoAntecedentes()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CertificadoAntecedentes Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCertificadoInhabilidades().equals(lista2.get(i).getCertificadoInhabilidades()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CertificadoInhabilidades Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getAceptaEmbarazadas().equals(lista2.get(i).getAceptaEmbarazadas()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo AceptaEmbarazadas Valores Distintos" , rutaArchivoComparacion);}

            }
            // Recorrer la lista.. Luego los campos de la lista
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);

        }catch(Exception l){
            System.out.println("Error: " + l.getMessage());
            t.ArchivoResultadoComparacion("Error: " + l.getMessage(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
        }

    }

    public static void comparaListasResultadoAlumno(File f, File p, String rutaArchivoComparacion){

        Texto t = new Texto();
        try{
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_1: " + f.getPath(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_2: " + p.getPath(), rutaArchivoComparacion);

            List<ReporteAlumnosInternado> lista1 = LeerExcelConClaseReporteAlumnosInternado(f);
            List<ReporteAlumnosInternado> lista2 = LeerExcelConClaseReporteAlumnosInternado(p);

            long cantidadFilasLista1 = lista1.size();
            long cantidadFilasLista2 = lista2.size();
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 1: " + cantidadFilasLista1, rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 2: " + cantidadFilasLista2, rutaArchivoComparacion);

            // ARCHIVOS COMPARADOS (La clase tiene 17 campos)
            for(int i=0; i<=(cantidadFilasLista1-1); i++){

                if(!(lista1.get(i).getCodigoCampus().equals(lista2.get(i).getCodigoCampus()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoCampus Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNombreCarrera().equals(lista2.get(i).getNombreCarrera()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreCarrera Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getIdCarrera().equals(lista2.get(i).getIdCarrera()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo IdCarrera Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNrc().equals(lista2.get(i).getNrc()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Nrc Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNombreEstudiante().equals(lista2.get(i).getNombreEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getRutEstudiante().equals(lista2.get(i).getRutEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo RutEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCelularEstudiante().equals(lista2.get(i).getCelularEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CelularEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMailEstudiante().equals(lista2.get(i).getMailEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo MailEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getComunaEstudiante().equals(lista2.get(i).getComunaEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo ComunaEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getHorarioLibre().equals(lista2.get(i).getHorarioLibre()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo HorarioLibre Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getHorarioEstudio().equals(lista2.get(i).getHorarioEstudio()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo HorarioEstudio Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getEmbarazo().equals(lista2.get(i).getEmbarazo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Embarazo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getVacunaInfluenza().equals(lista2.get(i).getVacunaInfluenza()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo VacunaInfluenza Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getVacunaHepatitisB().equals(lista2.get(i).getVacunaHepatitisB()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo VacunaHepatitisB Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getSerologiaVaricela().equals(lista2.get(i).getSerologiaVaricela()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo SerologiaVaricela Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCoprocultivo().equals(lista2.get(i).getCoprocultivo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Coprocultivo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getParasitologo().equals(lista2.get(i).getParasitologo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Parasitologo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCultivoNasofaringeo().equals(lista2.get(i).getCultivoNasofaringeo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CultivoNasofaringeo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCertificadoAntecedentes().equals(lista2.get(i).getCertificadoAntecedentes()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CertificadoAntecedentes Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCertificadoInhabilidades().equals(lista2.get(i).getCertificadoInhabilidades()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CertificadoInhabilidades Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNotaCono().equals(lista2.get(i).getNotaCono()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NotaCono Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getAreaPreferenciaADPED().equals(lista2.get(i).getAreaPreferenciaADPED()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo AreaPreferenciaADPED Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getPeriodo().equals(lista2.get(i).getPeriodo()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Periodo Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCodigoAsignatura().equals(lista2.get(i).getCodigoAsignatura()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoAsignatura Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getActividades().equals(lista2.get(i).getActividades()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Actividades Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getRotativasCursar().equals(lista2.get(i).getRotativasCursar()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo RotativasCursar Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getAsignarEn().equals(lista2.get(i).getAsignarEn()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo AsignarEn Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNoAsignarEn().equals(lista2.get(i).getNoAsignarEn()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NoAsignarEn Valores Distintos" , rutaArchivoComparacion);}

            }
            // Recorrer la lista.. Luego los campos de la lista
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);

        }catch(Exception l){
            System.out.println("Error: " + l.getMessage());
            t.ArchivoResultadoComparacion("Error: " + l.getMessage(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
        }

    }

    public static void comparaListasResultadoAlumnoFaltantes(File f, File p, String rutaArchivoComparacion){

        Texto t = new Texto();
        try{
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_1: " + f.getPath(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_2: " + p.getPath(), rutaArchivoComparacion);

            List<AlumnosFaltantesInternado> lista1 = LeerExcelConClaseReporteAlumnosFaltantesInternado(f);
            List<AlumnosFaltantesInternado> lista2 = LeerExcelConClaseReporteAlumnosFaltantesInternado(p);

            long cantidadFilasLista1 = lista1.size();
            long cantidadFilasLista2 = lista2.size();
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 1: " + cantidadFilasLista1, rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 2: " + cantidadFilasLista2, rutaArchivoComparacion);

            // ARCHIVOS COMPARADOS (La clase tiene 17 campos)
            for(int i=0; i<=(cantidadFilasLista1-1); i++){

                if(!(lista1.get(i).getSede().equals(lista2.get(i).getSede()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Sede Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNombreCarrera().equals(lista2.get(i).getNombreCarrera()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreCarrera Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getRutEstudiante().equals(lista2.get(i).getRutEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo RutEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNombreEstudiante().equals(lista2.get(i).getNombreEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCodigoAsignatura().equals(lista2.get(i).getCodigoAsignatura()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo CodigoAsignatura Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNumeroRotativasAsignatura().equals(lista2.get(i).getNumeroRotativasAsignatura()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NumeroRotativasAsignatura Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNumerRotativasAsignadas().equals(lista2.get(i).getNumerRotativasAsignadas()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NumerRotativasAsignadas Valores Distintos" , rutaArchivoComparacion);}

            }
            // Recorrer la lista.. Luego los campos de la lista
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);

        }catch(Exception l){
            System.out.println("Error: " + l.getMessage());
            t.ArchivoResultadoComparacion("Error: " + l.getMessage(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
        }

    }

    public static void comparaListasResultadoAlumnoFaltantesDetalle(File f, File p, String rutaArchivoComparacion){

        Texto t = new Texto();
        try{
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_1: " + f.getPath(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Archivo_2: " + p.getPath(), rutaArchivoComparacion);

            List<AlumnosFaltantesDetalleInternado> lista1 = LeerExcelConClaseReporteAlumnosFaltantesDetalleInternado(f);
            List<AlumnosFaltantesDetalleInternado> lista2 = LeerExcelConClaseReporteAlumnosFaltantesDetalleInternado(p);

            long cantidadFilasLista1 = lista1.size();
            long cantidadFilasLista2 = lista2.size();
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 1: " + cantidadFilasLista1, rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("Cantidad de Registros Archivo 2: " + cantidadFilasLista2, rutaArchivoComparacion);

            // ARCHIVOS COMPARADOS (La clase tiene 17 campos)
            for(int i=0; i<=(cantidadFilasLista1-1); i++){

                if(!(lista1.get(i).getCampus().equals(lista2.get(i).getCampus()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Campus Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getCarrera().equals(lista2.get(i).getCarrera()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Carrera Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getAsignatura().equals(lista2.get(i).getAsignatura()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Asignatura Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getRutEstudiante().equals(lista2.get(i).getRutEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo RutEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getNombreEstudiante().equals(lista2.get(i).getNombreEstudiante()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo NombreEstudiante Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getIdEstablecimiento().equals(lista2.get(i).getIdEstablecimiento()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo IdEstablecimiento Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getEstablecimiento().equals(lista2.get(i).getEstablecimiento()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Establecimiento Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getActividad().equals(lista2.get(i).getActividad()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Actividad Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getRotativa().equals(lista2.get(i).getRotativa()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Rotativa Valores Distintos" , rutaArchivoComparacion);}
                if(!(lista1.get(i).getMensaje().equals(lista2.get(i).getMensaje()))){t.ArchivoResultadoComparacion("FilaExcel : " + (i+2) + ", Campo Mensaje Valores Distintos" , rutaArchivoComparacion);}

            }
            // Recorrer la lista.. Luego los campos de la lista
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);

        }catch(Exception l){
            System.out.println("Error: " + l.getMessage());
            t.ArchivoResultadoComparacion("Error: " + l.getMessage(), rutaArchivoComparacion);
            t.ArchivoResultadoComparacion("********************************************", rutaArchivoComparacion);
        }

    }

    public static List<ResultadoInternado> LeerExcelConClaseResultadoInternado(File archivo) {
        String extension = obtenerExtension(archivo);
        ResultadoInternado res;
        List<ResultadoInternado> listaResultado = new ArrayList<>();
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
                            res = new ResultadoInternado();
                            XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo

                            if (xssfRow != null){
                                if (rowNum > 0) {

                                    //res.setSede(hssfRow.getCell(0).toString());
                                    res.setSede(retornoStringXSSF(xssfRow,0));
                                    res.setNombreCarrera(retornoStringXSSF(xssfRow,1));
                                    res.setCarrera(retornoStringXSSF(xssfRow,2));
                                    res.setRut(retornoStringXSSF(xssfRow,3));
                                    res.setNombreCompleto(retornoStringXSSF(xssfRow,4));
                                    res.setPeriodo(retornoStringXSSF(xssfRow,5));
                                    res.setCodigoAsignatura(retornoStringXSSF(xssfRow,6));
                                    res.setNRC(retornoStringXSSF(xssfRow,7));
                                    res.setNombrePractica(retornoStringXSSF(xssfRow,8));
                                    res.setNombreConvenio(retornoStringXSSF(xssfRow,9));
                                    res.setConvenio(retornoStringXSSF(xssfRow,10));
                                    res.setESTABLECIMIENTO(retornoStringXSSF(xssfRow,11));
                                    res.setEstablecimiento_int(retornoStringXSSF(xssfRow,12));
                                    res.setFechaDeInicio(retornoStringXSSF(xssfRow,13));
                                    res.setFechaDeTermino(retornoStringXSSF(xssfRow,14));
                                    res.setRutTutor(retornoStringXSSF(xssfRow,15));
                                    res.setHORARIO(retornoStringXSSF(xssfRow,16));
                                    listaResultado.add(res); // Se agrega filas a la lista
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
                            res = new ResultadoInternado();
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLS(hssfSheet); // cantidad de celdas de archivo

                            if (hssfRow != null){
                                if (rowNum > 0) {
                                    res.setSede(retornoStringHSSF(hssfRow,0));
                                    res.setNombreCarrera(retornoStringHSSF(hssfRow,1));
                                    res.setCarrera(retornoStringHSSF(hssfRow,2));
                                    res.setRut(retornoStringHSSF(hssfRow,3));
                                    res.setNombreCompleto(retornoStringHSSF(hssfRow,4));
                                    res.setPeriodo(retornoStringHSSF(hssfRow,5));
                                    res.setCodigoAsignatura(retornoStringHSSF(hssfRow,6));
                                    res.setNRC(retornoStringHSSF(hssfRow,7));
                                    res.setNombrePractica(retornoStringHSSF(hssfRow,8));
                                    res.setNombreConvenio(retornoStringHSSF(hssfRow,9));
                                    res.setConvenio(retornoStringHSSF(hssfRow,10));
                                    res.setESTABLECIMIENTO(retornoStringHSSF(hssfRow,11));
                                    res.setEstablecimiento_int(retornoStringHSSF(hssfRow,12));
                                    res.setFechaDeInicio(retornoStringHSSF(hssfRow,13));
                                    res.setFechaDeTermino(retornoStringHSSF(hssfRow,14));
                                    res.setRutTutor(retornoStringHSSF(hssfRow,15));
                                    res.setHORARIO(retornoStringHSSF(hssfRow,16));
                                    listaResultado.add(res); // Se agrega filas a la lista
                                }
                            }
                            /*
                            for (int i= 0; i<= (celdas-1); i++){
                                if (hssfRow != null){
                                    if (rowNum == 0) {
                                        System.out.println("Valor Encabezado: " + hssfRow.getCell(i));
                                    }else{
                                        System.out.println("Valor Fila: " + hssfRow.getCell(i));
                                    }
                                }
                            }*/
                        }
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return listaResultado;
    }

    public static List<ReporteCupoInternado> LeerExcelConClaseCupoInternado(File archivo) {
        String extension = obtenerExtension(archivo);
        ReporteCupoInternado res;
        List<ReporteCupoInternado> listaResultado = new ArrayList<>();
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
                            res = new ReporteCupoInternado();
                            XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo

                            if (xssfRow != null){
                                if (rowNum > 0) {
                                    res.setCodigoCarrera(retornoStringXSSF(xssfRow,0));
                                    res.setIdCarrera(retornoStringXSSF(xssfRow,1));
                                    res.setCodigoAsignatura(retornoStringXSSF(xssfRow,2));
                                    res.setActividad(retornoStringXSSF(xssfRow,3));
                                    res.setEstandarGrupoEstudiante(retornoStringXSSF(xssfRow,4));
                                    res.setConvenio(retornoStringXSSF(xssfRow,5));
                                    res.setCodigoConvenio(retornoStringXSSF(xssfRow,6));
                                    res.setIdConvenio(retornoStringXSSF(xssfRow,7));
                                    res.setPrioridad(retornoStringXSSF(xssfRow,8));
                                    res.setPago(retornoStringXSSF(xssfRow,9));
                                    res.setEstablecimiento(retornoStringXSSF(xssfRow,10));
                                    res.setIdEstablecimientoServicio(retornoStringXSSF(xssfRow,11));
                                    res.setCritico(retornoStringXSSF(xssfRow,12));
                                    res.setComuna(retornoStringXSSF(xssfRow,13));
                                    res.setHorario(retornoStringXSSF(xssfRow,14));
                                    res.setDocente(retornoStringXSSF(xssfRow,15));
                                    res.setRutDocente(retornoStringXSSF(xssfRow,16));
                                    res.setTipoDocente(retornoStringXSSF(xssfRow,17));
                                    res.setFechaRotacion1(retornoStringXSSF(xssfRow,18));
                                    res.setCuposRotacion1(retornoStringXSSF(xssfRow,19));
                                    res.setMinimoCuposRotacion1(retornoStringXSSF(xssfRow,20));
                                    res.setFechaRotacion2(retornoStringXSSF(xssfRow,21));
                                    res.setCuposRotacion2(retornoStringXSSF(xssfRow,22));
                                    res.setMinimoCuposRotacion2(retornoStringXSSF(xssfRow,23));
                                    res.setFechaRotacion3(retornoStringXSSF(xssfRow,24));
                                    res.setCuposRotacion3(retornoStringXSSF(xssfRow,25));
                                    res.setMinimoCuposRotacion3(retornoStringXSSF(xssfRow,26));
                                    res.setFechaRotacion4(retornoStringXSSF(xssfRow,27));
                                    res.setCuposRotacion4(retornoStringXSSF(xssfRow,28));
                                    res.setMinimoCuposRotacion4(retornoStringXSSF(xssfRow,29));
                                    res.setFechaRotacion5(retornoStringXSSF(xssfRow,30));
                                    res.setCuposRotacion5(retornoStringXSSF(xssfRow,31));
                                    res.setMinimoCuposRotacion5(retornoStringXSSF(xssfRow,32));
                                    res.setVacunaInfluenza(retornoStringXSSF(xssfRow,33));
                                    res.setVacunaHepatitisB(retornoStringXSSF(xssfRow,34));
                                    res.setSerologiaVaricela(retornoStringXSSF(xssfRow,35));
                                    res.setCoprocultivo(retornoStringXSSF(xssfRow,36));
                                    res.setExamenParasitologico(retornoStringXSSF(xssfRow,37));
                                    res.setCultivoNasofaringeo(retornoStringXSSF(xssfRow,38));
                                    res.setCertificadoAntecedentes(retornoStringXSSF(xssfRow,39));
                                    res.setCertificadoInhabilidades(retornoStringXSSF(xssfRow,40));
                                    res.setAceptaEmbarazadas(retornoStringXSSF(xssfRow,41));

                                    listaResultado.add(res); // Se agrega filas a la lista
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
                            res = new ReporteCupoInternado();
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLS(hssfSheet); // cantidad de celdas de archivo

                            if (hssfRow != null){
                                if (rowNum > 0) {

                                    res.setCodigoCarrera(retornoStringHSSF(hssfRow,0));
                                    res.setIdCarrera(retornoStringHSSF(hssfRow,1));
                                    res.setCodigoAsignatura(retornoStringHSSF(hssfRow,2));
                                    res.setActividad(retornoStringHSSF(hssfRow,3));
                                    res.setEstandarGrupoEstudiante(retornoStringHSSF(hssfRow,4));
                                    res.setConvenio(retornoStringHSSF(hssfRow,5));
                                    res.setCodigoConvenio(retornoStringHSSF(hssfRow,6));
                                    res.setIdConvenio(retornoStringHSSF(hssfRow,7));
                                    res.setPrioridad(retornoStringHSSF(hssfRow,8));
                                    res.setPago(retornoStringHSSF(hssfRow,9));
                                    res.setEstablecimiento(retornoStringHSSF(hssfRow,10));
                                    res.setIdEstablecimientoServicio(retornoStringHSSF(hssfRow,11));
                                    res.setCritico(retornoStringHSSF(hssfRow,12));
                                    res.setComuna(retornoStringHSSF(hssfRow,13));
                                    res.setHorario(retornoStringHSSF(hssfRow,14));
                                    res.setDocente(retornoStringHSSF(hssfRow,15));
                                    res.setRutDocente(retornoStringHSSF(hssfRow,16));
                                    res.setTipoDocente(retornoStringHSSF(hssfRow,17));
                                    res.setFechaRotacion1(retornoStringHSSF(hssfRow,18));
                                    res.setCuposRotacion1(retornoStringHSSF(hssfRow,19));
                                    res.setMinimoCuposRotacion1(retornoStringHSSF(hssfRow,20));
                                    res.setFechaRotacion2(retornoStringHSSF(hssfRow,21));
                                    res.setCuposRotacion2(retornoStringHSSF(hssfRow,22));
                                    res.setMinimoCuposRotacion2(retornoStringHSSF(hssfRow,23));
                                    res.setFechaRotacion3(retornoStringHSSF(hssfRow,24));
                                    res.setCuposRotacion3(retornoStringHSSF(hssfRow,25));
                                    res.setMinimoCuposRotacion3(retornoStringHSSF(hssfRow,26));
                                    res.setFechaRotacion4(retornoStringHSSF(hssfRow,27));
                                    res.setCuposRotacion4(retornoStringHSSF(hssfRow,28));
                                    res.setMinimoCuposRotacion4(retornoStringHSSF(hssfRow,29));
                                    res.setFechaRotacion5(retornoStringHSSF(hssfRow,30));
                                    res.setCuposRotacion5(retornoStringHSSF(hssfRow,31));
                                    res.setMinimoCuposRotacion5(retornoStringHSSF(hssfRow,32));
                                    res.setVacunaInfluenza(retornoStringHSSF(hssfRow,33));
                                    res.setVacunaHepatitisB(retornoStringHSSF(hssfRow,34));
                                    res.setSerologiaVaricela(retornoStringHSSF(hssfRow,35));
                                    res.setCoprocultivo(retornoStringHSSF(hssfRow,36));
                                    res.setExamenParasitologico(retornoStringHSSF(hssfRow,37));
                                    res.setCultivoNasofaringeo(retornoStringHSSF(hssfRow,38));
                                    res.setCertificadoAntecedentes(retornoStringHSSF(hssfRow,39));
                                    res.setCertificadoInhabilidades(retornoStringHSSF(hssfRow,40));
                                    res.setAceptaEmbarazadas(retornoStringHSSF(hssfRow,41));

                                    listaResultado.add(res); // Se agrega filas a la lista
                                }
                            }
                            /*
                            for (int i= 0; i<= (celdas-1); i++){
                                if (hssfRow != null){
                                    if (rowNum == 0) {
                                        System.out.println("Valor Encabezado: " + hssfRow.getCell(i));
                                    }else{
                                        System.out.println("Valor Fila: " + hssfRow.getCell(i));
                                    }
                                }
                            }*/
                        }
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return listaResultado;
    }

    public static List<ReporteAlumnosInternado> LeerExcelConClaseReporteAlumnosInternado(File archivo) {
        String extension = obtenerExtension(archivo);
        ReporteAlumnosInternado res;
        List<ReporteAlumnosInternado> listaResultado = new ArrayList<>();
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
                            res = new ReporteAlumnosInternado();
                            XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo

                            if (xssfRow != null){
                                if (rowNum > 0) {
                                    res.setCodigoCampus(retornoStringXSSF(xssfRow,0));
                                    res.setNombreCarrera(retornoStringXSSF(xssfRow,1));
                                    res.setIdCarrera(retornoStringXSSF(xssfRow,2));
                                    res.setNrc(retornoStringXSSF(xssfRow,3));
                                    res.setNombreEstudiante(retornoStringXSSF(xssfRow,4));
                                    res.setRutEstudiante(retornoStringXSSF(xssfRow,5));
                                    res.setCelularEstudiante(retornoStringXSSF(xssfRow,6));
                                    res.setMailEstudiante(retornoStringXSSF(xssfRow,7));
                                    res.setComunaEstudiante(retornoStringXSSF(xssfRow,8));
                                    res.setHorarioLibre(retornoStringXSSF(xssfRow,9));
                                    res.setHorarioEstudio(retornoStringXSSF(xssfRow,10));
                                    res.setEmbarazo(retornoStringXSSF(xssfRow,11));
                                    res.setVacunaInfluenza(retornoStringXSSF(xssfRow,12));
                                    res.setVacunaHepatitisB(retornoStringXSSF(xssfRow,13));
                                    res.setSerologiaVaricela(retornoStringXSSF(xssfRow,14));
                                    res.setCoprocultivo(retornoStringXSSF(xssfRow,15));
                                    res.setParasitologo(retornoStringXSSF(xssfRow,16));
                                    res.setCultivoNasofaringeo(retornoStringXSSF(xssfRow,17));
                                    res.setCertificadoAntecedentes(retornoStringXSSF(xssfRow,18));
                                    res.setCertificadoInhabilidades(retornoStringXSSF(xssfRow,19));
                                    res.setNotaCono(retornoStringXSSF(xssfRow,20));
                                    res.setAreaPreferenciaADPED(retornoStringXSSF(xssfRow,21));
                                    res.setPeriodo(retornoStringXSSF(xssfRow,22));
                                    res.setCodigoAsignatura(retornoStringXSSF(xssfRow,23));
                                    res.setActividades(retornoStringXSSF(xssfRow,24));
                                    res.setRotativasCursar(retornoStringXSSF(xssfRow,25));
                                    res.setAsignarEn(retornoStringXSSF(xssfRow,26));
                                    res.setNoAsignarEn(retornoStringXSSF(xssfRow,27));
                                    listaResultado.add(res); // Se agrega filas a la lista
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

                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            res = new ReporteAlumnosInternado();
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLS(hssfSheet); // cantidad de celdas de archivo

                            if (hssfRow != null){
                                if (rowNum > 0) {
                                    res.setCodigoCampus(retornoStringHSSF(hssfRow,0));
                                    res.setNombreCarrera(retornoStringHSSF(hssfRow,1));
                                    res.setIdCarrera(retornoStringHSSF(hssfRow,2));
                                    res.setNrc(retornoStringHSSF(hssfRow,3));
                                    res.setNombreEstudiante(retornoStringHSSF(hssfRow,4));
                                    res.setRutEstudiante(retornoStringHSSF(hssfRow,5));
                                    res.setCelularEstudiante(retornoStringHSSF(hssfRow,6));
                                    res.setMailEstudiante(retornoStringHSSF(hssfRow,7));
                                    res.setComunaEstudiante(retornoStringHSSF(hssfRow,8));
                                    res.setHorarioLibre(retornoStringHSSF(hssfRow,9));
                                    res.setHorarioEstudio(retornoStringHSSF(hssfRow,10));
                                    res.setEmbarazo(retornoStringHSSF(hssfRow,11));
                                    res.setVacunaInfluenza(retornoStringHSSF(hssfRow,12));
                                    res.setVacunaHepatitisB(retornoStringHSSF(hssfRow,13));
                                    res.setSerologiaVaricela(retornoStringHSSF(hssfRow,14));
                                    res.setCoprocultivo(retornoStringHSSF(hssfRow,15));
                                    res.setParasitologo(retornoStringHSSF(hssfRow,16));
                                    res.setCultivoNasofaringeo(retornoStringHSSF(hssfRow,17));
                                    res.setCertificadoAntecedentes(retornoStringHSSF(hssfRow,18));
                                    res.setCertificadoInhabilidades(retornoStringHSSF(hssfRow,19));
                                    res.setNotaCono(retornoStringHSSF(hssfRow,20));
                                    res.setAreaPreferenciaADPED(retornoStringHSSF(hssfRow,21));
                                    res.setPeriodo(retornoStringHSSF(hssfRow,22));
                                    res.setCodigoAsignatura(retornoStringHSSF(hssfRow,23));
                                    res.setActividades(retornoStringHSSF(hssfRow,24));
                                    res.setRotativasCursar(retornoStringHSSF(hssfRow,25));
                                    res.setAsignarEn(retornoStringHSSF(hssfRow,26));
                                    res.setNoAsignarEn(retornoStringHSSF(hssfRow,27));
                                    listaResultado.add(res); // Se agrega filas a la lista
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

        return listaResultado;
    }

    public static List<AlumnosFaltantesInternado> LeerExcelConClaseReporteAlumnosFaltantesInternado(File archivo) {
        String extension = obtenerExtension(archivo);
        AlumnosFaltantesInternado res;
        List<AlumnosFaltantesInternado> listaResultado = new ArrayList<>();
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
                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            res = new AlumnosFaltantesInternado();
                            XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo

                            if (xssfRow != null){
                                if (rowNum > 0) {
                                    res.setSede(retornoStringXSSF(xssfRow,0));
                                    res.setNombreCarrera(retornoStringXSSF(xssfRow,1));
                                    res.setRutEstudiante(retornoStringXSSF(xssfRow,2));
                                    res.setNombreEstudiante(retornoStringXSSF(xssfRow,3));
                                    res.setCodigoAsignatura(retornoStringXSSF(xssfRow,4));
                                    res.setNumeroRotativasAsignatura(retornoStringXSSF(xssfRow,5));
                                    res.setNumerRotativasAsignadas(retornoStringXSSF(xssfRow,6));
                                    listaResultado.add(res); // Se agrega filas a la lista
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

                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            res = new AlumnosFaltantesInternado();
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLS(hssfSheet); // cantidad de celdas de archivo

                            if (hssfRow != null){
                                if (rowNum > 0) {
                                    res.setSede(retornoStringHSSF(hssfRow,0));
                                    res.setNombreCarrera(retornoStringHSSF(hssfRow,1));
                                    res.setRutEstudiante(retornoStringHSSF(hssfRow,2));
                                    res.setNombreEstudiante(retornoStringHSSF(hssfRow,3));
                                    res.setCodigoAsignatura(retornoStringHSSF(hssfRow,4));
                                    res.setNumeroRotativasAsignatura(retornoStringHSSF(hssfRow,5));
                                    res.setNumerRotativasAsignadas(retornoStringHSSF(hssfRow,6));
                                    listaResultado.add(res); // Se agrega filas a la lista
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

        return listaResultado;
    }

    public static List<AlumnosFaltantesDetalleInternado> LeerExcelConClaseReporteAlumnosFaltantesDetalleInternado(File archivo) {
        String extension = obtenerExtension(archivo);
        AlumnosFaltantesDetalleInternado res;
        List<AlumnosFaltantesDetalleInternado> listaResultado = new ArrayList<>();
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
                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            res = new AlumnosFaltantesDetalleInternado();
                            XSSFRow xssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLSX(hssfSheet); // cantidad de celdas de archivo

                            if (xssfRow != null){
                                if (rowNum > 0) {
                                    res.setCampus(retornoStringXSSF(xssfRow,0));
                                    res.setCarrera(retornoStringXSSF(xssfRow,1));
                                    res.setAsignatura(retornoStringXSSF(xssfRow,2));
                                    res.setRutEstudiante(retornoStringXSSF(xssfRow,3));
                                    res.setNombreEstudiante(retornoStringXSSF(xssfRow,4));
                                    res.setIdEstablecimiento(retornoStringXSSF(xssfRow,5));
                                    res.setEstablecimiento(retornoStringXSSF(xssfRow,6));
                                    res.setActividad(retornoStringXSSF(xssfRow,7));
                                    res.setRotativa(retornoStringXSSF(xssfRow,8));
                                    res.setMensaje(retornoStringXSSF(xssfRow,9));
                                    listaResultado.add(res); // Se agrega filas a la lista
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

                        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                            res = new AlumnosFaltantesDetalleInternado();
                            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                            int celdas = getColumnsCountXLS(hssfSheet); // cantidad de celdas de archivo

                            if (hssfRow != null){
                                if (rowNum > 0) {
                                    res.setCampus(retornoStringHSSF(hssfRow,0));
                                    res.setCarrera(retornoStringHSSF(hssfRow,1));
                                    res.setAsignatura(retornoStringHSSF(hssfRow,2));
                                    res.setRutEstudiante(retornoStringHSSF(hssfRow,3));
                                    res.setNombreEstudiante(retornoStringHSSF(hssfRow,4));
                                    res.setIdEstablecimiento(retornoStringHSSF(hssfRow,5));
                                    res.setEstablecimiento(retornoStringHSSF(hssfRow,6));
                                    res.setActividad(retornoStringHSSF(hssfRow,7));
                                    res.setRotativa(retornoStringHSSF(hssfRow,8));
                                    res.setMensaje(retornoStringHSSF(hssfRow,9));

                                    listaResultado.add(res); // Se agrega filas a la lista
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

        return listaResultado;
    }

    // Retorna el valor de la extension
    private static String obtenerExtension(File archivo) {

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



}
