package org.web.boardCommand;

import org.web.boardDAO.BoardDAO;
import org.web.boardDTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BoardList implements BoardCommand {
    @Override
    public void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardDAO dao = BoardDAO.getInstance();

        // all lists put into an ArrayList
        ArrayList<BoardDTO> lists = dao.list();

        // find occurrences on each mGroup
//        for (int i = 0; i < lists.size(); i++) {
//            ArrayList<Integer> mGroupArray = new ArrayList<>();
//
//            mGroupArray.add(lists.get(i).getmGroup());
//        }

        // find occurrence of same mId posts
//        System.out.println(Collections.frequency(lists, mId));

        req.setAttribute("lists", lists);
        req.setAttribute("url", "/boardList.jsp");
    }
}
