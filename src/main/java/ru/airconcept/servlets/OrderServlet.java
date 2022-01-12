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

    private OrderService orderService;
    private static final Random r = new Random(); // <- shared resource

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        session = req.getSession(true);
        CartService cartService = (CartService) session.getAttribute ("cartService");

        List<ModelCart> cartList = cartService.list();
        orderService = new OrderService(ConnectionFactory.getInstance());

        List<ModelOrder> modelOrderList = orderService.list();
        ModelOrder modelOrder = new ModelOrder();

        for (int i = 0; i < cartList.size(); i++) {
            modelOrder.setName(cartList.get(i).getName());
        }


        for (int i = 0; i < modelOrderList.size(); i++) {
            System.out.println(modelOrderList.get(i).getName());
        }


        req.setAttribute ("modelOrderList", modelOrderList);






//        String nameTemplate = (String)session.getAttribute ("modelNameSession");
//        req.setAttribute("nameTemplate", nameTemplate);
//
//        String materialName = (String)session.getAttribute ("materialSession");
//        req.setAttribute("materialName", materialName);
//
//        int materialSize = (int)session.getAttribute ("sizeSession");
//        req.setAttribute("materialSize", materialSize);
//
//        int materialWidth = (int)session.getAttribute ("widthSession");
//        req.setAttribute("materialWidth", materialWidth);
//
//        int materialHeight= (int)session.getAttribute ("heightSession");
//        req.setAttribute("materialHeight", materialHeight);
//
//        int number = (int) session.getAttribute("numberSession");
//        req.setAttribute("number", number);
//
//        System.out.println("This is session order " + nameTemplate);

        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");

        orderService = new OrderService(ConnectionFactory.getInstance());
        orderService.saveOrder(name);


        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }
}

