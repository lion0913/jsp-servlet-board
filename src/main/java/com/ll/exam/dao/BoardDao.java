package com.ll.exam.dao;

import com.ll.exam.dto.BoardDto;
import com.ll.exam.type.board.BoardType;
import com.ll.exam.util.DBConnectUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class BoardDao {
    private String dbUrl;
    private String dbUser;
    private String dbpasswd;

    private Connection conn;

    public BoardDao() throws IOException {
        DBConnectUtil dbConnectUtil = new DBConnectUtil();
        conn = dbConnectUtil.connect();
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
                    BoardType code = BoardType.valueOf(rs.getString(5));


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
