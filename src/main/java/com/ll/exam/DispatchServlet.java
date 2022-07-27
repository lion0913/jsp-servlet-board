package com.ll.exam;

import com.ll.exam.controller.article.ArticleController;
import com.ll.exam.controller.board.BoardController;
import com.ll.exam.controller.member.MemberController;
import com.ll.exam.util.Rq;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();
        BoardController boardController = new BoardController();

        switch (rq.getMethod()) {
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/article/list/free":
                        articleController.showList(rq);
                        break;
                    case "/usr/board/list/free":
                        boardController.showList(rq);
                        break;
                    case "/usr/article/write/free":
                        articleController.showWriteArticle(rq);
                        break;
                    case "/usr/article/delete/free":
                        articleController.deleteArticle(rq);
                        break;
                    case "/usr/member/login":
                        memberController.login(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getPath()) {
                    case "/usr/article/write/free":
                        articleController.writeArticle(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
