package com.tresit.automation.utilidad.BD_Automatizacion.Procedures;

import com.tresit.automation.utilidad.BD_Automatizacion.Tablas.EjecucionesLog;
import com.tresit.automation.utilidad.ConexionSQL.ConexionSQLServer;

import java.sql.*;


public class InsertaEjecucion {

    static Connection conect = null;
    static ConexionSQLServer con = new ConexionSQLServer();

    public void InsertaEjecucionTest (Connection con, EjecucionesLog obj) {
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
    }

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


    // Metodo que haga select al ID_Ejecucion que se actualizará....

    public static void main(String[] args) {

        EjecucionesLog obj = new EjecucionesLog();
        conect = con.abrirConexionAutomatizacion();

        obj.setID_Ejecucion(10008);
        obj.setID_Proyecto(2);
        obj.setID_Usuario(2);
        //obj.setID_TestCase(2);
        obj.setID_TestCase(1142);
        obj.setID_TestCycle(150);
        obj.setStatus("pass from aplication");
        obj.setSprint(1);
        obj.setAdjunto(false);

        //InsertaEjecucionTest(conect, obj);
        //long algo = InsertaEjecucionTest_RetornaID(conect, obj);
        //int algo = ActualizaEjecucionTest(conect, 10008, "pass desde aplicacion" );
        //System.out.println("Retorno de Ejecucion: " + algo);

        //con.CerrarConexion(conect);
    }


}
