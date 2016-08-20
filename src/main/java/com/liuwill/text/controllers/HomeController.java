package com.liuwill.text.controllers;

import com.liuwill.text.api.GlobalConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @RequestMapping(value = "")
    public String index(ModelMap globalModel){
        globalModel.put("mobile", GlobalConfig.readProperty("form.mobile"));
        globalModel.put("email", GlobalConfig.readProperty("form.email"));
        globalModel.put("name", GlobalConfig.readProperty("form.name"));
        globalModel.put("mode", "html");
        return "simpleForm";
    }

    /**
     * Handle request to download a PDF document
     */
    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public ModelAndView downloadSample() {
        Map<String,Object> globalModel = new HashMap<>();
        globalModel.put("status",true);
        globalModel.put("code", "data");
        globalModel.put("message", "data");

        return new ModelAndView("simplePDF", globalModel);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView downloadForm() {
        Map<String,Object> globalModel = new HashMap<>();
        globalModel.put("mobile", GlobalConfig.readProperty("form.mobile"));
        globalModel.put("email", GlobalConfig.readProperty("form.email"));
        globalModel.put("name", GlobalConfig.readProperty("form.name"));
        globalModel.put("mode", "pdf");

        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("simpleFormPDF", globalModel);
    }
}
