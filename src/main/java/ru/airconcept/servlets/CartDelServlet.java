package ru.airconcept.servlets;

import ru.airconcept.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class CartDelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartService cartService = (CartService) session.getAttribute ("cartService");
        String id = req.getParameter("id");
        if (cartService != null && id != null && !"".equals(id)) {
            cartService.remove(id);
        }
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
