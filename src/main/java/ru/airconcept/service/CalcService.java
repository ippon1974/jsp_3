package ru.airconcept.service;

import ru.airconcept.dao.ConnectionFactory;
import ru.airconcept.dao.DaoException;
import ru.airconcept.model.ModelCalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CalcService {
    public static final String SELECT_COST_MAT_STORE = "select cmaterial.mname, csize.size, ccost.cost, ccost.costmcut from cmaterial join  csize on cmaterial.mid = csize.mid join ccost on csize.sid = ccost.sid where cmaterial.mid = ? and csize.size = ?";

    public static final String COLUMM_MATERIAL_NAME = "mname";
    public static final String COLUMM_SIZE = "size";
    public static final String COLUMM_COST_STORE = "cost";
    public static final String COLUMM_COST_M_CUT = "costmcut";

    private ConnectionFactory connectionFactory = null;
    public CalcService(ConnectionFactory connectionFactory){this.connectionFactory = connectionFactory; }

    public ModelCalc getCostMatStore(int material, int size) {
        if(material == 0 || size == 0)throw new IllegalArgumentException ( );
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COST_MAT_STORE);) {
            statement.setInt (1, material);
            statement.setInt (2, size);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new ModelCalc (resultSet.getString(COLUMM_MATERIAL_NAME),
                            resultSet.getInt(COLUMM_SIZE),
                            resultSet.getBigDecimal(COLUMM_COST_STORE),
                            resultSet.getBigDecimal(COLUMM_COST_M_CUT)
                    );
                }
            }
        } catch (Exception e) {
            throw new DaoException (String.format("Method getCostMatStore(name: '%d') has thrown an exception.", material), e);
        }
        return null;
    }

    // Метод вычисляет коэффициент отношения сторон объекта Длина пользователя / длину в безе 120 mm
    public double getAspect(int w, int h, int minWidth){
        int temp = 0;
        double aspect;
        if(w < h){
            temp = h;
            h = w;
            w = temp;
        }
        aspect = (double) w / minWidth;
        return  aspect;
    }

    // Метод вычисляет площадь геометрической фигуры
    public double getArea(double w, double h){
        double area;
        area = (w / 1000) * (h / 1000);
        return  area;
    }

    // Метод вычисляет общую длину реза в погонных метрах
    public int getCutLength(int border, int inside, double aspect){
        int total = (int)(border * aspect) + (int)(inside * aspect);
        return total;
    }

    // Метод вычисляет стоимость материала без раскроя
    public BigDecimal getCostMatNotCut(BigDecimal costMatnotCut, double area) {
        BigDecimal a = new BigDecimal(area);
        BigDecimal costMatNotCut = costMatnotCut.multiply(a).setScale(0, RoundingMode.DOWN);
        return costMatNotCut;
    }

    //Метод вычисляет стоимость раскроя без материала
    public BigDecimal getCostCutNotMat(BigDecimal costformeter, int cutmeter){
        BigDecimal meter = new BigDecimal(cutmeter);
        BigDecimal cost = costformeter.multiply(meter).setScale(0, RoundingMode.DOWN);
        return  cost;
    }




}
