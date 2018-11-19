package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;
import org.web.boardDTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardList implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("boardlist command");

        BoardDAO dao = BoardDAO.getInstance();
        ArrayList<BoardDTO> lists = dao.list();

        req.setAttribute("lists", lists);
        req.setAttribute("url", "boardList.jsp");
    }
}
