package com.ll.exam.controller.article;

import com.ll.exam.dto.ArticleDto;
import com.ll.exam.model.Article;
import com.ll.exam.util.DBConnection;
import com.ll.exam.util.SecSql;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {

    private DBConnection dbConnection;

    public ArticleRepository() {
        dbConnection = new DBConnection();
        dbConnection.setDevMode(true);
    }

    public List<ArticleDto> findAll() {
        SecSql sql = dbConnection.genSecSql();
        sql
                .append("select a.id, b.name, a.createdDate, a.title, a.body from article a inner join board b on a.boardId=b.id order by b.name, a.id asc;");
        List<ArticleDto> articleDtoList = sql.selectRows(ArticleDto.class);

        IntStream.range(0, articleDtoList.size()).forEach(i -> {
            ArticleDto articleDto = articleDtoList.get(i);
        });

        return articleDtoList;
    }

    public Article findById(long id) {
        SecSql sql = dbConnection.genSecSql();
        sql
                .append("SELECT * FROM article where id = %d;".formatted(id));
        Article article = sql.selectRow(Article.class);

        return article;
    }

    public long deleteById(long id) {
        SecSql sql = dbConnection.genSecSql();
        sql
                .append("DELETE FROM article where id = %d;".formatted(id));
        long affectedRowsCount = sql.delete();

        return affectedRowsCount;
    }
}
