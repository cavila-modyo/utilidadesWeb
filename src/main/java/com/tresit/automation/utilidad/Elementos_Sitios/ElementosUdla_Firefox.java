package com.tresit.automation.utilidad.Elementos_Sitios;

public class ElementosUdla_Firefox {


// Clase que será utilizada para la identificacion de los elementos del sitio UDLA

    private static String txt_usuario = "/html/body/app-root/app-login/div/div/form/div[2]/div[1]/input"; //
    private static String txt_pass = "/html/body/app-root/app-login/div/div/form/div[2]/div[2]/input";  //
    private static String btn_Login = "/html/body/app-root/app-login/div/div/form/div[2]/div[3]/button";  //

    private static String opcionInternado = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[1]/div/button[1]";
    private static String opcionPasantia = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[1]/div/button[2]";
    private static String cmbSede = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[1]/sui-multi-select";

    private static String cmbSede_Metropolitana = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[1]";
    private static String cmbSede_Concepcion = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[2]";
    private static String cmbSede_ViñaDelMar = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[3]";

    private static String cmbCampus = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select";
    private static String cmbCampus_Providencia = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[1]";
    private static String cmbCampus_LaFlorida = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[2]";
    private static String cmbCampus_Maipu = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[3]";
    private static String cmbCampus_SantiagoCentro = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[4]";
    private static String cmbCampus_ElBodal = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[5]";
    private static String cmbCampus_LosCastanos = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[6]";

    private static String cmbCarrera = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select";
    private static String cmbCarrera_Enfermeria = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[1]";
    private static String cmbCarrera_Fonoaudiologia = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[2]";
    private static String cmbCarrera_Kinesiologia = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[3]";
    private static String cmbCarrera_NutricionyDietetica = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[4]";
    private static String cmbCarrera_TerapiaOcupacional = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[5]";
    private static String cmbCarrera_TecnicoEnfermeria = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[6]";

    // aqui quedamos
    private static String btn_AtrasPaso2 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[2]/button[1]";
    private static String btn_AtrasPaso3 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/div/div/div/div/button[1]";
    private static String btn_ContinuarPaso1 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/div/div/div/div[3]/button";
    private static String btn_ContinuarPaso2 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[2]/button[2]";

    private static String Labelcupos = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[1]/angular-file-uploader/div/div/div/div/div/div[2]/label";
    private static String LabelPreliminar = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[2]/angular-file-uploader/div/div/div/div/div/div[2]/label";

    //private static String popupCupo = "//angular-file-uploader[@id=\"Cupos\"]/div/input";
    private static String popupCupo = "#Cupos";  // by ID
    //private static String popupPreliminar = "//angular-file-uploader[@id=\"Alumnos\"]/div/input";
    private static String popupPreliminar = "#Alumnos";  // by ID

    // No es seguro que encuentre a excelin...
    private static String Excelin = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/ng4-loading-spinner[1]/div[2]";
    private static String Excelin2 = "//*[@id=\"loading-spinner-text\"]";
    private static String Excelin3 = "//*[@id=\"loading-spinner-text\"]";

    private static String EncabezadoPaso1 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[1]/mat-step-header/div[3]/h2";
    private static String EncabezadoPaso2 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/mat-step-header/div[3]/h2";
    private static String EncabezadoPaso3 = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/mat-step-header/div[3]/h2";

    private static String descargaResultado = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/div/div/div/div/button[2]";
    private static String descargaResultado_Cupos = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/div/div/div/div/button[3]";
    private static String descargaResultado_Alumnos = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/div/div/div/div/button[4]";
    private static String descargaResultado_AlumnosFaltante = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/div/div/div/div/button[5]";
    private static String descargaResultado_AlumnosFaltanteDetalle = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[3]/div/div/div/div/button[6]";

    private static String label_DocumentoCupoSubido = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/span";
    private static String label_DocumentoPreliminarSubido = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/span";
    private static String btn_errorCupoDescarga = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/button";
    private static String btn_errorPreliminarDescarga = "/html/body/app-root/app-layout/section/app-proceso/div/div/div/div/mat-vertical-stepper/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/button";


