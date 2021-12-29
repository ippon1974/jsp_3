package ru.airconcept.model;

public class ModelGrill {
    private int gid;
    private String gname;
    private String gtransliterations;
    //private int type; // 1-rectangle 2-square 3-circle
    //private int width; // mm
    //private int height; // mm
    //private int thickness; // mm


    public ModelGrill(int gid, String gname, String gtransliterations) {
        this.gid = gid;
        this.gname = gname;
        this.gtransliterations = gtransliterations;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGtransliterations() {
        return gtransliterations;
    }

    public void setGtransliterations(String gtransliterations) {
        this.gtransliterations = gtransliterations;
    }
}
