package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;
import org.web.boardDTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardView implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mId = (Integer.parseInt(req.getParameter("mId")));
//        int mGroup = (Integer.parseInt(req.getParameter("mGroup")));

        BoardDAO dao = BoardDAO.getInstance();
        BoardDTO dto = dao.boardView(mId);
//        int count = dao.boardReplyCount(mGroup);
//        System.out.println(count);
        
        req.setAttribute("list", dto);
//        req.setAttribute("count", count);
        req.setAttribute("url", "/boardView.jsp");
    }
}
