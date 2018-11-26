package org.web.boardController;

import org.web.boardCommand.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
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
        BoardCommand action;

        switch (basicurl) {
            case "/boardList.bo":
                action = new BoardList();
                action.executeQueryCommand(req, resp);
                url = (String) req.getAttribute("url");

                break;
            case "/boardUpdate.bo":
                action = new BoardUpdate();
                action.executeQueryCommand(req, resp);

                break;
            case "/boardWrite.bo":
                action = new BoardWrite();
                action.executeQueryCommand(req, resp);

                break;
            case "/boardView.bo":
                action = new BoardView();
                action.executeQueryCommand(req, resp);

                break;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
