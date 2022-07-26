package com.ll.exam.util;

import lombok.Getter;
import lombok.Setter;

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
