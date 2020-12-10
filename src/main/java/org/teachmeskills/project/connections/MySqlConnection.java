package org.teachmeskills.project.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/transport_compani_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "my76sql423ol28eg28a_";

    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL, USER, PASSWORD); }
}
