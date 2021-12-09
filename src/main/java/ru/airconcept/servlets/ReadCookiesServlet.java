package ru.airconcept.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/read_cookies")
public class ReadCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadCookiesServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            writer.println("No cookies found");
        } else {
            writer.println("Number of cookies: " + cookies.length);

            for (Cookie aCookie : cookies) {
                String name = aCookie.getName();
                String value = aCookie.getValue();
                writer.println(name + " = " + value);
            }
        }


    }
}
