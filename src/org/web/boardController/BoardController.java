package org.web.boardController;

import org.web.boardCommand.BoardCommand;
import org.web.boardCommand.BoardList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.bo")
public class BoardController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        String path = req.getContextPath();
        String uri = req.getRequestURI();
        String basicurl = uri.substring(path.length());

        String url = "";
        BoardCommand action = null;

        if (basicurl.equals("/boardList.bo")) {
            System.out.println("board list");
            action = new BoardList();
            action.executeQueryCommand(req, resp);
            url = (String) req.getAttribute("url");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
