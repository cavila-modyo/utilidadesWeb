package com.tresit.automation.utilidad.BD_Automatizacion.FormatData;

import com.tresit.automation.utilidad.Herramientas.Texto;

import java.io.File;
import java.util.List;
import static com.tresit.automation.utilidad.Herramientas.Excel.LeerExcelFD;


public class FD_Formato {

    static Texto t = new Texto();
    static String carpetaFD = "C:\\Automatizacion\\ATC\\FD_Automatic"; // carpeta de salida del archivo

    //static File p = new File("C:\\Automatizacion\\ATC\\FD_Automatic\\Ste_FD.xlsx");
    //static String NombreFD = "STE_TEST_ATC.TXT";
    //static String DatoPruebaValido = "111112221414141414141420190101";  // Para el archivo Ste_FD.xlsx

    //static File p = new File("C:\\Automatizacion\\ATC\\FD_Automatic\\Ste_FD_2.xlsx");
    //static String NombreFD = "test_Ste.atc.qa";
    //static String DatoPruebaValido = "66666666AAA8484848333333333333";

    static File p = new File("C:\\Automatizacion\\ATC\\FD_Automatic\\BCHSTED01_STE_FD.xlsx");
    static String NombreFD = "BCHSTED01_STE_TEST_ATC.xlsx.txt";
    static String DatoPruebaValido = "D017763816k66655555abcdefghij0123456789aa7772626262626262626262019031288sssPPPPP88888888pppppppppppppppppp99999filler___";

    // Definir en algun futuro estos valores en una base de datos
    static String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L", "M","N","Ñ","O","P","Q","R","S","T","U","V","W", "X","Y","Z"};
    static String [] numeros = {"0","1","2","3","4","5","6","7","8","9"};
    static String [] simbolos = {"|","°","!","\"","#","$","%","&","/","(",")","=","?","¡","'","[","]","\\","@","*","-"};

    public static void main (String args []){
        CrearInterfaz(p,NombreFD,DatoPruebaValido);
    }

    public static void CrearInterfaz(File o, String NombreFD, String DatoPruebaValido){

        // Considerar que el indice es menos 1.. Osea la posicion real sería la 3
        List<FD_Excel> Lista  = LeerExcelFD(o,2);
        // Cantidad de coleccion de registros que se quieran generar
        //for(int y=1; y<=5; y++) {
        armarDato(Lista);
        t.ArchivoFD("********************************************** FIN CAMPOS INTERFAZ **********************************************",carpetaFD,NombreFD); //System.out.println(DatoGenerado);
        //t.ArchivoFD("********************************************** FIN DATO CICLO FOR " + y + " **********************************************",carpetaFD,NombreFD); //System.out.println(DatoGenerado);
        //}
    }

    public static List<FD_Excel> armarDato(List<FD_Excel> lista){

        try {
            // Cada FD es por campo (cada FD, tiene el nombre del campo, descripcion, largo, etc), puedo aplicar las reglas
            for (int i = 0; i<=(lista.size()-1);i++) {
                if (lista.get(i).getTipoDato().toUpperCase().equals("INT")){
                    System.out.println("For ArmarDato Registro" + lista.get(i).getNombreCampo());
                    ReglasINT(i, lista);
                }
                if (lista.get(i).getTipoDato().toUpperCase().equals("STRING")){
                    System.out.println("For ArmarDato Registro" + lista.get(i).getNombreCampo());
                    ReglasString(i, lista);
                }
                if (lista.get(i).getTipoDato().toUpperCase().equals("DATE")){
                    System.out.println("For ArmarDato Registro" + lista.get(i).getNombreCampo());
                    ReglasFecha(i, lista);
                }
                if (lista.get(i).getTipoDato().toUpperCase().equals("FILLER")){
                    //System.out.println("For ArmarDato Registro" + lista.get(i).getNombreCampo());
                    //Aun no esta definido :(
                }
            }
        }catch(Exception e){
            System.out.println("Error armarDato: " + e.getMessage());
        }
        return lista;
    }

