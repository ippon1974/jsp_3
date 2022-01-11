package ru.airconcept.servlets;

import ru.airconcept.model.ModelCart;
import ru.airconcept.service.CartService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        session = req.getSession(true);
        CartService cartService = (CartService) session.getAttribute ("cartService");
        List<ModelCart> listCatr = cartService.list();
        if(cartService != null) {
            req.setAttribute ("listCatr", listCatr);
        }
        req.getRequestDispatcher ("/WEB-INF/view/cart.jsp").forward (req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        session = req.getSession(true);
        String name = (String)session.getAttribute ("modelNameSession");
        Integer number = (Integer)session.getAttribute ("numberSession");
        BigDecimal totalNDC = (BigDecimal)session.getAttribute ("totalSession");
        String img = (String)session.getAttribute ("transliterationsSession");
        String material = (String) session.getAttribute ("materialSession");
        int width = (int)session.getAttribute ("widthSession");
        int height = (int)session.getAttribute ("heightSession");
        int size = (int)session.getAttribute ("sizeSession");
        int typematerial = (int)session.getAttribute ("typematerialSession");

        CartService cartService = (CartService) session.getAttribute ("cartService");
        ModelCart modelCart = new ModelCart();
        modelCart.setId (UUID.randomUUID().toString());
        modelCart.setName(name);
        modelCart.setNumber(number);
        modelCart.setNamematerial(material);
        modelCart.setTypematerial(typematerial);
        modelCart.setWidth(width);
        modelCart.setHeight(height);
        modelCart.setSize(size);
        modelCart.setTotalNDC(totalNDC);
        modelCart.setImg(img);

        if (cartService == null) {
            cartService = new CartService();
            session.setAttribute("cartService", cartService);
        }
        cartService.add(modelCart);

        List<ModelCart> listCatr = cartService.list();
        req.setAttribute ("listCatr", listCatr);

        req.setAttribute ("modelNameSession", session.getAttribute ("modelNameSession"));
        req.setAttribute ("materialSession", session.getAttribute ("materialSession"));
        req.setAttribute ("sizeSession", session.getAttribute ("sizeSession"));
        req.setAttribute ("widthSession", session.getAttribute ("widthSession"));
        req.setAttribute ("heightSession", session.getAttribute ("heightSession"));

//        req.getRequestDispatcher ("/WEB-INF/view/cart.jsp").forward (req, resp);
//        resp.sendRedirect(req.getContextPath() + "/cart");
        String path = String.format ("/catalog/grills?template=%s&materialid=%d&size=%d&width=%d&height=%d", img,typematerial, size, width, height);
          resp.sendRedirect(req.getContextPath() + path);
    }
}
