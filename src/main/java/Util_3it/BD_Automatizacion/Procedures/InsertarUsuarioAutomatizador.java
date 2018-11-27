package Util_3it.BD_Automatizacion.Procedures;

import Util_3it.ConexionSQL.ConexionSQLServer;
import Util_3it.BD_Automatizacion.Tablas.*;

import java.sql.*;

public class InsertarUsuarioAutomatizador {

    static Connection conect = null;
    static ConexionSQLServer con = new ConexionSQLServer();

    public void InsertaUsuarioAutomatizadorTest (Connection con, UsuarioAutomatizador obj) {
        Statement stmt = null;
        try {

                /*
    * USE [Automatizacion]
GO

CREATE PROCEDURE [dbo].[insertaUsuario]
(
@ID_Usuario int,
@Nombre_Usuario varchar(50),
-- @Activo bit,
@Nombre varchar(100),
@Email varchar(100),
@ValorDeSalida int OUT
)
AS
begin


INSERT INTO
	Usuario (ID_Usuario, Nombre_Usuario, Activo, Nombre, Email)
    VALUES (@ID_Usuario, @Nombre_Usuario, 1, @Nombre, @Email)

	set @ValorDeSalida = 0
	return @ValorDeSalida
end
    * */
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.prepareCall("{call insertaUsuario (?,?,?,?,?)}");
            // Se definen los parámetros de entrada
            cst.setInt(1, obj.getID_Usuario());
            cst.setString(2, obj.getNombre_Usuario());
            cst.setString(3, obj.getNombre());
            cst.setString(4, obj.getEmail());
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

    /*
    public static void main(String[] args) {

        UsuarioAutomatizador obj = new UsuarioAutomatizador();
        conect = con.abrirConexionAutomatizacion();

        obj.setID_Usuario(12);
        obj.setNombre_Usuario("UsuarioTest2");
        obj.setNombre("UsuarioTest_Nombre2");
        // obj.setActivo(false);
        obj.setEmail("UsuarioTest2@3it.cl");

        InsertaUsuarioAutomatizadorTest(conect, obj);

        con.CerrarConexion(conect);
    }
    */


}
