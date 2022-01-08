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
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet("/update")
public class CartUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartService cartService = (CartService) session.getAttribute ("cartService");

        String id = req.getParameter("idnumber");
        String[] number= req.getParameterValues("number");
        int[] array = Arrays.asList(number).stream().mapToInt(Integer::parseInt).toArray();

        List<ModelCart> list = cartService.list();
        for (int i = 0; i < list.size(); i++) {
            for(int j = 0; j < array.length; j++ ){
                list.get(j).setNumber (array[j]);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
