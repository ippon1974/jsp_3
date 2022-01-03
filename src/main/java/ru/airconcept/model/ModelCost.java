package ru.airconcept.model;

import java.math.BigDecimal;

public class ModelCost {
    private int cid;
    private BigDecimal cost; //стоимость материала на складе
    private BigDecimal costmcut; //стоимость раскроя одного погонного метра

    public ModelCost(int cid, BigDecimal cost, BigDecimal costmcut) {
        this.cid = cid;
        this.cost = cost;
        this.costmcut = costmcut;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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
