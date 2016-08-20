package com.liuwill.text.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liuwill.text.view.AsianFontProvider;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.charset.Charset;

/**
 * 生成PDF文件
 * Created by Administrator on 2016/8/19 0019.
 */
public class PdfFileUtils {
    public static void savePdf(OutputStream out, String html) {
        Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        //Document document = new Document(PageSize.A4, 110, 110, 120, 140);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void saveChinesePdf(OutputStream out, String html) {
        Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        //Document document = new Document(PageSize.A4, 110, 110, 120, 140);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes()), Charset.forName("UTF-8"), new AsianFontProvider() );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
