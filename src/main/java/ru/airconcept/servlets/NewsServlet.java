package ru.airconcept.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        String rq = req.getQueryString();
        String uri = req.getRequestURI();
        String serv = req.getPathInfo();

        System.out.println("Query string " + rq);
        System.out.println("Uri string " + uri);
        System.out.println ("Path Servlet " + serv);

        req.setAttribute ("id", id);
        req.setAttribute ("newstxt", "HI");
//        resp.sendError(HttpServletResponse.SC_NOT_FOUND, req.getRequestURI());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/news.jsp");
        requestDispatcher.forward(req, resp);
    }
}
