package DBUtil;


import com.ll.exam.dto.ArticleDto;
import com.ll.exam.model.Article;
import com.ll.exam.util.DBConnection;
import com.ll.exam.util.SecSql;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
}
