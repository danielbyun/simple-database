package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardDelete implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mId = req.getParameter("mId");

        BoardDAO dao = BoardDAO.getInstance();
        int result = dao.boardDelete(mId);
        PrintWriter out = resp.getWriter();

        if (result == 1) {
            out.write("1");
        } else {
            out.write("0");
        }

        out.close();
    }
}
