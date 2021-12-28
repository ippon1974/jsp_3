package ru.airconcept.servlets;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.ModelGrill;
import ru.airconcept.service.GrillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

@WebServlet( "/catalog/grills")
public class GrillsServlet extends HttpServlet {

    private ModelGrill nameGrill;
    private GrillService grillService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String action = req.getParameter("action");

        if(req.getQueryString()==null){
            doGet_Def(req, resp);
        }else {
            doGet_Demo1(req, resp);
        }
    }

    protected void doGet_Def(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        grillService = new GrillService(ConnectionFactory.getInstance());
        List<ModelGrill> listGrills = grillService.getAll();

        req.setAttribute ("listGrills", listGrills);
        req.getRequestDispatcher("/WEB-INF/view/grills.jsp").forward(req, resp);
    }

    protected void doGet_Demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println(name);

        grillService = new GrillService(ConnectionFactory.getInstance());
        nameGrill = grillService.getByName(name);

        req.setAttribute("name", nameGrill.getGname());
        req.setAttribute("id", nameGrill.getGid());
        req.getRequestDispatcher("/WEB-INF/view/result1.jsp").forward(req, resp);
    }

    protected void doGet_Demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet_Demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
