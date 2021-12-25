package ru.airconcept.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String name = "time_50000";
        String value = String.valueOf(System.currentTimeMillis());
//        Cookie cookie = new Cookie(name, value);
//        cookie.setMaxAge(60 * 60 * 24);
//        resp.addCookie(cookie);

        Cookie firstName = new Cookie("first_name", value);
        Cookie lastName = new Cookie("last_name", value);
        firstName.setMaxAge(60*60*24);
        lastName.setMaxAge(180);
//        firstName.setMaxAge(0);
//        lastName.setMaxAge(0);
        resp.addCookie(firstName);
        resp.addCookie(lastName);

        HttpSession session = req.getSession();

        req.setAttribute ("message", "This is simple servlet message");
        req.setAttribute("name", "Mudaki");

        String n = (String)session.getAttribute("username");
        req.setAttribute("n", n);

        session.setAttribute("osel", session.getId());
        System.out.println("my session" + " " + session.getAttribute("osel"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session;
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        session = req.getSession(true);
        session.setAttribute("Name",username);
        session.setAttribute("Password",password);

        req.setAttribute("Name", session.getAttribute("Name"));
        req.setAttribute("Password", session.getAttribute("Password"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
        requestDispatcher.forward(req, resp);

    }
}
