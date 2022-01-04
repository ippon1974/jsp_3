package ru.airconcept.servlets;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.*;
import ru.airconcept.service.CalcService;
import ru.airconcept.service.CostService;
import ru.airconcept.service.GrillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/catalog/grills")
public class GrillsServlet extends HttpServlet {

    private ModelGrill modelGrill;
    private GrillService grillService;

    private ModelCost modelCost;
    private CostService costService;

    private ModelCalc modelCalc;
    private CalcService calcService;

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

        String template = req.getParameter("template"); // параметр из строки запроса который переделан модулем rewrate

        String material = req.getParameter("materialid");
        int materialID = 0;
        if(material != null) {
            materialID = Integer.parseInt (material);
        }
        req.setAttribute ("material", material);

        String size = req.getParameter("size");
        int sizeID = 0;
        if(size != null) {
            sizeID = Integer.parseInt (size);
        }
        req.setAttribute("size", size);

        String width = req.getParameter("width");
        req.setAttribute ("width", width);
        String height = req.getParameter ("height");
        req.setAttribute ("height", height);

        grillService = new GrillService(ConnectionFactory.getInstance());

        List<ModelMaterial> modelMaterial = grillService.getListMaterial();
        req.setAttribute ("modelMaterial", modelMaterial);

        List<ModelSize> modelSize = grillService.getListSize();
        req.setAttribute ("modelSize", modelSize);

        modelGrill = grillService.getByTransliterations(template);

        req.setAttribute ("transliterations", modelGrill.getGtransliterations());
        req.setAttribute("template", modelGrill.getGname());
        req.setAttribute("id", modelGrill.getGid());

        calcService = new CalcService (ConnectionFactory.getInstance());
        if(material != null || size !=null) {
            modelCalc = calcService.getCostMatStore (materialID, sizeID);
            req.setAttribute ("modelCalc", modelCalc);
            System.out.println (modelCalc.getCostmcut() + " " + modelCalc.getMname () + " " + modelCalc.getCost() + " " + modelCalc.getSize());
        }
        req.getRequestDispatcher ("/WEB-INF/view/result1.jsp").forward (req, resp);
    }

}
