package com.tresit.automation.utilidad.BD_Automatizacion.Tablas;

import java.util.Date;

public class EjecucionesLog {

    private long ID_Ejecucion;
    private Integer ID_Proyecto;
    private Integer ID_Usuario;
    private Integer ID_TestCas;
    private Integer ID_TestCycle;
    private Integer Sprint;
    private String Status;
    private Date Fecha;
    private Boolean Adjunto;
    private Integer idTipoAmbiente;
    private Integer idTipoEjecucion;


    public long getID_Ejecucion() {
        return ID_Ejecucion;
    }

    public void setID_Ejecucion(Integer ID_Ejecucion) {
        this.ID_Ejecucion = ID_Ejecucion;
    }

    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }

    public void setID_Proyecto(Integer ID_Proyecto) {
        this.ID_Proyecto = ID_Proyecto;
    }

    public Integer getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(Integer ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public Integer getID_TestCase() {
        return ID_TestCas;
    }

    public void setID_TestCase(Integer ID_TestCas) {
        this.ID_TestCas = ID_TestCas;
    }

    public Integer getID_TestCycle() {
        return ID_TestCycle;
    }

    public void setID_TestCycle(Integer ID_TestCycle) {
        this.ID_TestCycle = ID_TestCycle;
    }

    public Integer getSprint() {
        return Sprint;
    }

    public void setSprint(Integer sprint) {
        Sprint = sprint;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Boolean getAdjunto() {
        return Adjunto;
    }

    public void setAdjunto(Boolean adjunto) {
        Adjunto = adjunto;
    }

    public Integer getIdTipoAmbiente() { return idTipoAmbiente; }

    public void setIdTipoAmbiente(Integer idTipoAmbiente) { this.idTipoAmbiente = idTipoAmbiente; }

    public Integer getIdTipoEjecucion() { return idTipoEjecucion; }

    public void setIdTipoEjecucion(Integer idTipoEjecucion) { this.idTipoEjecucion = idTipoEjecucion; }

}
