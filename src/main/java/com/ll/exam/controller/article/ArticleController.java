package com.ll.exam.controller.article;

import com.ll.exam.dao.ArticleDao;
import com.ll.exam.dto.ArticleDto;
import com.ll.exam.dto.ArticleWriteDto;
import com.ll.exam.model.Article;
import com.ll.exam.util.Rq;
import com.ll.exam.dao.BoardDao;
import com.ll.exam.dto.BoardDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleList = articleService.findAll();

        rq.getReq().setAttribute("articleList", articleList);

        rq.view("/article/list");
    }

    public void showWriteArticle(Rq rq) {
        rq.view("/article/write");
    }

    public void writeArticle(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        System.out.println("title: "+title+"\n body: "+body);

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
}
