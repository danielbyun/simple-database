package org.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        // retrieving the url
        String path = req.getContextPath();
        String URI = req.getRequestURI();

        // substringing to cut out everything before /
        String basicURL = URI.substring(path.length());

        String url = "";

        // redirect links
        switch (basicURL) {
            case "/join.do":
                url = "/join.jsp";

                break;
            case "/login.do":
                url = "/login.jsp";

                break;
            case "/profile.do":
                url = "/profile.jsp";

                break;
            case "/updateProfile.do":
                url = "/updateProfile.jsp";

                break;
            case "/deleteProfile.do":
                url = "/deleteProfile.jsp";

                break;
            case "/profileDeleted.do":
                url = "/profileDeleted.jsp";

                break;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
