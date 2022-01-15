package ru.airconcept.model;

import java.math.BigDecimal;
import java.util.Date;

public class ModelCustomerOrder {
    private int customerId;
    private String name;
    private String phone;
    private String email;
    private String comment;
    private String nameTemplate;
    private String nameMaterial;
    private int number;
    private int width;
    private int height;
    private BigDecimal totalNDC;
    private String img;
    private Date createdAt;

    public ModelCustomerOrder(int customerId, String name, String phone, String email, String comment, String nameTemplate, String nameMaterial, int number, int width, int height, BigDecimal totalNDC, String img, Date createdAt) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.comment = comment;
        this.nameTemplate = nameTemplate;
        this.nameMaterial = nameMaterial;
        this.number = number;
        this.width = width;
        this.height = height;
        this.totalNDC = totalNDC;
        this.img = img;
        this.createdAt = createdAt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BigDecimal getTotalNDC() {
        return totalNDC;
    }

    public void setTotalNDC(BigDecimal totalNDC) {
        this.totalNDC = totalNDC;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
