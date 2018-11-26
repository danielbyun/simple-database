package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberUpdate implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("memberId"));
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        String userEmail = req.getParameter("userEmail");

        MemberDAO dao = MemberDAO.getInstance();
        int result = dao.memberUpdate(id, userId, userPw, userEmail);
        String url = "";

        // try to update session as well
        if (result == 1) {
            HttpSession session = req.getSession(false);
            session.getAttribute("sessionId");

//            session.setAttribute("member", member);

            url = "/viewProfile.mo?memberId=" + id;
            req.setAttribute("url", url);
        }
    }
}
