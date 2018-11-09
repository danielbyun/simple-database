package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberJoin implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("join command");

        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        String userEmail = req.getParameter("userEmail");

        MemberDAO dao = MemberDAO.getInstance();

        int result = dao.memberJoin(userId, userPw, userEmail);
        String url = "";

        if (result == 1) {
            System.out.println("registration successful, redirect user to login page");

            url = "/login.jsp";
        } else {
            System.out.println("registration failed, back to signup page");
            url = "/join.jsp";
        }

        // redirecting user
        req.setAttribute("url", url);
    }
}
