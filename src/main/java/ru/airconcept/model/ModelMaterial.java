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

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
