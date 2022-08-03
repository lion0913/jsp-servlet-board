package com.ll.exam.controller.article;

import com.ll.exam.dto.ArticleDetailDto;
import com.ll.exam.dto.ArticleDto;
import com.ll.exam.model.Article;
import com.ll.exam.util.Rq;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleList = articleService.findAll();

        rq.setAttr("articleList", articleList);

        rq.view("/article/list");
    }

    public void showWriteArticle(Rq rq) {
        rq.view("/article/write");
    }

    public void writeArticle(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        System.out.println("title: "+title+"\n body: "+body);
        Article article = new Article();
        article.setBody(body);
        article.setTitle(title);
        article.setCreatedDate(LocalDateTime.now());
        article.setModifiedDate(LocalDateTime.now());
        article.setBoardId(1);

        long result = articleService.write(article);
        System.out.println(result);
        if(result <= 0) {
            rq.appendBody("글 등록에 실패했습니다.");
            return;
        }
        rq.replace("/usr/article/list/free", "게시물이 정상적으로 등록되었습니다.");
    }

    public void deleteArticle(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        Article article = articleService.findById(id);

        if (article == null) {
            rq.appendBody("해당 글이 존재하지 않습니다.");
            return;
        }

        long result = articleService.deleteById(id);

        if(result != 1) {
            rq.appendBody("글 삭제에 실패했습니다.");
            return;
        }
        rq.appendBody("<div>%d번 게시물이 삭제되었습니다.</div>".formatted(id));
        rq.appendBody("<div><a href=\"/usr/article/list/free\">리스트로 이동</a></div>");
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }
        Article article = articleService.findById(id);
        ArticleDetailDto articleDetailDto = new ArticleDetailDto(article.getTitle(), article.getBody());

        rq.setAttr("article", articleDetailDto);
        rq.view("/article/detail");

    }

    public void showModifyArticle(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }
        Article article = articleService.findById(id);
        ArticleDetailDto articleDetailDto = new ArticleDetailDto(article.getTitle(), article.getBody());

        rq.setAttr("article", articleDetailDto);
        rq.view("/article/modify");
    }

    public void doModifyArticle(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        if (id == 0) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }
        Article article = articleService.findById(id);
        if(article == null) {
            rq.appendBody("존재하지 않는 게시글입니다.");
        }

        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        article.setTitle(title);
        article.setBody(body);
        article.setModifiedDate(LocalDateTime.now());

        articleService.saveOrUpdate(article);

        rq.replace("/usr/article/list/free", "%d번 게시물이 정상적으로 수정되었습니다.".formatted(id));
    }
}
