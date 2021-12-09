package ru.airconcept.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete_cookies")
public class DeleteCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteCookiesServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie aCookie : cookies) {
                aCookie.setMaxAge(0);
                resp.addCookie(aCookie);
            }

            writer.println("All cookies have been deleted!");
        } else {
            writer.println("No cookies found");
        }
    }
}
