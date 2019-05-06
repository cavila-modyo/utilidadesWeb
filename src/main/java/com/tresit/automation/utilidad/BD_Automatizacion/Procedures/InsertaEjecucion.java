package com.tresit.automation.utilidad.BD_Automatizacion.Procedures;

import com.tresit.automation.utilidad.BD_Automatizacion.Tablas.EjecucionesLog;
import com.tresit.automation.utilidad.BD_Automatizacion.FormatData.TCConfig;
import com.tresit.automation.utilidad.ConexionSQL.ConexionSQLServer;

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

    public long InsertaEjecucionATC (Connection con, TCConfig obj, int Status, int idError, boolean Adjunto, String Navegador, String Version) {
        Statement stmt = null;
        long estado = 0;
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call insertaEjecucionATC (?,?,?,?,?,?,?,?,?,?)}");
            // Se definen los parámetros de entrada
            int ID_Usuario = (int)Double.parseDouble(obj.getID_Usuario());

            cst.setInt(1, ID_Usuario);
            cst.setString(2, obj.getIDHistoria());
            cst.setInt(3, Status);
            cst.setInt(4, idError);
            cst.setBoolean(6, Adjunto);
            cst.setString(7, Navegador);
            cst.setString(8, Version);
            cst.setString(10, obj.getAmbienteEjecucion());
            cst.setString(11, obj.getURL());
/*            System.out.println("ID_PROYECTO: " + ID_Proyecto);
            System.out.println("ID_Usuario: " + ID_Usuario);
            System.out.println("CP: " + CP);
            System.out.println("Sprint: " + Sprint);
            System.out.println("Status: " + Status);
            System.out.println("IdTipoAmbiente: " + idTipoEjecucionAmbiente);
            System.out.println("IdTipoEjecucion: " + idTipoEjecucion);
            System.out.println("VersionTipoAmbiente: " + obj.getVersionTipoAmbiente());
            System.out.println("getAmbienteEjecucion: " + obj.getAmbienteEjecucion());
            System.out.println("getURL" + obj.getURL());*/
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


    public int ActualizaEjecucionTestATC (Connection con, long id_Ejecucion, int Status, int id_Error) {
        Statement stmt = null;
        int estado = 1;
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call [UpdateStatusEjecucionATC] (?,?,?)}");
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
