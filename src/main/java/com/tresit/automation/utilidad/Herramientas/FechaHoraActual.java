package com.tresit.automation.utilidad.Herramientas;

import java.util.Date;


public class FechaHoraActual {

    Date fechaACtual = new Date();
    long lnMilisegundos = fechaACtual.getTime();
    private java.sql.Time Hora = new java.sql.Time(lnMilisegundos);
    private java.sql.Date Fecha = new java.sql.Date(lnMilisegundos);

    /*
    * @description Obtine hora ACtual local
    */
    public java.sql.Time getHora() {
        return Hora;
    }

    public void setHora(java.sql.Time actualTime) {
        this.Hora = actualTime;
    }

    /*
     * @description Obtine Fecha Actual local
     */
    public java.sql.Date getFecha() {
        return Fecha;
    }

    /*
     * @description Obtine la hora actual en formato Stirng
     */
    public String getHoraString() {
        String HoraString = this.Hora.toString().replace(":", "-");
        return HoraString;
    }

    public void setFecha(java.sql.Date executionDate) {
        this.Fecha = executionDate;
    }
}
