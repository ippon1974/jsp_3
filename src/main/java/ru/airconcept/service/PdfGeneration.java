package ru.airconcept.service;

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import  com.itextpdf.text.pdf.*;
import  com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.apache.commons.lang3.RandomStringUtils;

public class PdfGeneration {

    public static final String FONT = "src/main/webapp/fonts/arial.ttf";


    public static void main(String[] args) {


//        File file22 = new File("src/main/webapp/WEB-INF/pdf/wcut_total.pdf");
//        System.out.println (file22.length() + " " + file22.getName() + " " + file22.getPath());

        String ext = "pdf";
        File dir = new File("src/main/webapp/WEB-INF/pdf/");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(25), ext);
        File fi = new File(dir, name);
        System.out.println(fi.getName());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
        String strDate = formatter.format(date);
        System.out.println(strDate);
        String namefile = name;
        String address = "140080 ул. Карла Маркса д. 117, офис № 503 Люберецкий р-н, пос. Красково, Московская область. Территория института «ВНИИСТРОМ». Тел. + 7 (925) 585-33-71 (Мегафон). Почта: box@wcut.ru Интернет: www.wcut.ru";

        try {
            OutputStream file = new FileOutputStream(new File("src/main/webapp/WEB-INF/pdf/" + namefile));
            Document document = new Document();
            LineSeparator ls = new LineSeparator();
            PdfWriter.getInstance(document, file);

            BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontbold = new Font(bf,22,Font.BOLD);
            Font fontsmall = new Font(bf,10,Font.NORMAL);
            Font fontH1 = new Font(bf,14,Font.NORMAL);
            Font font = new Font(bf,10,Font.NORMAL);

            document.open();
            document.add(new Paragraph("Civek Water Jet", fontbold));
            document.add(new Paragraph("Гидроабразивная резка материалов", fontsmall));
            document.add( Chunk.NEWLINE );
            document.add(new Paragraph(address, fontsmall));
            document.add(new Chunk(ls));
            document.add(new Paragraph("Расчет стоимости раскроя материала. Гидроабразив.", fontH1));
            document.add(new Chunk(ls));
            document.add( Chunk.NEWLINE );
            document.add(new Paragraph(address, fontsmall));
            document.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
