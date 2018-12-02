package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardCommentCount implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] mGroupArr = req.getParameterValues("mGroupArr");
        System.out.println(mGroupArr);

//        BoardDAO dao = BoardDAO.getInstance();
//
//        int mGroup = 3;
//        int commentCount = dao.commentCount(mGroup);
    }
}
