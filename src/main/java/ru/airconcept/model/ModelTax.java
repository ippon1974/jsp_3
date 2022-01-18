package ru.airconcept.model;

public class ModelTax {
    private int taxid;
    private int taxndc;
    private int taxio;
    private int coeffcut;
    private int coeffmat;

    public ModelTax(int taxid, int taxndc, int taxio, int coeffcut, int coeffmat) {
        this.taxid = taxid;
        this.taxndc = taxndc;
        this.taxio = taxio;
        this.coeffcut = coeffcut;
        this.coeffmat = coeffmat;
    }

    public int getTaxid() {
        return taxid;
    }

    public int getTaxndc() {
        return taxndc;
    }

    public int getTaxio() {
        return taxio;
    }

    public int getCoeffcut() {
        return coeffcut;
    }

    public int getCoeffmat() {
        return coeffmat;
    }
}
