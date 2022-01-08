package ru.airconcept.model;

import java.math.BigDecimal;

public class ModelCalc {
    private String mname;
    private int size;
    private BigDecimal cost; //стоимость материала на складе поставщика
    private BigDecimal costmcut; //стоимость раскроя материала за один погонный метр

    public ModelCalc(String mname, int size, BigDecimal cost, BigDecimal costmcut) {
        this.mname = mname;
        this.size = size;
        this.cost = cost;
        this.costmcut = costmcut;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCostmcut() {
        return costmcut;
    }

    public void setCostmcut(BigDecimal costmcut) {
        this.costmcut = costmcut;
    }
}
