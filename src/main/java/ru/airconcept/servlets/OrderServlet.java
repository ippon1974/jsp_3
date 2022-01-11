package ru.airconcept.servlets;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.ModelOrder;
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

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private ModelOrder modelOrder;
    private OrderService orderService;
    private Connection connection;
    private ConnectionFactory connectionFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        session = req.getSession(true);
//        orderService = (OrderService) session.getAttribute("orderService");
//        orderService.saveOrder("mudak");
//        String mudak = "mudak";
//        orderService = new OrderService(ConnectionFactory.getInstance());
//        orderService.saveOrder("osel");
//        String name = (String)session.getAttribute ("modelNameSession");
//        System.out.println("This is session order " + name);


        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        int ID = 0;
        if(id != null) {
            ID = Integer.parseInt(id);
        }

        String name = req.getParameter("name");

        orderService = new OrderService(ConnectionFactory.getInstance());
        orderService.saveOrder(name);

//        try
//        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url="jdbc:mysql://localhost:3306/test_airconcept";
//            String user="airconcept";
//            String password="k4b8c321974";
//            Connection con= DriverManager.getConnection(url, user, password);
//
//            String query="Insert into test_airconcept.order(name) values (?);";
//            PreparedStatement pstmt=con.prepareStatement(query);
////            pstmt.setInt(1, ID);
//            pstmt.setString(1, name);
//            pstmt.executeUpdate();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }

        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);

    }
}

