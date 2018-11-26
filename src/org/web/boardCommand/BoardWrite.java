package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardWrite implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardDAO dao = BoardDAO.getInstance();

        int result = dao.write(userId, title, content);
        PrintWriter out = resp.getWriter();

        out.write(result + "");
        out.close();
    }
}
