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
        MemberCommand action = null;

        if (basicURL.equals("/idCheck.mo")) {
            System.out.println("checking id (if it's taken or not)");
            action = new IdCheck();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        } else if (basicURL.equals("/join.mo")) {
            System.out.println("join requested");
            action = new MemberJoin();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        } else if (basicURL.equals("/login.mo")) {
            System.out.println("login requested");
            action = new MemberLogin();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        } else if (basicURL.equals("/logout.mo")) {
            System.out.println("logout requested");
            action = new MemberLogout();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        } else if (basicURL.equals("/viewProfile.mo")) {
            System.out.println("listing members' credentials");
            action = new MemberView();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        } else if (basicURL.equals("/updateProfile.mo")) {
            System.out.println("update profile credentials");
            action = new MemberUpdate();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        } else if (basicURL.equals("/deleteProfile.mo")) {
            System.out.println("delete profile");
            action = new MemberDelete();
            action.executeQueryCommand(req, resp);

            url = (String) req.getAttribute("url");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
