package ru.airconcept.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        String name = "time_28";
        String value = String.valueOf(System.currentTimeMillis());
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(5);
        resp.addCookie(cookie);

        session = req.getSession(true);
        session.setAttribute("Name",username);
        session.setAttribute("Password",password);

        req.setAttribute("Name", session.getAttribute("Name"));
        req.setAttribute("Password", session.getAttribute("Password"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
        requestDispatcher.forward(req, resp);

    }
}
