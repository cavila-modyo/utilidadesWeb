package com.modyo.automation.utilidad.BD_Automatizacion.Procedures;

import com.modyo.automation.utilidad.BD_Automatizacion.FormatData.TCConfig;
import com.modyo.automation.utilidad.BD_Automatizacion.Tablas.EjecucionesLog;
import com.modyo.automation.utilidad.Herramientas.Log;
import com.modyo.automation.utilidad.ConexionSQL.ConexionSQLServer;

import java.sql.*;


public class InsertaEjecucion {

    static Connection conect = null;
    static ConexionSQLServer con = new ConexionSQLServer();

    /*public void InsertaEjecucionTest (Connection con, EjecucionesLog obj) {
        Statement stmt = null;
        try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call insertaEjecucion (?,?,?,?,?,?,?,?,?,?)}");
            // Se definen los parámetros de entrada
            cst.setInt(1, obj.getID_Proyecto());
            cst.setInt(2, obj.getID_Usuario());
            cst.setInt(3, obj.getID_TestCase());
            cst.setInt(4, obj.getID_TestCycle());
            cst.setInt(5, obj.getSprint());
            cst.setString(6, obj.getStatus());
            cst.setBoolean(7, obj.getAdjunto());
            cst.setInt(8, obj.getIdTipoAmbiente());
            cst.setInt(9, obj.getIdTipoEjecucion());

            // Se definen parámetros de salida
            cst.registerOutParameter("ValorDeSalida", Types.INTEGER);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            int estado = cst.getInt("ValorDeSalida");
            System.out.println("Estado Ejecución: " + estado);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try{
                if(con!=null){con.close();}
            }catch(SQLException se2){}
        }
    }*/

    public long InsertaEjecucionTest_RetornaID (Connection con, EjecucionesLog obj) {
        Statement stmt = null;
        long estado = 0;
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call insertaEjecucion_scope (?,?,?,?,?,?,?,?,?,?)}");
            // Se definen los parámetros de entrada
            cst.setInt(1, obj.getID_Proyecto());
            cst.setInt(2, obj.getID_Usuario());
            cst.setInt(3, obj.getID_TestCase());
            cst.setInt(4, obj.getID_TestCycle());
            cst.setInt(5, obj.getSprint());
            cst.setString(6, obj.getStatus());
            cst.setBoolean(7, obj.getAdjunto());
            cst.setInt(8, obj.getIdTipoAmbiente());
            cst.setInt(9, obj.getIdTipoEjecucion());

            cst.registerOutParameter("ValorDeSalida", Types.INTEGER); // Se definen parámetros de salida
            cst.execute(); // Ejecuta el procedimiento almacenado

            estado = cst.getInt("ValorDeSalida");// Se obtienen la salida del procedimineto almacenado

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try{
                if(con!=null){con.close();}
            }catch(SQLException se2){}
        }
        return estado;
    }

    public int ActualizaEjecucionTest (Connection con, long id_Ejecucion, String status) {
        Statement stmt = null;
        int estado = 1;
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call [UpdateStatusEjecucionBY_ID] (?,?,?)}");
            // Se definen los parámetros de entrada
            cst.setLong(1, id_Ejecucion);
            cst.setString(2, status);
            // Se definen parámetros de salida
            cst.registerOutParameter("ValorDeSalida", Types.INTEGER);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            estado = cst.getInt("ValorDeSalida");
            System.out.println("Estado Ejecución: " + estado);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try{
                if(con!=null){con.close();}
            }catch(SQLException se2){}
        }
        return estado;
    }

    public long InsertaEjecucionATC (Connection con, TCConfig obj, int Status, int idError, boolean Adjunto, String Navegador, String Version, String id_Sesion) {
        Statement stmt = null;
        long estado = 0;
        try {
            if (id_Sesion!=null){
                id_Sesion = id_Sesion + ".log";
            }
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call insertaEjecucionATC (?,?,?,?,?,?,?,?,?,?,?,?)}");
            // Se definen los parámetros de entrada
            int ID_Usuario = (int)Double.parseDouble(obj.getID_Usuario());
            String AmbienteEjec = obj.getAmbienteEjecucion().toUpperCase();

            cst.setInt(1, ID_Usuario);
            cst.setString(2, obj.getNombreATC());
            cst.setString(3, obj.getIDHistoria());
            cst.setInt(4, Status);
            cst.setInt(5, idError);
            cst.setBoolean(6, Adjunto);
            cst.setString(7, Navegador);
            cst.setString(8, Version);
            cst.setString(9, AmbienteEjec);
            cst.setString(10, obj.getURL());
            cst.setString(11, id_Sesion);

            Log agregarLog = new Log();

            //String x = "ID_Usuario: " + ID_Usuario + "\nNombreATC: " +  obj.getNombreATC() + "\nhistoria: " +  obj.getIDHistoria() + "\nStatus: " + Status + "\nidError: " + idError + "\nAdjunto: " + Adjunto;
            //x = x + "\nNavegador: " + Navegador + "\nVersion: " + Version + "\nAmbiente: " + obj.getAmbienteEjecucion() + "\nURL: " + obj.getURL();
            //System.out.println("X: " + x);
            //agregarLog.AgregarLoguerDia(x, "C:\\Automatizacion");
            cst.registerOutParameter("ValorDeSalida", Types.INTEGER); // Se definen parámetros de salida
            cst.execute(); // Ejecuta el procedimiento almacenado
            estado = cst.getInt("ValorDeSalida");// Se obtienen la salida del procedimineto almacenado

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con!=null){con.close();}
            }catch(SQLException se2){}
        }
        return estado;
    }


    public int ActualizaEjecucionTestATC (Connection con, long id_Ejecucion, int Status, int id_Error) {
        Statement stmt = null;
        int estado = 1;
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call [UpdateStatusEjecucionATC] (?,?,?,?)}");
            // Se definen los parámetros de entrada
            cst.setLong(1, id_Ejecucion);
            cst.setInt(2, Status);
            cst.setInt(3, id_Error);
            // Se definen parámetros de salida
            cst.registerOutParameter("ValorDeSalida", Types.INTEGER);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            estado = cst.getInt("ValorDeSalida");
            //System.out.println("Estado Ejecución: " + estado);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try{
                if(con!=null){con.close();}
            }catch(SQLException se2){}
        }
        return estado;
    }
}
