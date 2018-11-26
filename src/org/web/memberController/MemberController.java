package org.web.memberController;

import org.web.memberCommand.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.mo")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        moService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        moService(req, resp);
    }

    private void moService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        String path = req.getContextPath();
        String URI = req.getRequestURI();
        String basicURL = URI.substring(path.length());

        String url = "";
        MemberCommand action;
        RequestDispatcher requestDispatcher;

        switch (basicURL) {
            case "/idCheck.mo":
                action = new IdCheck();
                action.executeQueryCommand(req, resp);

                break;
            case "/join.mo":
                action = new MemberJoin();
                action.executeQueryCommand(req, resp);

                url = (String) req.getAttribute("url");
                requestDispatcher = req.getRequestDispatcher(url);
                requestDispatcher.forward(req, resp);

                break;
            case "/login.mo":
                action = new MemberLogin();
                action.executeQueryCommand(req, resp);

                break;
            case "/logout.mo":
                action = new MemberLogout();
                action.executeQueryCommand(req, resp);

                url = (String) req.getAttribute("url");
                requestDispatcher = req.getRequestDispatcher(url);
                requestDispatcher.forward(req, resp);

                break;
            case "/viewProfile.mo":
                action = new MemberView();
                action.executeQueryCommand(req, resp);

                url = (String) req.getAttribute("url");
                requestDispatcher = req.getRequestDispatcher(url);
                requestDispatcher.forward(req, resp);

                break;
            case "/updateProfile.mo":
                action = new MemberUpdate();
                action.executeQueryCommand(req, resp);

                url = (String) req.getAttribute("url");
                requestDispatcher = req.getRequestDispatcher(url);
                requestDispatcher.forward(req, resp);

                break;
            case "/deleteProfile.mo":
                action = new MemberDelete();
                action.executeQueryCommand(req, resp);

                url = (String) req.getAttribute("url");
                requestDispatcher = req.getRequestDispatcher(url);
                requestDispatcher.forward(req, resp);

                break;
        }
    }
}
