package com.tresit.automation.utilidad.ConexionSQL;

import java.sql.*;

public class ConexionMySQL {

    static Connection connect = null;
    static Statement statement = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static Connection ConexionMySQLRipleyQA() throws Exception {
        //
        String BaseDatos = "ripley_bodega_opt";
        String Servidor = "192.241.172.213";
        String User="root";
        String pass = "optimal.2018";

        try {
            //Connection conn = MySQLJDBCUtil.getConnection();
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + Servidor + "/"+ BaseDatos +"?"
                            + "user="+User+"&password="+pass+"");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connect;
    }

    public static Connection ConexionMySQLDefensaQA() throws Exception {
        //
        String BaseDatos = "grupodefensa";
        String Servidor = "192.241.172.213";
        String User="root";
        String pass = "optimal.2018";

        try {
            //Connection conn = MySQLJDBCUtil.getConnection();
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + Servidor + "/"+ BaseDatos +"?"
                            + "user="+User+"&password="+pass+"");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connect;
    }

    public static Connection ConexionMySQLHackaton() throws Exception {
        //
        String BaseDatos = "hackaton";
        String Servidor = "10.128.216.121";
        String User="hackaton";
        String pass = "3it123456.";

        try {
            //Connection conn = MySQLJDBCUtil.getConnection();
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + Servidor + "/"+ BaseDatos +"?"
                            + "user="+User+"&password="+pass+"");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connect;
    }

}
