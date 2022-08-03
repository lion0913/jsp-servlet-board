package com.ll.exam.controller.article;

import com.ll.exam.dto.ArticleDto;
import com.ll.exam.model.Article;
import com.ll.exam.util.DBConnection;
import com.ll.exam.util.SecSql;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
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

    public void saveOrUpdate(Article article) {
        SecSql sql = dbConnection.genSecSql();

        String query = "UPDATE article SET ";

        if(article.getTitle() != null) {
            query += " title = \"%s\",".formatted(article.getTitle());
        }

        if(article.getBody() != null) {
            query += " body = \"%s\",".formatted(article.getBody());
        }

        if(article.getModifiedDate() != null) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateToStr = dateFormat.format(article.getModifiedDate());

            query += " modifiedDate = \"%s\",".formatted(dateToStr);
        }

        query = query.substring(0, query.length()-1);
        sql.append(query);
        sql.append(" WHERE article.id = %d;".formatted(article.getId()));

        sql.update();
    }

    public long write(Article article) {
        SecSql sql = dbConnection.genSecSql();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdDate = dateFormat.format(article.getCreatedDate());
        String modifiedDate = dateFormat.format(article.getModifiedDate());
        sql
                .append("INSERT INTO article")
                .append("SET createdDate = ?", createdDate)
                .append(", modifiedDate = ?", modifiedDate)
                .append(", title = ?", article.getTitle())
                .append(", body = ?", article.getBody())
                .append(", boardId = %d".formatted(article.getBoardId()));

        return sql.insert();
    }
}
