package org.web.memberCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberLogout implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("logging the user out");

        HttpSession session = req.getSession();
        String url = "";

        if (session != null) {
            // terminate session
            session.invalidate();
            System.out.println("successfully logged out");

            url = "/boardList.do";
        } else {
            System.out.println("failed to log out");

            url = "/logout.mo";
        }

        req.setAttribute("url", url);
    }
}