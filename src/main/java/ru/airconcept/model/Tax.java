package ru.airconcept.model;

public class Tax {
    private int taxid;
    private int taxndc;
    private int taxio;
    private int coeffcut;
    private int coeffmat;

    public Tax() {
    }

    public Tax(int taxid, int taxndc, int taxio, int coeffcut, int coeffmat) {
        this.taxid = taxid;
        this.taxndc = taxndc;
        this.taxio = taxio;
        this.coeffcut = coeffcut;
        this.coeffmat = coeffmat;
    }

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public int getTaxndc() {
        return taxndc;
    }

    public void setTaxndc(int taxndc) {
        this.taxndc = taxndc;
    }

    public int getTaxio() {
        return taxio;
    }

    public void setTaxio(int taxio) {
        this.taxio = taxio;
    }

    public int getCoeffcut() {
        return coeffcut;
    }

    public void setCoeffcut(int coeffcut) {
        this.coeffcut = coeffcut;
    }

    public int getCoeffmat() {
        return coeffmat;
    }

    public void setCoeffmat(int coeffmat) {
        this.coeffmat = coeffmat;
    }
}
