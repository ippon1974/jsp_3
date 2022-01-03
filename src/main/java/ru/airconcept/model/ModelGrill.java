package ru.airconcept.model;

import java.util.Date;

public class ModelGrill {
    private int gid;
    private int gtype; // 0-Прямоугольник 1-Квадрат 2-Круг
    private String gname; // Название шаблона
    private String gtransliterations; //Название шаблона на английском маленькие буквы без пробелов
    private int gw; // Ширина шаблона 120 мм
    private int gh; // Высота шаблона 60 мм
    private int gbord; // Длина рамки шаблона в погонных метрах
    private int glenin; // Длина внутреннего узора без рамки в погонных метрах
    private int glenall; // Полная длина в погонных метрах всего шаблона
    private String gpathimg; // Путь к изображению шаблона
    private String gdesc; // Описание шаблона
    private String gkeyw; // Ключевые слова
    private Date gdt; // datatime
    private boolean gispubl; // true - публиковать false-нет

    public ModelGrill(int gid, int gtype, String gname, String gtransliterations, int gw, int gh, int gbord, int glenin, int glenall, String gpathimg, String gdesc, String gkeyw, Date gdt, boolean gispubl) {
        this.gid = gid;
        this.gtype = gtype;
        this.gname = gname;
        this.gtransliterations = gtransliterations;
        this.gw = gw;
        this.gh = gh;
        this.gbord = gbord;
        this.glenin = glenin;
        this.glenall = glenall;
        this.gpathimg = gpathimg;
        this.gdesc = gdesc;
        this.gkeyw = gkeyw;
        this.gdt = gdt;
        this.gispubl = gispubl;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getGtype() {
        return gtype;
    }

    public void setGtype(int gtype) {
        this.gtype = gtype;
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

    public int getGw() {
        return gw;
    }

    public void setGw(int gw) {
        this.gw = gw;
    }

    public int getGh() {
        return gh;
    }

    public void setGh(int gh) {
        this.gh = gh;
    }

    public int getGbord() {
        return gbord;
    }

    public void setGbord(int gbord) {
        this.gbord = gbord;
    }

    public int getGlenin() {
        return glenin;
    }

    public void setGlenin(int glenin) {
        this.glenin = glenin;
    }

    public int getGlenall() {
        return glenall;
    }

    public void setGlenall(int glenall) {
        this.glenall = glenall;
    }

    public String getGpathimg() {
        return gpathimg;
    }

    public void setGpathimg(String gpathimg) {
        this.gpathimg = gpathimg;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public String getGkeyw() {
        return gkeyw;
    }

    public void setGkeyw(String gkeyw) {
        this.gkeyw = gkeyw;
    }

    public Date getGdt() {
        return gdt;
    }

    public void setGdt(Date gdt) {
        this.gdt = gdt;
    }

    public boolean isGispubl() {
        return gispubl;
    }

    public void setGispubl(boolean gispubl) {
        this.gispubl = gispubl;
    }
}
