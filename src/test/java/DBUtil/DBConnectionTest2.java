package DBUtil;


import com.ll.exam.controller.article.ArticleService;
import com.ll.exam.dto.ArticleDto;
import com.ll.exam.model.Article;
import com.ll.exam.util.DBConnection;
import com.ll.exam.util.SecSql;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class DBConnectionTest2 {
    private DBConnection dbConnection;

    @BeforeAll
    public void beforeAll() {
        dbConnection = new DBConnection();
        dbConnection.setDevMode(true);
    }

    @Test
    public void selectArticles() {
        SecSql sql = dbConnection.genSecSql();
        sql
                .append("SELECT * FROM article ORDER BY id;");
        List<Article> articleDtoList = sql.selectRows(Article.class);

        IntStream.range(0, articleDtoList.size()).forEach(i -> {
            long id = i + 1;

            Article articleDto = articleDtoList.get(i);

            System.out.println(articleDto.toString());
        });
    }

    @Test
    public void articleDtoTest() {
        SecSql sql = dbConnection.genSecSql();
        sql
                .append("select a.id, b.name, a.createdDate, a.title, a.body from article a inner join board b on a.boardId=b.id order by b.name, a.id asc;");
        List<ArticleDto> articleDtoList = sql.selectRows(ArticleDto.class);

        IntStream.range(0, articleDtoList.size()).forEach(i -> {
            long id = i + 1;

            ArticleDto articleDto = articleDtoList.get(i);

            System.out.println(articleDto.toString());
        });
    }

    @Test
    public void updateAppendTest() {
        ArticleService articleService = new ArticleService();

        Article article = articleService.findById(2);

        System.out.println(article.toString());

        article.setTitle("내용변경");
        article.setBody("내용변경테스트");
        article.setModifiedDate(LocalDateTime.now());

        String query = "UPDATE article SET ";
        SecSql sql = dbConnection.genSecSql();

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

        long affectedRowsCount = sql.update();

        assertThat(affectedRowsCount).isEqualTo(1);
    }

    @Test
    public void insertTest() {
        Article article = new Article();
        article.setBody("test");
        article.setTitle("test title");
        article.setCreatedDate(LocalDateTime.now());
        article.setModifiedDate(LocalDateTime.now());
        article.setBoardId(1);

        ArticleService articleService = new ArticleService();
        articleService.write(article);

    }
}
