package com.github.hippoom.appconfig.sampleapp.rest;

import com.github.hippoom.appconfig.sampleapp.config.ConfigurationFacade;
import com.github.hippoom.appconfig.sampleapp.service.FooService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/foo-servlet.xml", "classpath:root.xml"})
public class FooResourceTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Autowired
    private ConfigurationFacade config;

    @Autowired
    private FooService fooService;

    @Before
    public void injects() {
        mvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void should_return_service_descriptor() throws Exception {
        mvc.perform(get("/foo/someFoo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("env", config.getEnvironment()))
                .andExpect(header().string("enabled", String.valueOf(fooService.isEnabled())));
    }
}