    // INT		 Letras | Simbolos (#,'',!,|,Ñ) | Vacios | Valores Maximos (999999999999) | Valor Minimo (0000000000)
    public static void ReglasINT(int PosicionLista, List<FD_Excel> lista){

        FD_Excel FD = lista.get(PosicionLista);
        String valorRandom = "";
        String ValorDato_Reemplazo = "";
        String ValorDato_Concatenar = "campo: " + FD.getNombreCampo() + ", posini: " + FD.getPosicionInicial() + ", posFin: " + FD.getPosicionFinal();
        t.ArchivoFD("********** INT(Letra,Símbolos,Vacío,ValorMínimo,ValorMáximo)**********\n" + ValorDato_Concatenar,carpetaFD,NombreFD);

        // Hace un switch case por cada regla
        for (int o = 1; o <= 5; o++){
            String DatoGenerado = "";
            switch (o) {
                case 1: // Regla de Letras
                    valorRandom = randomString(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD);
                    break;
                case 2: // Regla de Simbolos
                    valorRandom = randomSimbolos(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 3:   // Regla Vacios
                    valorRandom = ValorVacio(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 4:   // Regla Valores Maximos
                    valorRandom = ValorMaximo(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 5:   // Regla Valores Minimos
                    valorRandom = ValorMinimo(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                default:
                    break;
            }
        }

        t.ArchivoFD("**********FIN**********",carpetaFD,NombreFD);
    }

    //STRING 	 Simbolos (#,'',!,|,Ñ) | Vacios |  numero | Dato No Esperado (Letra o número distinto a valor fijo) |
    public static void ReglasString(int PosicionLista, List<FD_Excel> lista){

        FD_Excel FD = lista.get(PosicionLista);
        String valorRandom = "";
        String ValorDato_Reemplazo = "";
        String ValorDato_Concatenar = "campo: " + FD.getNombreCampo() + ", posini: " + FD.getPosicionInicial() + ", posFin: " + FD.getPosicionFinal();
        t.ArchivoFD("********** STRING(Símbolos,Vacío,Número,ValorNoEsperado(Aun no se implementa))**********\n" + ValorDato_Concatenar,carpetaFD,NombreFD);

        // Hace un switch case por cada regla
        for (int o = 1; o <= 4; o++){
            String DatoGenerado = "";
            switch (o) {
                case 1: // Regla de Simbolos
                    valorRandom = randomSimbolos(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 2:   // Regla Vacios
                    valorRandom = ValorVacio(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 3:   // Regla Valores Numero
                    valorRandom = randomInt(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 4:   // Regla NoEsperado (Aun no va a entrar por aqui)
                    //valorRandom = ValorFijo(Double.parseDouble(FD.getLargo()));
                    valorRandom = randomString(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                default:
                    break;
            }
        }

        t.ArchivoFD("**********FIN**********",carpetaFD,NombreFD);
    }

    //FEchas   Letras | Simbolos (#,'',!,|,Ñ) | Vacios | Valores Maximos Dia, Mes, Año (9999999) (dd/mm/yyyy ; yyyy/mm/dd)  | Valor Minimo (00000) | Fecha Correcta MuyFutura (formato a, b) o Muy Pasada (formato a, b)
    public static void ReglasFecha(int PosicionLista, List<FD_Excel> lista){

        FD_Excel FD = lista.get(PosicionLista);
        String valorRandom = "";
        String ValorDato_Reemplazo = "";
        String ValorDato_Concatenar = "campo: " + FD.getNombreCampo() + ", posini: " + FD.getPosicionInicial() + ", posFin: " + FD.getPosicionFinal();
        t.ArchivoFD("********** DATE(Letras,Simbolos,Vacios,ValoresMinimo,ValorMaximo,FechaCorrectaAntigua,FechaCorrectaFutura)**********\n" + ValorDato_Concatenar,carpetaFD,NombreFD);

        // Hace un switch case por cada regla
        for (int o = 1; o <= 7; o++){
            String DatoGenerado = "";
            switch (o) {
                case 1: // Regla de Letras
                    valorRandom = randomString(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 2: // Regla de Simbolos
                    valorRandom = randomSimbolos(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 3:   // Regla Vacios
                    valorRandom = ValorVacio(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 4:   // Regla Valores Minimos
                    valorRandom = ValorMinimo(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 5:   // Regla Valores Maximos
                    valorRandom = ValorMaximo(Double.parseDouble(FD.getLargo()));
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 6:   // Regla Fecha Correcta Antigua
                    valorRandom = FechaAntigua();
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                case 7:   // Regla Fecha Correcta Futura
                    valorRandom = FechaFutura();
                    ValorDato_Reemplazo = DatoPruebaValido.substring((int)(Double.parseDouble(FD.getPosicionInicial())-1), ((int)Double.parseDouble(FD.getPosicionFinal())));
                    System.out.println("Valor random: " + valorRandom + ", Valor Reemplazo: " + ValorDato_Reemplazo);
                    DatoGenerado = ReempalazarTexto(valorRandom,ValorDato_Reemplazo);
                    t.ArchivoFD(DatoGenerado,carpetaFD,NombreFD); //System.out.println(DatoGenerado);
                    break;
                default:
                    break;
            }
        }

        t.ArchivoFD("**********FIN**********",carpetaFD,NombreFD);
    }

    // Enviarle lo que quieres reemplazar (El valor en la fila del registro, mas el valor nuevo)
    // Ejemplo 111112221414141414141420190101 , quiero reemplazar el primer campo
    // STE_STETO = 11111  por STE_STETO = aaaaa      ReempalazarTexto("aaaaa", "11111");
    public static String ReempalazarTexto (String textoReemplazo, String texto_Encontrar){

        // Pasarle el valor definido arriba
        String resultado = DatoPruebaValido.replace(texto_Encontrar,textoReemplazo);
        //System.out.println("Texto Reemplazado: " + resultado);
        return resultado;
    }

    public static String randomString (double largo){

        String valorRetorno = "";
        try {
            String[] dato = new String[((int) largo)];
            for (int cantidad = 0; cantidad <= largo-1; cantidad++) {
                int numRandon = (int) Math.round(Math.random() * 26);
                dato[cantidad] = abecedario[numRandon];
            }
            for (int y = 0; y <= largo-1; y++) {
                valorRetorno = valorRetorno + dato[y];
            }
        }catch(Exception p){
            System.out.println("Error Generando String: " + p.getMessage());
            t.ArchivoFD("Error INT: "+p.getMessage(),carpetaFD,NombreFD); //System.out.println(DatoGenerado);

        }
        return valorRetorno;
    }

    public static String randomInt(double largo){

        String valorRetorno = "";
        try {
            String[] dato = new String[((int) largo)];
            for (int cantidad = 0; cantidad <= largo-1; cantidad++) {
                int numRandon = (int) Math.round(Math.random() * 9);
                dato[cantidad] = numeros[numRandon];
            }
            for (int y = 0; y <= largo-1; y++) {
                valorRetorno = valorRetorno + dato[y];
            }
        }catch(Exception p){
            t.ArchivoFD("Error Random INT: "+p.getMessage(),carpetaFD,NombreFD); //System.out.println(DatoGenerado);
        }
        return valorRetorno;

    }

    // Generar rut validos al azar

    public static String randomSimbolos(double largo){

        String valorRetorno = "";
        try {
            String[] dato = new String[((int) largo)];
            for (int cantidad = 0; cantidad <= largo-1; cantidad++) {
                int numRandon = (int) Math.round(Math.random() * 20);
                dato[cantidad] = simbolos[numRandon];
            }
            for (int y = 0; y <= largo-1; y++) {
                valorRetorno = valorRetorno + dato[y];
            }
        }catch(Exception p){
            t.ArchivoFD("Error Random Simbolos: "+ p.getMessage(),carpetaFD,NombreFD); //System.out.println(DatoGenerado);

        }
        return valorRetorno;
    }

    public static String ValorMaximo(double largo){
        String valorRetorno = "";
        for (int y = 0; y <= largo-1; y++) {
            valorRetorno = valorRetorno + "9";
        }
        return valorRetorno;
    }

    public static String ValorMinimo(double largo){
        String valorRetorno = "";
        for (int y = 0; y <= largo-1; y++) {
            valorRetorno = valorRetorno + "0";
        }
        return valorRetorno;
    }

     public static String ValorVacio(double largo){
        String valorRetorno = "";
        for (int y = 0; y <= largo-1; y++) {
            valorRetorno = valorRetorno + " ";
        }
        return valorRetorno;
    }

    public static String FechaAntigua(){
        return "10000101"; // Formato AAAAMMDD
    }

    public static String FechaFutura(){
        return "50000101"; // Formato AAAAMMDD
    }

    // Mi idea es enviarle el valor fijo del campo
    // y si el random da un valor distinto, entonces que lo retorne
    public static String ValorFijo(double largo){

        /*String valorRetorno = "";
        try {
            String[] dato = new String[((int) largo)];
            for (int cantidad = 0; cantidad <= largo-1; cantidad++) {
                int numRandon = (int) Math.round(Math.random() * 26);
                dato[cantidad] = abecedario[numRandon];
            }
            for (int y = 0; y <= largo-1; y++) {
                valorRetorno = valorRetorno + dato[y];
            }
        }catch(Exception p){
            System.out.println("Error Generando String: " + p.getMessage());
            t.ArchivoFD("Error INT: "+p.getMessage(),carpetaFD,NombreFD); //System.out.println(DatoGenerado);

        }
        return valorRetorno;
        */
        return "";
    }

    // Test de reemplazar un texto dado su posicion en un registro FD
    public static void ReempalazarTexto_Test (int posInicial, int posFinal, String textoReemplazo) {
        //ReempalazarTexto(9,22,"aaaaaaaaaaaaaa");
        String texto = "111112221414141414141420190101"; // Tiene largo 20
        String ValorDato_Reemplazo = texto.substring((posInicial - 1), (posFinal));
        textoReemplazo = textoReemplazo.replace(ValorDato_Reemplazo,texto);
        //System.out.println("Texto Reemplazado: " + textoReemplazo);
    }

}
