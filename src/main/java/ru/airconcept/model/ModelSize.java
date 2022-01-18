package ru.airconcept.model;

public class ModelSize {
    private int sid;
    private int size;
    private int mid;

    public ModelSize(int sid, int size, int mid) {
        this.sid = sid;
        this.size = size;
        this.mid = mid;
    }

    public int getSid() {
        return sid;
    }

    public int getSize() {
        return size;
    }

    public int getMid() {
        return mid;
    }
}
