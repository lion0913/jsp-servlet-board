package com.ll.exam.util;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {
    @Getter
    @Setter
    private boolean isDevMode;
    private ConnectionPool connectionPool;

    public DBConnection(String host, int port, String username, String password, String dbName) {
        connectionPool = new ConnectionPool(host, port, username, password, dbName);
    }

    public DBConnection(String host, String username, String password, String dbName) {
        this(host, 3306, username, password, dbName);
    }

    public DBConnection() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String dbHost =prop.getProperty("db.host");
        Integer dbPort =Integer.parseInt(prop.getProperty("db.port"));
        String dbUser = prop.getProperty("db.user");
        String dbPasswd = prop.getProperty("db.password");
        String dbName = prop.getProperty("db.dbName");

        connectionPool = new ConnectionPool(dbHost, dbPort, dbUser, dbPasswd, dbName);
    }

    public SecSql genSecSql() {
        return new SecSql(connectionPool, isDevMode);
    }

    public void run(String sql, Object... bindingDatum) {
        genSecSql().append(sql, bindingDatum).update();
    }

    public void closeConnection() {
        connectionPool.closeConnection();
    }
}
