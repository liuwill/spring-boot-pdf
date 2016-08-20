package com.liuwill.text.test;

import com.liuwill.text.PdfApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@SpringBootTest(classes = PdfApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerIntegTest {

    @LocalServerPort
    private int port;

    private URL base;
    private URL downloadUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        this.downloadUrl = new URL("http://localhost:" + port + "/download");
        //template = new TestRestTemplate();
    }

    @Test
    public void getIndex() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(), startsWith("<!doctype html>"));
        //assertThat(response.getBody(),containsString(""));
    }

    @Test
    public void getDownload() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(downloadUrl.toString(), String.class);
        assertThat(response.getStatusCodeValue(), equalTo(200));
        assertThat(response.getHeaders().getContentType().toString(), equalTo("application/pdf"));
    }
}
