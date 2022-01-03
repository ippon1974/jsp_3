package ru.airconcept.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calc {

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
        area = w * h;
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