    public static String getTxt_usuario() {
        return txt_usuario;
    }

    public static String getTxt_pass() {
        return txt_pass;
    }

    public static String getBtn_Login() {
        return btn_Login;
    }

    public static String getOpcionInternado() {
        return opcionInternado;
    }

    public static String getOpcionPasantia() {
        return opcionPasantia;
    }

    public static String getCmbSede() {
        return cmbSede;
    }

    public static String getCmbSede_Metropolitana() {
        return cmbSede_Metropolitana;
    }

    public static String getCmbSede_Concepcion() {
        return cmbSede_Concepcion;
    }

    public static String getCmbSede_ViñaDelMar() {
        return cmbSede_ViñaDelMar;
    }

    public static String getCmbCampus() {
        return cmbCampus;
    }

    public static String getCmbCampus_Providencia() {
        return cmbCampus_Providencia;
    }

    public static String getCmbCampus_LaFlorida() {
        return cmbCampus_LaFlorida;
    }

    public static String getCmbCampus_Maipu() {
        return cmbCampus_Maipu;
    }

    public static String getCmbCampus_SantiagoCentro() {
        return cmbCampus_SantiagoCentro;
    }

    public static String getCmbCampus_ElBodal() {
        return cmbCampus_ElBodal;
    }

    public static String getCmbCampus_LosCastanos() {
        return cmbCampus_LosCastanos;
    }

    public static String getCmbCarrera() {
        return cmbCarrera;
    }

    public static String getCmbCarrera_Enfermeria() {
        return cmbCarrera_Enfermeria;
    }

    public static String getCmbCarrera_Fonoaudiologia() {
        return cmbCarrera_Fonoaudiologia;
    }

    public static String getCmbCarrera_Kinesiologia() {
        return cmbCarrera_Kinesiologia;
    }

    public static String getCmbCarrera_NutricionyDietetica() {
        return cmbCarrera_NutricionyDietetica;
    }

    public static String getCmbCarrera_TerapiaOcupacional() {
        return cmbCarrera_TerapiaOcupacional;
    }

    public static String getCmbCarrera_TecnicoEnfermeria() {
        return cmbCarrera_TecnicoEnfermeria;
    }

    public static String getBtn_AtrasPaso2() {
        return btn_AtrasPaso2;
    }

    public static String getBtn_AtrasPaso3() {
        return btn_AtrasPaso3;
    }

    public static String getBtn_ContinuarPaso1() {
        return btn_ContinuarPaso1;
    }

    public static String getBtn_ContinuarPaso2() {
        return btn_ContinuarPaso2;
    }

    public static String getLabelcupos() {
        return Labelcupos;
    }

    public static String getLabelPreliminar() {
        return LabelPreliminar;
    }

    public static String getPopupCupo() {
        return popupCupo;
    }

    public static String getPopupPreliminar() {
        return popupPreliminar;
    }

    public static String getEncabezadoPaso1() {
        return EncabezadoPaso1;
    }

    public static String getEncabezadoPaso2() {
        return EncabezadoPaso2;
    }

    public static String getEncabezadoPaso3() {
        return EncabezadoPaso3;
    }

    public static String getExcelin() {
        return Excelin;
    }

    public static String getDescargaResultado() {
        return descargaResultado;
    }

    public static String getDescargaResultado_Cupos() {
        return descargaResultado_Cupos;
    }

    public static String getDescargaResultado_Alumnos() {
        return descargaResultado_Alumnos;
    }

    public static String getLabel_DocumentoCupoSubido() {
        return label_DocumentoCupoSubido;
    }

    public static String getLabel_DocumentoPreliminarSubido() {
        return label_DocumentoPreliminarSubido;
    }

    public static String getBtn_errorCupoDescarga() {
        return btn_errorCupoDescarga;
    }

    public static String getBtn_errorPreliminarDescarga() {
        return btn_errorPreliminarDescarga;
    }

    public static String getDescargaResultado_AlumnosFaltante() {return descargaResultado_AlumnosFaltante;    }

    public static String getDescargaResultado_AlumnosFaltanteDetalle() {return descargaResultado_AlumnosFaltanteDetalle;}



}
