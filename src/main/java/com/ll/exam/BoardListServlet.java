package com.ll.exam;


import com.ll.exam.dao.BoardDao;
import com.ll.exam.dto.BoardDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class BoardListServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardDao dao = new BoardDao();
        List<BoardDto> boardList = dao.getBoards();
        request.setAttribute("boardList", boardList);

        System.out.println("list success!");
        RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
        rd.forward(request, response);
    }
}
