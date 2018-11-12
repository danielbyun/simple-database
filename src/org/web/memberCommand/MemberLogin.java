package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberLogin implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("logging the user in");

        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");

        MemberDAO dao = MemberDAO.getInstance();
        int result = dao.memberLogin(userId, userPw);

        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        if (result == 1) {
            System.out.println("logging in successful, redirect user to content page");
            session.setAttribute("sessionId", userId);
            session.setMaxInactiveInterval(60 * 10);

        } else {
            System.out.println("logging in failed");
        }

        out.write(result + "");
        out.close();
    }
}
