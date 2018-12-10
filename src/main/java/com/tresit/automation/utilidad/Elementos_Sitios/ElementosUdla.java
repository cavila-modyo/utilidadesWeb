package com.tresit.automation.utilidad.Elementos_Sitios;

public class ElementosUdla {

// Clase que será utilizada para la identificacion de los elementos del sitio UDLA

    //private static String txt_usuario = "//*[@id=\"login-form\"]/div[2]/div[1]/input"; // /html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]
    private static String txt_usuario = "/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"; //
    //private static String txt_pass = "//*[@id=\"login-form\"]/div[2]/div[2]/input";  // /html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]
    private static String txt_pass = "/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]";  //
    //private static String btn_Login = "//*[@id=\"login-form\"]/div[2]/div[3]/button";  // /html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[3]/button[1]
    private static String btn_Login = "/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/div[3]/button[1]";  //

    //private static String opcionInternado = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[1]/div/button[1]";
    private static String opcionInternado = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]";
    //private static String opcionPasantia = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[1]/div/button[2]";
    private static String opcionPasantia = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]";
    //private static String cmbSede = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select";
    private static String cmbSede = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/sui-multi-select[1]";
    //private static String cmbSede_Metropolitana = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[1]";
    private static String cmbSede_Metropolitana = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/sui-multi-select[1]/div[2]/sui-select-option[1]";
    //private static String cmbSede_Concepcion = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[2]";
    private static String cmbSede_Concepcion = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/sui-multi-select[1]/div[2]/sui-select-option[2]";
    //private static String cmbSede_ViñaDelMar = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[3]";
    private static String cmbSede_ViñaDelMar = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/sui-multi-select[1]/div[2]/sui-select-option[3]";

    //private static String cmbCampus = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select";
    private static String cmbCampus = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]";
    //private static String cmbCampus_Providencia = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[1]";
    private static String cmbCampus_Providencia = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[1]";
    //private static String cmbCampus_LaFlorida = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[2]";
    private static String cmbCampus_LaFlorida = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[2]";
    //private static String cmbCampus_Maipu = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[3]";
    private static String cmbCampus_Maipu = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[3]";
    //private static String cmbCampus_SantiagoCentro = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[4]";
    private static String cmbCampus_SantiagoCentro = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[4]";
    private static String cmbCampus_ElBodal = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[5]";
    private static String cmbCampus_Chacabuco = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[6]";
    private static String cmbCampus_LosCastanos = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/sui-multi-select[1]/div[2]/sui-select-option[7]";

    //private static String cmbCarrera = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select";
    private static String cmbCarrera = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]";
    private static String cmbCarrera_Enfermeria = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]/div[2]/sui-select-option[1]";
    private static String cmbCarrera_Fonoaudiologia = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]/div[2]/sui-select-option[2]";
    private static String cmbCarrera_Kinesiologia = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]/div[2]/sui-select-option[3]";
    private static String cmbCarrera_NutricionyDietetica = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]/div[2]/sui-select-option[4]";
    private static String cmbCarrera_TerapiaOcupacional = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]/div[2]/sui-select-option[5]";
    private static String cmbCarrera_TecnicoEnfermeria = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/sui-multi-select[1]/div[2]/sui-select-option[6]";

    //private static String btn_AtrasPaso2 = "//*[@id=\"cdk-step-content-1-2\"]/div/div/button[1]";
    private static String btn_AtrasPaso2 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]";
    //private static String btn_AtrasPaso3 = "//*[@id=\"cdk-step-content-1-2\"]/div/div/button[1]";
    private static String btn_AtrasPaso3 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]";
    //private static String btn_ContinuarPaso1 = "//*[@id=\"cdk-step-content-0-0\"]/div/div[3]/button";
    private static String btn_ContinuarPaso1 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]";
    //private static String btn_ContinuarPaso2 = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[3]/button";
    private static String btn_ContinuarPaso2 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]";
    //private static String Labelcupos = "//*[@id=\\\"div1\\\"]/div/div[2]/label";
    private static String Labelcupos = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/angular-file-uploader[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]";
    //private static String LabelPreliminar = "//*[@id=\"div1\"]/div/div[2]/label";
    private static String LabelPreliminar = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/angular-file-uploader[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]";
    private static String popupCupo = "//angular-file-uploader[@id=\"Cupos\"]/div/input";
    private static String popupPreliminar = "//angular-file-uploader[@id=\"Alumnos\"]/div/input";
    private static String EncabezadoPaso1 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[1]/mat-step-header[1]/div[3]/h2[1]";
    private static String EncabezadoPaso2 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/mat-step-header[1]/div[3]/h2[1]";
    private static String EncabezadoPaso3 = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/mat-step-header[1]/div[3]/h2[1]";
    private static String Excelin = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/ng4-loading-spinner[1]/div[2]";
    private static String descargaResultado = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]/span[1]";
    private static String descargaResultado_Cupos = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[3]/span[1]";
    private static String descargaResultado_Alumnos = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[4]/span[1]";
    private static String descargaResultado_AlumnosDetalle = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[5]/span[1]";

    private static String label_DocumentoCupoSubido = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]";
    private static String label_DocumentoPreliminarSubido = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]";
    private static String btn_errorCupoDescarga = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]";
    private static String btn_errorPreliminarDescarga = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]";


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

    public static String getCmbCampus_Chacabuco() {
        return cmbCampus_Chacabuco;
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

    public static String getDescargaResultado_AlumnosDetalle() {
        return descargaResultado_AlumnosDetalle;
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


}
