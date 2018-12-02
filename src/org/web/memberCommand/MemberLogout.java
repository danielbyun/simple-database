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
        HttpSession session = req.getSession();
        String url;

        if (session != null) {
            // terminate session
            session.invalidate();

            url = "/boardList.do";
        } else {
            url = "/logout.mo";
        }

        req.setAttribute("url", url);
    }
}
