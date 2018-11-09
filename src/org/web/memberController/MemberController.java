package org.web.memberController;

import org.web.memberCommand.IdCheck;
import org.web.memberCommand.MemberCommand;
import org.web.memberCommand.MemberJoin;
import org.web.memberCommand.MemberLogin;

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
        MemberCommand action = null;

        if (basicURL.equals("/idCheck.mo")) {
            System.out.println("checking id (if it's taken or not)");
            action = new IdCheck();
            action.executeQueryCommand(req, resp);

            url = (String)req.getAttribute("url");
        }
        if (basicURL.equals("/join.mo")) {
            System.out.println("join requested");
            action = new MemberJoin();
            action.executeQueryCommand(req, resp);

            url = (String)req.getAttribute("url");
        }
        if (basicURL.equals("/login.mo")) {
            System.out.println("login requested");
            action = new MemberLogin();
            action.executeQueryCommand(req, resp);

            url = (String)req.getAttribute("url");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
