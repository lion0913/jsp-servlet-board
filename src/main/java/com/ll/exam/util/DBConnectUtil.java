package com.ll.exam.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectUtil {
    private Connection conn;

    public Connection connect() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        Properties prop = new Properties();
        prop.load(inputStream);

        String dbUrl =prop.getProperty("db.url");
        String dbUser = prop.getProperty("db.user");
        String dbPasswd = prop.getProperty("db.password");
        String dbDriverName = prop.getProperty("db.driverName");

        prop.getProperty("database.url");
        try {
            Class.forName(dbDriverName);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
