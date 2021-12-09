package ru.airconcept.servlets;

import ru.airconcept.dao.UserDAO;
import ru.airconcept.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println (session.getId());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO userDao = new UserDAO();

        try {
            User user = userDao.checkLogin(email, password);
            String destPage = "/WEB-INF/view/login.jsp";

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                destPage = "/WEB-INF/view/home.jsp";
            } else {
                String message = "Invalid email/password";
                req.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
            dispatcher.forward(req, resp);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
