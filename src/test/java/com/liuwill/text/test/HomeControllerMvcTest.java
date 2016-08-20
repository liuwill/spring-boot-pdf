package com.liuwill.text.test;

import com.liuwill.text.PdfApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@WebMvcTest(HomeController.class)
@SpringBootTest(classes = PdfApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerMvcTest {

    @Autowired
    private WebApplicationContext wac;

    //@Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void index() throws Exception {
        this.mvc.perform(get("/")
                .accept(MediaType.TEXT_HTML))
            .andExpect(status().isOk())
            .andExpect(view().name("simpleForm"))
            .andExpect(model().attributeExists("mode"))
            .andDo(print());
    }
}
