package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;
import org.web.boardDTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardList implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardDAO dao = BoardDAO.getInstance();
        ArrayList<BoardDTO> lists = dao.list();

//        int mGroup = Integer.parseInt(req.getParameter("mGroup"));
//        System.out.println(mGroup);

//        int count = dao.commentCount(mGroup);
//        System.out.println(lists.get(1).getmGroup());
//        System.out.println(lists.get(2).getmGroup());
//        System.out.println(lists.get(3).getmGroup());

        // find occurrences on each mGroup
        for (int i = 0; i < lists.size(); i++) {
            ArrayList<Integer> mGroupArray = new ArrayList<>();

            mGroupArray.add(lists.get(i).getmGroup());

//            System.out.print(mGroupArray);
        }

        req.setAttribute("lists", lists);
        req.setAttribute("url", "/boardList.jsp");
    }
}
