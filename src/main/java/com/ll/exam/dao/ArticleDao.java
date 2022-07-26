package com.ll.exam.dao;

import com.ll.exam.dto.ArticleDto;
import com.ll.exam.dto.BoardDto;
import com.ll.exam.type.board.BoardType;
import com.ll.exam.util.DBConnectUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    private Connection conn;

    public ArticleDao() throws IOException {
        DBConnectUtil dbConnectUtil = new DBConnectUtil();
        conn = dbConnectUtil.connect();
    }

    public List<ArticleDto> getBoards() {
        List<ArticleDto> list = new ArrayList<>();

        String sql = "select a.id, a.createDate, a.title, a.body, b.name from article a inner join board b on a.boardId = b.id order by b.name, a.createDate;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String createDate = rs.getString(2);
                    String title= rs.getString(3);
                    String body= rs.getString(4);
                    String name = rs.getString(5);


                    ArticleDto board = new ArticleDto(id, createDate, title, body, name);
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

    public void writeArticle(String title, String body) {
        if(title == null) return;

        String sql = "insert into article set id=%d, createDate = %s, %".formatted();
    }
}
