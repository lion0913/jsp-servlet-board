package com.ll.exam;

import com.ll.exam.dao.BoardDao;
import com.ll.exam.dto.BoardDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 들어오는 파라미터를 UTF-8로 해석
//        req.setCharacterEncoding("UTF-8");
//        // 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
//        resp.setCharacterEncoding("UTF-8");
//
//        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
//        resp.setContentType("text/html; charset=utf-8");
//
//        resp.getWriter().append("안녕하세요!");
//    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BoardDao dao = new BoardDao();
//        List<BoardDto> boardList = dao.getBoards();
//        request.setAttribute("boardList", boardList);

        System.out.println("list success!");
        RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
        rd.forward(request, response);
    }
}
