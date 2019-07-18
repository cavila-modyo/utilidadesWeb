package com.modyo.automation.utilidad.ConexionSQL;

import java.sql.*;

public class ConexionSQLServer {

    static String Error = "Error: ";
    static final String USERQA = "sa";
    static final String PASSQA = "Calidad3it";
    static final String baseDatos = "Automatizacion";
    static final String Query = "select * from usuario;";
    static final String connectionUrlQA = "jdbc:sqlserver://10.128.216.61:1435;database=" + baseDatos ;
    static Connection conect = null;

    /*
    public static void main(String[] args) {
        //ProbarConexion(); // Solo prueba para conexion SQLServer
        //conect = abrirConexion(connectionUrlQA,USERQA,PASSQA);
        conect = abrirConexionAutomatizacion();
        //conect = abrirConexion(connectionUrlDESA,USER,PASS);
        EjecutarQuery(conect,Query);
        //EjecutarQuery(conect,QueryQA);
        CerrarConexion(conect);
    }
*/

    public static Connection abrirConexion(String conection, String user, String pass){
        Connection conn = null;
        try{
            System.out.println("Conectando a base de datos..." + baseDatos);
            conn = DriverManager.getConnection(conection,user,pass);

        }catch(SQLException se){
            System.out.println("Error SQLException: " + se.getMessage());
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Error Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection abrirConexionAutomatizacion(){

        String connectionUrlQA = "jdbc:sqlserver://10.128.216.61:1435;database=" + baseDatos ;
        String USERQA = "sa";
        String PASSQA = "Calidad3it";
        Connection conn = null;

        try{
            System.out.println("Conectando a base de datos..." + baseDatos);
            conn = DriverManager.getConnection(connectionUrlQA,USERQA,PASSQA);

        }catch(SQLException se){
            System.out.println("Error SQLException: " + se.getMessage());
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Error Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection abrirConexionAutomatizacionTest(){

        String connectionUrlQA = "jdbc:sqlserver://10.128.216.61:1435;database=AutomatizacionTest" ;
        String USERQA = "sa";
        String PASSQA = "Calidad3it";
        Connection conn = null;

        try{
            System.out.println("Conectando a base de datos... AutomatizacionTest");
            conn = DriverManager.getConnection(connectionUrlQA,USERQA,PASSQA);

        }catch(SQLException se){
            System.out.println("Error SQLException: " + se.getMessage());
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Error Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void EjecutarQuery(Connection con, String sql){

        Statement stmt = null;
        try{
            System.out.println("Preparando Instrucción SQL...");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                //int id      = rs.getInt("Id");
                int id2      = rs.getInt(1);
                //String usuario = rs.getString("NombreUsuario");
                String usuario2 = rs.getString(4);
                System.out.print(" Item: " + id2);
                System.out.print(", Name: " + usuario2 + "\n");
            }
            rs.close();
            stmt.close();
        }catch(SQLException se){
            System.out.println(Error + se.getMessage());
            se.printStackTrace();
        }catch(Exception e){
            System.out.println(Error + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null){stmt.close();}
            }catch(SQLException se2){}
        }

    }

    public static void CerrarConexion(Connection conn){
        try{
            System.out.println("Cerramos la conexion...");
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException se){
            System.out.println("Error SQLException CerrarConexion: " + se.getMessage());
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Error Exception CerrarConexion:: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
