package com.ll.exam.dao;

import com.ll.exam.dto.BoardDto;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class BoardDao {
    private static String dbUrl;
    private static String dbUser;
    private static String dbpasswd;

    private Connection conn;

    public BoardDao() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        Properties prop = new Properties();
        prop.load(inputStream);

        dbUrl =prop.getProperty("db.url");
        dbUser = prop.getProperty("db.user");
        dbpasswd = prop.getProperty("db.password");

        prop.getProperty("database.url");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbpasswd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<BoardDto> getBoards() {
        List<BoardDto> list = new ArrayList<>();

        String sql = "SELECT * FROM board;";
        try {
             PreparedStatement ps = conn.prepareStatement(sql);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String createDate = rs.getString(2);
                    String modifyDate = rs.getString(3);
                    String name= rs.getString(4);
                    String code = rs.getString(5);


                    BoardDto board = new BoardDto(id, createDate, modifyDate, name, code);
                    list.add(board);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
