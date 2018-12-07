package com.tresit.automation.utilidad.Elementos_Sitios;

public class ElementosUdla {

// Clase que será utilizada para la identificacion de los elementos del sitio UDLA

    private String txt_usuario = "//*[@id=\"login-form\"]/div[2]/div[1]/input";
    private String txt_pass = "//*[@id=\"login-form\"]/div[2]/div[2]/input";
    private String btn_Login = "//*[@id=\"login-form\"]/div[2]/div[3]/button";
    private String opcionInternado = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[1]/div/button[1]";
    private String opcionPasantia = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[1]/div/button[2]";
    private String cmbSede = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select";
    private String cmbSede_Metropolitana = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[1]";
    private String cmbSede_Concepcion = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[2]";
    private String cmbSede_ViñaDelMar = "//*[@id=\"cdk-step-content-0-0\"]/div/div[2]/div[1]/sui-multi-select/div[2]/sui-select-option[3]";
    private String cmbCampus = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select";
    private String cmbCampus_Providencia = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[1]";
    private String cmbCampus_LaFlorida = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[2]";
    private String cmbCampus_Maipu = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[3]";
    private String cmbCampus_SantiagoCentro = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[2]/sui-multi-select/div[2]/sui-select-option[4]";
    private String cmbCarrera = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select";
    private String cmbCarrera_Enfermeria = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[1]";
    private String cmbCarrera_Fonoaudiologia = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[2]";
    private String cmbCarrera_Kinesiologia = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[3]";
    private String cmbCarrera_NutricionyDietetica = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[4]";
    private String cmbCarrera_TerapiaOcupacional = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[5]";
    private String cmbCarrera_TecnicoEnfermeria = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[2]/div[3]/sui-multi-select/div[2]/sui-select-option[6]";
    private String btn_AtrasPaso1 = "//*[@id=\"cdk-step-content-0-0\"]/div/div[3]/button";
    private String btn_AtrasPaso2 = "//*[@id=\"cdk-step-content-1-2\"]/div/div/button[1]";
    private String btn_AtrasPaso3 = "//*[@id=\"cdk-step-content-1-2\"]/div/div/button[1]";
    private String btn_ContinuarPaso1 = "//*[@id=\"cdk-step-content-0-0\"]/div/div[3]/button";
    private String btn_ContinuarPaso2 = "//*[@id=\\\"cdk-step-content-0-0\\\"]/div/div[3]/button";
    private String Labelcupos = "//*[@id=\\\"div1\\\"]/div/div[2]/label";
    private String LabelPreliminar = "//*[@id=\"div1\"]/div/div[2]/label";
    private String popupCupo = "//angular-file-uploader[@id=\"Cupos\"]/div/input";
    private String popupPreliminar = "//angular-file-uploader[@id=\"Alumnos\"]/div/input";
    private String EncabezadoPaso1 = "//*[@id=\"cdk-step-label-1-0\"]/div[3]";
    private String EncabezadoPaso2 = "//*[@id=\"cdk-step-label-1-1\"]/div[3]";
    private String EncabezadoPaso3 = "//*[@id=\"cdk-step-label-1-2\"]/div[3]";
    private String Excelin = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/ng4-loading-spinner[1]/div[2]";
    private String descargaResultado = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]/span[1]";
    private String descargaResultado_Cupos = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[3]/span[1]";
    private String descargaResultado_Alumnos = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[4]/span[1]";
    private String descargaResultado_AlumnosDetalle = "/html[1]/body[1]/app-root[1]/app-layout[1]/section[1]/app-proceso[1]/div[1]/div[1]/div[1]/div[1]/mat-vertical-stepper[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[5]/span[1]";


    public String getTxt_usuario() {
        return txt_usuario;
    }

    public String getTxt_pass() {
        return txt_pass;
    }

    public String getBtn_Login() {
        return btn_Login;
    }

    public String getOpcionInternado() {
        return opcionInternado;
    }

    public String getOpcionPasantia() {
        return opcionPasantia;
    }

    public String getCmbSede() {
        return cmbSede;
    }

    public String getCmbSede_Metropolitana() {
        return cmbSede_Metropolitana;
    }

    public String getCmbSede_Concepcion() {
        return cmbSede_Concepcion;
    }

    public String getCmbSede_ViñaDelMar() {
        return cmbSede_ViñaDelMar;
    }

    public String getCmbCampus() {
        return cmbCampus;
    }

    public String getCmbCampus_Providencia() {
        return cmbCampus_Providencia;
    }

    public String getCmbCampus_LaFlorida() {
        return cmbCampus_LaFlorida;
    }

    public String getCmbCampus_Maipu() {
        return cmbCampus_Maipu;
    }

    public String getCmbCampus_SantiagoCentro() {
        return cmbCampus_SantiagoCentro;
    }

    public String getCmbCarrera() {
        return cmbCarrera;
    }

    public String getCmbCarrera_Enfermeria() {
        return cmbCarrera_Enfermeria;
    }

    public String getCmbCarrera_Fonoaudiologia() {
        return cmbCarrera_Fonoaudiologia;
    }

    public String getCmbCarrera_Kinesiologia() {
        return cmbCarrera_Kinesiologia;
    }

    public String getCmbCarrera_NutricionyDietetica() {
        return cmbCarrera_NutricionyDietetica;
    }

    public String getCmbCarrera_TerapiaOcupacional() {
        return cmbCarrera_TerapiaOcupacional;
    }

    public String getCmbCarrera_TecnicoEnfermeria() {
        return cmbCarrera_TecnicoEnfermeria;
    }

    public String getBtn_AtrasPaso1() {
        return btn_AtrasPaso1;
    }

    public String getBtn_AtrasPaso2() {
        return btn_AtrasPaso2;
    }

    public String getBtn_AtrasPaso3() {
        return btn_AtrasPaso3;
    }

    public String getBtn_ContinuarPaso1() {
        return btn_ContinuarPaso1;
    }

    public String getBtn_ContinuarPaso2() {
        return btn_ContinuarPaso2;
    }

    public String getLabelcupos() {
        return Labelcupos;
    }

    public String getLabelPreliminar() {
        return LabelPreliminar;
    }

    public String getPopupCupo() {
        return popupCupo;
    }

    public String getPopupPreliminar() {
        return popupPreliminar;
    }

    public String getEncabezadoPaso1() {
        return EncabezadoPaso1;
    }

    public String getEncabezadoPaso2() {
        return EncabezadoPaso2;
    }

    public String getEncabezadoPaso3() {
        return EncabezadoPaso3;
    }

    public String getExcelin() {
        return Excelin;
    }

    public String getDescargaResultado() {
        return descargaResultado;
    }

    public String getDescargaResultado_Cupos() {
        return descargaResultado_Cupos;
    }

    public String getDescargaResultado_Alumnos() {
        return descargaResultado_Alumnos;
    }

    public String getDescargaResultado_AlumnosDetalle() {
        return descargaResultado_AlumnosDetalle;
    }
}
