package com.ll.exam.controller.board;

import com.ll.exam.dao.BoardDao;
import com.ll.exam.dto.BoardDto;
import com.ll.exam.util.Rq;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

public class BoardController {
    public void showList(Rq rq) throws ServletException, IOException {
        BoardDao dao = new BoardDao();

        List<BoardDto> boardList = dao.getBoards();

        rq.getReq().setAttribute("boardList", boardList);

        System.out.println("list success!");
        RequestDispatcher rd = rq.getReq().getRequestDispatcher("/board/list.jsp");
        rd.forward(rq.getReq(), rq.getResp());
    }
}
