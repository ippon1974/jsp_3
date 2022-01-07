package ru.airconcept.servlets;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.model.*;
import ru.airconcept.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet( "/catalog/grills")
public class GrillsServlet extends HttpServlet {

    private ModelGrill modelGrill;
    private GrillService grillService;

    private ModelCost modelCost;
    private CostService costService;

    private ModelCalc modelCalc;
    private CalcService calcService;

    private ModelTax tax;
    private TaxService taxService;

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
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dt = myDateObj.format(myFormatObj);
        System.out.println (dt);

        String template = req.getParameter("template"); // параметр из строки запроса который переделан модулем rewrate
        HttpSession session = req.getSession();
        CartService cartService = (CartService) session.getAttribute ("cartService");
        req.setAttribute ("cartService", cartService);

        grillService = new GrillService(ConnectionFactory.getInstance());
        List<ModelGrill> listGrills = grillService.getAll();
        req.setAttribute ("listGrills", listGrills);

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
        int widthID = 0;
        if(width != null){
            widthID = Integer.parseInt(width);
        }
        req.setAttribute ("width", width);

        String height = req.getParameter ("height");
        int heightID = 0;
        if(height != null){
            heightID = Integer.parseInt (height);
        }
        req.setAttribute ("height", height);


        List<ModelMaterial> modelMaterial = grillService.getListMaterial();
        req.setAttribute ("modelMaterial", modelMaterial);

        List<ModelSize> modelSize = grillService.getListSize();
        req.setAttribute ("modelSize", modelSize);

        modelGrill = grillService.getByTransliterations(template);

        req.setAttribute ("transliterations", modelGrill.getGtransliterations());
        req.setAttribute("template", modelGrill.getGname());
        req.setAttribute("templateuri", modelGrill.getGtransliterations());
        req.setAttribute("id", modelGrill.getGid());

        calcService = new CalcService (ConnectionFactory.getInstance());
        if(material != null || size !=null) {
            modelCalc = calcService.getCostMatStore (materialID, sizeID);
            req.setAttribute ("modelCalc", modelCalc);
            System.out.println (modelCalc.getCostmcut() + " " + modelCalc.getMname () + " " + modelCalc.getCost() + " " + modelCalc.getSize());
        }

        taxService = new TaxService(ConnectionFactory.getInstance());
        if(width != null || height != null){
            // Коэффициент длина из фррмы делим на 120
            double aspect = calcService.getAspect(widthID, heightID, modelGrill.getGw());
            req.setAttribute ("aspect", aspect);

            // Получаем площадь
            double area = calcService.getArea (widthID, heightID);
            req.setAttribute("area", area);

            // Получаем полную длину раскроя в погонных метрах
            int allcutlength = calcService.getCutLength (modelGrill.getGbord(), modelGrill.getGlenin(), aspect);
            req.setAttribute("allcutlength", allcutlength);

            // Общая стоимость материала без раскроя
            BigDecimal costmatnotcut = calcService.getCostMatNotCut(modelCalc.getCost(), area);
            req.setAttribute ("costmatnotcut", costmatnotcut);

            // Общая стоимость раскря без материала
            BigDecimal costcutnotmat = calcService.getCostCutNotMat(modelCalc.getCostmcut(), allcutlength / 1000);
            req.setAttribute ("costcutnotmat", costcutnotmat);

            // Общая таблица налогов и надбавок
            tax = taxService.getByTaxID(1);
            BigDecimal percent = new BigDecimal (100);
            BigDecimal taxNdc = new BigDecimal(tax.getTaxndc());
            BigDecimal taxIo = new BigDecimal(tax.getTaxio());
            BigDecimal taxMat = new BigDecimal(tax.getCoeffmat());
            BigDecimal taxCut = new BigDecimal(tax.getCoeffcut());
            BigDecimal addTaxMat = costmatnotcut.multiply(taxMat).divide(percent);
            BigDecimal addTaxCut = costcutnotmat.multiply(taxCut).divide (percent);
            BigDecimal total = costmatnotcut.add(costcutnotmat).add (addTaxMat).add(addTaxCut);
            BigDecimal addNdc = total.multiply(taxNdc).divide(percent);
            BigDecimal totalNdc = total.add (addNdc);
            req.setAttribute ("addTaxMat", addTaxMat);
            req.setAttribute ("addTaxCut", addTaxCut);
            req.setAttribute ("total", total);
            req.setAttribute ("totalNdc", totalNdc);

            session.setAttribute("modelNameSession", modelGrill.getGname());
            session.setAttribute("materialSession", modelCalc.getMname());
            session.setAttribute("sizeSession", modelCalc.getSize());
            session.setAttribute("widthSession", width);
            session.setAttribute("heightSession", height);
            session.setAttribute("totalSession",totalNdc);
            session.setAttribute("dtSession",dt);
            
        }
        req.getRequestDispatcher ("/WEB-INF/view/result1.jsp").forward (req, resp);
    }

}
