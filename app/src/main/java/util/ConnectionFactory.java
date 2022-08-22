/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author igor8
 */
public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3310/projects";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static Connection getConnection() {
        try {

            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro de conexão com o banco de dados ", e);
        }

    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ou fechar a conexão com o banco de dados ", e);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement statemant) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (statemant != null) {
                statemant.close();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ou fechar a conexão com o banco de dados ", e);
        }
    }
    
       public static void closeConnection(Connection conn, PreparedStatement statemant, ResultSet resultSet) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (statemant != null) {
                statemant.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ou fechar a conexão com o banco de dados ", e);
        }
    }

}
