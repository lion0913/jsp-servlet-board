package com.ll.exam.dao;

import com.ll.exam.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class BoardDao {
    private static String dbUrl ="jdbc:mysql://localhost:3306/boardServlet?serverTimezone=Asia/Seoul&useSSL=false";
    private static String dbUser = "root";
    private static String dbpasswd = "lion1065";

    public List<BoardDto> getBoards() {
        List<BoardDto> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM board";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement(sql)) {

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
