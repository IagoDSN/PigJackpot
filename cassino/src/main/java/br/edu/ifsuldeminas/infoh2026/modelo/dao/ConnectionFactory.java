/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 02338079698
 */
public class ConnectionFactory {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/cassinoonline?useSSL=false";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    //variável estática que mantém a instância única da ConnectionFactory
    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do banco de dados não encontrado", e);
        }
    }

    public static ConnectionFactory getIntance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnetion() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection con = getConnetion();
        return con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    }
}