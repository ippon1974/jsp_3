package ru.airconcept.servlets;

import ru.airconcept.model.ModelCart;
import ru.airconcept.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher ("/WEB-INF/view/cart.jsp").forward (req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        session = req.getSession(true);
        String name = (String)session.getAttribute ("modelNameSession");

        CartService cartService = (CartService) session.getAttribute ("cartService");
        ModelCart modelCart = new ModelCart();
        modelCart.setId (UUID.randomUUID().toString());
        modelCart.setName(name);

        if (cartService == null) {
            cartService = new CartService ();
            session.setAttribute("cartService", cartService);
        }

        cartService.add (modelCart);
        List<ModelCart> listCatr = cartService.list ();
        req.setAttribute ("listCatr", listCatr);


        req.setAttribute ("modelNameSession", session.getAttribute ("modelNameSession"));
        req.setAttribute ("materialSession", session.getAttribute ("materialSession"));
        req.setAttribute ("sizeSession", session.getAttribute ("sizeSession"));
        req.setAttribute ("sizeSession", session.getAttribute ("sizeSession"));
        req.setAttribute ("widthSession", session.getAttribute ("widthSession"));
        req.setAttribute ("heightSession", session.getAttribute ("heightSession"));

        req.getRequestDispatcher ("/WEB-INF/view/cart.jsp").forward (req, resp);
    }
}
