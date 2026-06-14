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
 * package br.edu.ifsuldeminas.infoh2026.database;

import io.github.cdimascio.dotenv.Dotenv;

    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL =
            dotenv.get("DB_URL");
    private static final String DB_DRIVER =
            dotenv.get("DB_DRIVER");
    private static final String DB_USER =
            dotenv.get("DB_USER");
    private static final String DB_PASSWORD =
            dotenv.get("DB_PASSWORD");
    private static ConnectionFactory instance;
}
 */
public class ConnectionFactory {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cassinoonline?useSSL=false";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "ogai2009";

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