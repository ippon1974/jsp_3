package ru.airconcept.model;

public class ModelGrill {
    private int gid;
    private String gname;
    private int type; // 1-rectangle 2-square 3-circle
    private int width; // mm
    private int height; // mm
    private int thickness; // mm

    public ModelGrill(int gid, String gname) {
        this.gid = gid;
        this.gname = gname;
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
}
