package ru.airconcept.model;

import java.math.BigDecimal;
import java.util.Date;
import ru.airconcept.service.JDBCTablePrice;

public class ModelGeneral {
    private long id;
    private String name;
    private int steel;
    private int steel_round;
    private int meter;
    private String meter_words;
    private String rub_words;
    private String rub_ndc_words;
    private BigDecimal cost_for_meter;
    private BigDecimal cost_for_meter_with_ndc;
    private BigDecimal cost_for_all_meter;
    private BigDecimal cost_for_all_meter_with_ndc;
    private String cost_for_all_in_words;
    private String cost_for_all_with_ndc_in_words;
    private BigDecimal ndc = new BigDecimal (20);
    private String description;
    private Date dt_request;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSteel() {
        return steel;
    }

    public void setSteel(int steel) {
        this.steel = steel;
    }

    public int getSteel_round() {
        return steel_round;
    }

    public void setSteel_round(int steel_round) {
        this.steel_round = steel_round;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public String getMeter_words() {
        return meter_words;
    }

    public void setMeter_words(String meter_words) {
        this.meter_words = meter_words;
    }

    public String getRub_words() {
        return rub_words;
    }

    public void setRub_words(String rub_words) {
        this.rub_words = rub_words;
    }

    public String getRub_ndc_words() {
        return rub_ndc_words;
    }

    public void setRub_ndc_words(String rub_ndc_words) {
        this.rub_ndc_words = rub_ndc_words;
    }

    public BigDecimal getCost_for_meter() {
        return cost_for_meter;
    }

    public void setCost_for_meter(BigDecimal cost_for_meter) {
        this.cost_for_meter = cost_for_meter;
    }

    public BigDecimal getCost_for_meter_with_ndc() {
        return cost_for_meter_with_ndc;
    }

    public void setCost_for_meter_with_ndc(BigDecimal cost_for_meter_with_ndc) {
        this.cost_for_meter_with_ndc = cost_for_meter_with_ndc;
    }

    public BigDecimal getCost_for_all_meter() {
        return cost_for_all_meter;
    }

    public void setCost_for_all_meter(BigDecimal cost_for_all_meter) {
        this.cost_for_all_meter = cost_for_all_meter;
    }

    public BigDecimal getCost_for_all_meter_with_ndc() {
        return cost_for_all_meter_with_ndc;
    }

    public void setCost_for_all_meter_with_ndc(BigDecimal cost_for_all_meter_with_ndc) {
        this.cost_for_all_meter_with_ndc = cost_for_all_meter_with_ndc;
    }

    public String getCost_for_all_in_words() {
        return cost_for_all_in_words;
    }

    public void setCost_for_all_in_words(String cost_for_all_in_words) {
        this.cost_for_all_in_words = cost_for_all_in_words;
    }

    public String getCost_for_all_with_ndc_in_words() {
        return cost_for_all_with_ndc_in_words;
    }

    public void setCost_for_all_with_ndc_in_words(String cost_for_all_with_ndc_in_words) {
        this.cost_for_all_with_ndc_in_words = cost_for_all_with_ndc_in_words;
    }

    public BigDecimal getNdc() {
        return ndc;
    }

    public void setNdc(BigDecimal ndc) {
        this.ndc = ndc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDt_request() {
        return dt_request;
    }

    public void setDt_request(Date dt_request) {
        this.dt_request = dt_request;
    }

    @Override
    public String toString() {
        return "ModelGeneral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", steel=" + steel +
                ", steel_round=" + steel_round +
                ", meter=" + meter +
                ", meter_words='" + meter_words + '\'' +
                ", rub_words='" + rub_words + '\'' +
                ", rub_ndc_words='" + rub_ndc_words + '\'' +
                ", cost_for_meter=" + cost_for_meter +
                ", cost_for_meter_with_ndc=" + cost_for_meter_with_ndc +
                ", cost_for_all_meter=" + cost_for_all_meter +
                ", cost_for_all_meter_with_ndc=" + cost_for_all_meter_with_ndc +
                ", cost_for_all_in_words='" + cost_for_all_in_words + '\'' +
                ", cost_for_all_with_ndc_in_words='" + cost_for_all_with_ndc_in_words + '\'' +
                ", ndc=" + ndc +
                ", description='" + description + '\'' +
                ", dt_request=" + dt_request +
                '}';
    }
}


