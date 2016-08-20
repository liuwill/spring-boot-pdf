package com.liuwill.text.test;

import com.liuwill.text.controllers.DataController;
import com.liuwill.text.controllers.HomeController;
import com.liuwill.text.services.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DataController.class)
public class DataControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DataService dataService;

    @Test
    public void sayHello() throws Exception {
        given(this.dataService.sayHello("boot"))
                .willReturn("hello world");

        this.mvc.perform( get("/data/hello/boot")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("hello world")))
            .andExpect(jsonPath("$.code").value("boot"));
    }
}
