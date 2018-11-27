package Util_3it.ConexionSQL;

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

    //public static void EjemploProcAlmacenado (Connection con, String usuario, int atc_id, int testCycle_id, int status, Date fecha, Byte adjunto) {
    public static void EjemploProcAlmacenado (Connection con, int idProyecto, int usuario, int idTestCase,
                                              int testCycle_id, String status, int sprint, Byte adjunto) {
        Statement stmt = null;
        try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call insertaEjecucion (?,?,?,?,?,?,?,?)}");
            // Se definen los parámetros de entrada
            cst.setInt(1, idProyecto);
            cst.setInt(2, usuario);
            cst.setInt(3, idTestCase);
            cst.setInt(4, testCycle_id);
            cst.setInt(5, sprint);
            cst.setString(6, status);
            cst.setByte(7, adjunto);
            // Se definen parámetros de salida
            cst.registerOutParameter("ValorDeSalida", Types.INTEGER);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            int estado = cst.getInt("ValorDeSalida");
            System.out.println("Estado Ejecución: " + estado);
        } catch (SQLException ex) {
            System.out.println(Error + ex.getMessage());
        }finally{
            try{
                if(con!=null){con.close();}
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
