package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;
import org.web.boardDTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardView implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mId = (Integer.parseInt(req.getParameter("mId")));

        BoardDAO dao = BoardDAO.getInstance();
        BoardDTO dto = dao.boardView(mId);

        // get the arraylist of all posts
        ArrayList<BoardDTO> lists = dao.list();

        // send all posts to boardView page
        req.setAttribute("lists", lists);

        // send the specific post requested to view
        req.setAttribute("list", dto);

        // req.setAttribute("count", count);
        req.setAttribute("url", "/boardView.jsp");
    }
}