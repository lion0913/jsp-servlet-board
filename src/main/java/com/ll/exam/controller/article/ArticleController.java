package com.ll.exam.controller.article;

import com.ll.exam.dao.ArticleDao;
import com.ll.exam.dto.ArticleDto;
import com.ll.exam.dto.ArticleWriteDto;
import com.ll.exam.util.Rq;
import com.ll.exam.dao.BoardDao;
import com.ll.exam.dto.BoardDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq) throws ServletException, IOException {
        ArticleDao dao = new ArticleDao();

        List<ArticleDto> boardList = dao.getBoards();

        rq.getReq().setAttribute("articleList", boardList);

        System.out.println("list success!");
        RequestDispatcher rd = rq.getReq().getRequestDispatcher("/article/list.jsp");
        rd.forward(rq.getReq(), rq.getResp());
    }

    public void showWriteArticle(Rq rq) {
        rq.view("/article/write");
    }
}
