package com.github.hippoom.appconfig.sampleapp.rest;

import com.github.hippoom.appconfig.sampleapp.config.ConfigurationFacade;
import com.github.hippoom.appconfig.sampleapp.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FooResource {

    @Autowired
    private FooService fooService;

    @Autowired
    private ConfigurationFacade config;


    @RequestMapping(value = "/foo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String showServiceDescriptor(@PathVariable("id") String id, HttpServletResponse response) {
        response.setHeader("env", config.getEnvironment());
        response.setHeader("enabled", String.valueOf(fooService.isEnabled()));
        return id;
    }
}
