package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;
import org.web.memberDTO.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberView implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("member view command requested");

        String userId = req.getParameter("userId");
        MemberDAO dao = MemberDAO.getInstance();
        MemberDTO member = dao.memberView(userId);

        String url = "";

        if (member != null) {
            req.setAttribute("member", member);
            url = "/profile.do";
        } else {
            System.out.println("something went wrong");
            url = "/profile.do";
        }
        req.setAttribute("url", url);
    }
}
