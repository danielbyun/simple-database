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

        // basically the index page
        if (basicURL.equals("/join.do")) {
            System.out.println("redirecting user to signup page");
            url = "/join.jsp";
        } else if (basicURL.equals("/login.do")) {
            System.out.println("redirecting user to login page");
            url = "/login.jsp";
        } else if (basicURL.equals("/profile.do")) {
            System.out.println("redirecting user to view member's profile page");
            url = "/profile.jsp";
        } else if (basicURL.equals("/updateProfile.do")) {
            System.out.println("redirecting user to update page");
            url = "/updateProfile.jsp";
        } else if (basicURL.equals("/deleteProfile.do")) {
            System.out.println("delete profile");
            url = "/deleteProfile.jsp";
        } else if (basicURL.equals("/profileDeleted.do")) {
            System.out.println("profile deleted confirmation");
            url = "/profileDeleted.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
