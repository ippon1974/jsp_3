package ru.airconcept.service;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CollectionMethod {
    private String inputMaterial;
    private String inputMaterialID;
    private int idmaterial;
    private String name;
    private String meter;
    private int nummeter;
    private double ndc;
    BigDecimal itemCost = new BigDecimal(BigInteger.ZERO,  2);
    BigDecimal totalCost = new BigDecimal(BigInteger.ZERO,  2);
    BigDecimal totalNdc = new BigDecimal(BigInteger.ZERO,  2);
    BigDecimal totalNdcAllMeter = new BigDecimal(BigInteger.ZERO,  2);
    private String steelForm = null;
    private int steel;
    private int results;

    public String InputNameMater(){
        if(inputMaterial != null || inputMaterial == ""){
            String[] imputmaterial = inputMaterial.split (" | ");
            String part1 = imputmaterial[2];
            name = part1.replace ("Нержавеющая", "Нержавеющая сталь");
        }
        return name;
    }

    public int StrToInt(String inputMaterialID){
        this.inputMaterialID = inputMaterialID;
        if(this.inputMaterialID != null){
            String[] imput = inputMaterialID.split (" | ");
            String part1 = imput[0];
            idmaterial = Integer.parseInt(part1, 10);
        }
        return idmaterial;
    }


    public int StrToInt(){
        if(meter != null){
            nummeter = Integer.parseInt (meter, 10);
        }
        return nummeter;
    }

    public BigDecimal calculateCost(int itemQuantity, BigDecimal itemPrice)
    {
        BigDecimal itemCost = itemPrice.multiply(new BigDecimal(itemQuantity));
        return totalCost.add(itemCost);
    }

    public BigDecimal ndc(BigDecimal total){
        ndc = 1.2;
        BigDecimal ndcc = total.multiply(new BigDecimal(ndc));
        ndcc = ndcc.setScale(0, RoundingMode.HALF_EVEN);
        return totalNdc.add(ndcc);
    }

    public BigDecimal ndcAllmeter(int m, BigDecimal price){
        ndc = 1.2;
        BigDecimal allndc = price.multiply(new BigDecimal(m * ndc));
        allndc = allndc.setScale(0, RoundingMode.HALF_EVEN);
        return totalNdcAllMeter.add(allndc);
    }

    public int Round(String steelForm){
        if(steelForm != null){
            steel = Integer.parseInt (steelForm, 10);
            double num = steel;
            results = (int) num;
            if (num % 5 == 0) ;
            else if (num / 1 < 1.1)
                results = 5;
            else if (num / 2 < 2.1)
                results = 5;
            else if (num % 5 < 2.5)
                results = results - results % 5;
            else
                results = results + (5 - results % 5);
        }
        return results;
    }

    public int GetFormStell(String steelForm){
        if(steelForm != null)
            steel = Integer.parseInt (steelForm, 10);
        return steel;
    }

    public static String padezhMeter(String ed, String a, String b, String c, int n) {
        if (n < 0) {
            n = -n;
        }
        int last = n % 100;
        if (last > 10 && last < 21) {
            return ed + c;
        }
        last = n % 10;
        if (last == 0 || last > 4) {
            return ed + c;
        }
        if (last == 1) {
            return ed + a;
        }
        if (last < 5) {
            return ed + b;
        }
        return ed + c;
    }

    public static String padezhRub(String ed, String a, String b, String c, int n) {
        if (n < 0) {
            n = -n;
        }
        int last = n % 100;
        if (last > 10 && last < 21) {
            return ed + c;
        }
        last = n % 10;
        if (last == 0 || last > 4) {
            return ed + c;
        }
        if (last == 1) {
            return ed + a;
        }
        if (last < 5) {
            return ed + b;
        }
        return ed + c;
    }

    public String getServletContext(ServletContext req){
        ServletContext context = req;
        String appPath = context.getRealPath("");
        String rpath = "/fonts/arial.ttf";
        String path = appPath + rpath;
        String FONT = path;
        return FONT;
    }

    public Date convertToDate(String receivedDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(receivedDate);
        return date;
    }
}
