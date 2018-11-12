package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberDelete implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("member delete requested");

        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");

        MemberDAO dao = MemberDAO.getInstance();
        int result = dao.memberDelete(userId, userPw);

        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        String url = "";

        if (result == 1) {
            session.invalidate();
            System.out.println("deleted successfully");
        } else {
            System.out.println("something went wrong");
        }
        out.write(result + "");
        out.close();
    }
}
