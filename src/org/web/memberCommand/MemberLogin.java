package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;
import org.web.memberDTO.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberLogin implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");

        MemberDAO dao = MemberDAO.getInstance();
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (session != null && !session.isNew()) {
            session.invalidate();
        }

        int result = dao.memberLogin(userId, userPw);
        MemberDTO member = dao.memberLoginAndRetrieveAll(userId, userPw);

        if (result == 1) {
            session = req.getSession(true);

            session.setAttribute("sessionId", member.getUserId());
            session.setAttribute("member", member);
            session.setMaxInactiveInterval(60 * 10);
        }

        out.write(result + "");
        out.close();
    }
}
