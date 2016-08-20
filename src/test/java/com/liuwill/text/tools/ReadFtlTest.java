package com.liuwill.text.tools;

import com.liuwill.text.config.ConfigReader;
import com.liuwill.text.utils.FreemarkerUtils;
import com.liuwill.text.utils.PdfFileUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReadFtlTest {
    @Test
    public void fileTest(){
        String htmlContent = loadHtmlContent();

        File pdfFile =new File(ConfigReader.readProperty("path.save.file"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pdfFile);
            //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            PdfFileUtils.savePdf(fileOutputStream, htmlContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } /*catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }

    private String loadHtmlContent() {
        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("pageTitle", "LiuWill");
        URL fileResource = ReadFtlTest.class.getResource(ConfigReader.readProperty("path.ftl.direction"));
        System.out.println(fileResource.getFile());
        return FreemarkerUtils.loadFtlHtml(new File(fileResource.getFile()), ConfigReader.readProperty("path.ftl.file"), dataMap);
    }

}
