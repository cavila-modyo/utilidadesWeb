package com.modyo.automation.utilidad.BD_Automatizacion.FormatData;

public class FD_Excel {

    private String NombreCampo;                 // [0]
    private String FormatoIflex;                // [1]
    private String TipoDato;                    // [2]
    private String DescripcionCampo;            // [3]
    private String PosicionInicial;             // [4]
    private String PosicionFinal;               // [5]
    private String Largo;                       // [6]
    private String DatoPruebaValido;            // [7]
    private String ValorFijo;                   // [8]    ejemplo "solo D, Solo(0-9 + K), Solo(10,20,30)"
    private String NombreInterfaz;              // [9]

    public String getNombreCampo() {
        return NombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        NombreCampo = nombreCampo;
    }

    public String getFormatoIflex() {
        return FormatoIflex;
    }

    public void setFormatoIflex(String formatoIflex) {
        FormatoIflex = formatoIflex;
    }

    public String getDescripcionCampo() {
        return DescripcionCampo;
    }

    public void setDescripcionCampo(String descripcionCampo) {
        DescripcionCampo = descripcionCampo;
    }

    public String getPosicionInicial() {
        return PosicionInicial;
    }

    public void setPosicionInicial(String posicionInicial) {
        PosicionInicial = posicionInicial;
    }

    public String getPosicionFinal() {
        return PosicionFinal;
    }

    public void setPosicionFinal(String posicionFinal) {
        PosicionFinal = posicionFinal;
    }

    public String getLargo() {
        return Largo;
    }

    public void setLargo(String largo) {
        Largo = largo;
    }

    public String getDatoPruebaValido() {
        return DatoPruebaValido;
    }

    public void setDatoPruebaValido(String datoPruebaValido) {
        DatoPruebaValido = datoPruebaValido;
    }

    public String getTipoDato() {
        return TipoDato;
    }

    public void setTipoDato(String tipoDato) {
        TipoDato = tipoDato;
    }
}
