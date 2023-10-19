/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fantasygame.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Augusto Bitiano
 */

public class CriarBanco {
    private static Connection connection;

    public static void criarBancoDB() {
        // String jdbcUrl =
        // "jdbc:mysql://aws.connect.psdb.cloud/tasks?sslMode=VERIFY_IDENTITY";
        // String username = "syfhghmd0lngtijex8l8";
        // String password = "pscale_pw_DbVAjQCzuKA5vdG4NIXtA66tBDSEtVvPkdB9rmYvqw4";

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database?useSSL=false",
                    "admin",
                    "root");
            if (connection != null) {
                System.out.println("Conexão com o banco de dados estabelecida!");

                createDatabase(connection);
                useDatabase(connection);
                createUserTable(connection);
                createTaskTable(connection);

                System.out.println("Banco de dados e tabelas criados com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS tasksPlataform";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createDatabaseSQL);
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE tasksPlataform";
        try (Statement statement = connection.createStatement()) {
            statement.execute(useDatabaseSQL);
        }
    }

    private static void createUserTable(Connection connection) throws SQLException {
        String createUserTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "password VARCHAR(255) NOT NULL,"
                + "isAdmin BOOLEAN,"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
                + ")ENGINE=InnoDB";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createUserTableSQL);
        }
    }

    private static void createTaskTable(Connection connection) throws SQLException {
        String createTaskTableSQL = "CREATE TABLE IF NOT EXISTS Task ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "titulo VARCHAR(255),"
                + "descricao TEXT,"
                + "dataCriacao DATE,"
                + "dataAtualizacao DATE,"
                + "dataConclusao DATE,"
                + "status VARCHAR(255)"
                + "user_id INT NOT NULL"
                + "CONSTRAINT FK_TasksUser FOREIGN KEY (user_id) REFERENCES User(id)"
                + ")";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTaskTableSQL);
        }
    }
}
