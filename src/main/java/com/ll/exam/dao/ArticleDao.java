package com.ll.exam.dao;

import com.ll.exam.dto.ArticleDto;
import com.ll.exam.dto.BoardDto;
import com.ll.exam.model.Article;
import com.ll.exam.type.board.BoardType;
import com.ll.exam.util.DBConnectUtil;
import com.ll.exam.util.DBConnection;
import com.ll.exam.util.SecSql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleDao {
//    private Connection conn;
    private DBConnection dbConnection;

    public ArticleDao() throws IOException {
//        DBConnectUtil dbConnectUtil = new DBConnectUtil();
//        conn = dbConnectUtil.connect();
        dbConnection = new DBConnection();
        dbConnection.setDevMode(true);

    }

    public List<ArticleDto> getBoards() {
        SecSql sql = dbConnection.genSecSql();
        sql
                .append("select a.id, b.name, a.createdDate, a.title, a.body from article a inner join board b on a.boardId=b.id order by b.name, a.id asc;");
        List<ArticleDto> articleDtoList = sql.selectRows(ArticleDto.class);

        IntStream.range(0, articleDtoList.size()).forEach(i -> {
//            long id = i + 1;

            ArticleDto articleDto = articleDtoList.get(i);
//
//            System.out.println(articleDto.toString());
        });

//        List<ArticleDto> list = new ArrayList<>();
//
//        String sql = "select a.id, a.createDate, a.title, a.body, b.name from article a inner join board b on a.boardId = b.id order by b.name, a.createDate;";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            try (ResultSet rs = ps.executeQuery()) {
//
//                while (rs.next()) {
//                    int id = rs.getInt(1);
//                    String createDate = rs.getString(2);
//                    String title= rs.getString(3);
//                    String body= rs.getString(4);
//                    String name = rs.getString(5);
//
//
//                    ArticleDto board = new ArticleDto(id, createDate, title, body, name);
//                    list.add(board);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return articleDtoList;
        return articleDtoList;
    }

    public void writeArticle(String title, String body) {
        if(title == null) return;

        SecSql sql = dbConnection.genSecSql();
        sql
                .append("INSERT INTO article")
                .append("SET createdDate = NOW()")
                .append(", modifiedDate = NOW()")
                .append(", title = ?", "제목 new")
                .append(", body = ?", "내용 new");

        long newId = sql.insert();
    }
}
