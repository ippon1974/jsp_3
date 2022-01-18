package ru.airconcept.model;

public class ModelMaterial {
    private int mid;
    private int mtype;
    private String mname;

    public ModelMaterial(int mid, int mtype, String mname) {
        this.mid = mid;
        this.mtype = mtype;
        this.mname = mname;
    }

    public int getMid() {
        return mid;
    }

    public int getMtype() {
        return mtype;
    }

    public String getMname() {
        return mname;
    }
}
