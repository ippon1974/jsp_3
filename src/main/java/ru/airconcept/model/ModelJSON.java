package ru.airconcept.model;

import java.math.BigDecimal;
import java.util.Date;

public class ModelJSON {
    private String id;
    private String name;
    private String steel;
    private String steel_round;
    private String meter;
    private String meter_words;
    private String rub_words;
    private String rub_ndc_words;
    private String cost_for_meter;
    private String cost_for_meter_with_ndc;
    private String cost_for_all_meter;
    private String cost_for_all_meter_with_ndc;
    private String cost_for_all_in_words;
    private String cost_for_all_with_ndc_in_words;
    private String ndc;
    private String description;
    private String dt_request;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getSteel_round() {
        return steel_round;
    }

    public void setSteel_round(String steel_round) {
        this.steel_round = steel_round;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
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

    public String getCost_for_meter() {
        return cost_for_meter;
    }

    public void setCost_for_meter(String cost_for_meter) {
        this.cost_for_meter = cost_for_meter;
    }

    public String getCost_for_meter_with_ndc() {
        return cost_for_meter_with_ndc;
    }

    public void setCost_for_meter_with_ndc(String cost_for_meter_with_ndc) {
        this.cost_for_meter_with_ndc = cost_for_meter_with_ndc;
    }

    public String getCost_for_all_meter() {
        return cost_for_all_meter;
    }

    public void setCost_for_all_meter(String cost_for_all_meter) {
        this.cost_for_all_meter = cost_for_all_meter;
    }

    public String getCost_for_all_meter_with_ndc() {
        return cost_for_all_meter_with_ndc;
    }

    public void setCost_for_all_meter_with_ndc(String cost_for_all_meter_with_ndc) {
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

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDt_request() {
        return dt_request;
    }

    public void setDt_request(String dt_request) {
        this.dt_request = dt_request;
    }

    @Override
    public String toString() {
        return "ModelJSON{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", steel='" + steel + '\'' +
                ", steel_round='" + steel_round + '\'' +
                ", meter='" + meter + '\'' +
                ", meter_words='" + meter_words + '\'' +
                ", rub_words='" + rub_words + '\'' +
                ", rub_ndc_words='" + rub_ndc_words + '\'' +
                ", cost_for_meter='" + cost_for_meter + '\'' +
                ", cost_for_meter_with_ndc='" + cost_for_meter_with_ndc + '\'' +
                ", cost_for_all_meter='" + cost_for_all_meter + '\'' +
                ", cost_for_all_meter_with_ndc='" + cost_for_all_meter_with_ndc + '\'' +
                ", cost_for_all_in_words='" + cost_for_all_in_words + '\'' +
                ", cost_for_all_with_ndc_in_words='" + cost_for_all_with_ndc_in_words + '\'' +
                ", ndc='" + ndc + '\'' +
                ", description='" + description + '\'' +
                ", dt_request='" + dt_request + '\'' +
                '}';
    }


}
