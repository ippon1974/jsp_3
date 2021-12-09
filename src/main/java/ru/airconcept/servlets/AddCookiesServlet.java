package ru.airconcept.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_cookies")
public class AddCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int cookieCount;

    public AddCookiesServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "Cookie" + (++cookieCount);
        String value = String.valueOf(System.currentTimeMillis());
        Cookie cookie = new Cookie(name, value);
        resp.addCookie(cookie);
        resp.getWriter().println("A cookie has been created successfully!");
    }
}
