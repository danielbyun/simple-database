package org.web.memberCommand;

import org.web.memberDAO.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IdCheck implements MemberCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        MemberDAO dao = MemberDAO.getInstance();

        int result = dao.idCheck(userId);
        PrintWriter out = resp.getWriter();

        out.write(result + "");
        out.close();
    }
}
