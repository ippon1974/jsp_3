package ru.airconcept.servlets;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.ModelCart;
import ru.airconcept.model.ModelGrill;
import ru.airconcept.model.ModelOrder;
import ru.airconcept.service.CartService;
import ru.airconcept.service.GrillService;
import ru.airconcept.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

//    private OrderService orderService;
    private static final Random r = new Random(); // <- shared resource

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        session = req.getSession(true);
        CartService cartService = (CartService) session.getAttribute ("cartService");
        List<ModelCart> cartList = cartService.list();

        OrderService orderService = new OrderService(ConnectionFactory.getInstance());
        List<ModelOrder> orderList = orderService.list();

        for (int i = 0; i < cartList.size(); i++) {
            ModelOrder modelOrder = new ModelOrder();
            modelOrder.setName (cartList.get(i).getName());
            modelOrder.setNamematerial (cartList.get (i).getNamematerial());
            modelOrder.setTypematerial (cartList.get (i).getTypematerial ());
            modelOrder.setNumber (cartList.get (i).getNumber());
            modelOrder.setSize (cartList.get (i).getSize ());
            modelOrder.setWidth (cartList.get (i).getWidth ());
            modelOrder.setHeight (cartList.get (i).getHeight ());
            modelOrder.setImg (cartList.get (i).getImg ());
            modelOrder.setTotalNDC (cartList.get (i).getTotalNDC());
            orderList.add (modelOrder);
        }

        req.setAttribute ("orderList", orderList);
        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String comment = req.getParameter("comment");
        OrderService orderService = new OrderService(ConnectionFactory.getInstance());

        int lastInsertId = orderService.saveCustomer(name, phone, email, comment);
        System.out.println(lastInsertId);

        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }
}

