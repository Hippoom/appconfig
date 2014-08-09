package com.github.hippoom.appconfig.sampleapp;

import com.github.hippoom.appconfig.sampleapp.config.ConfigurationFacade;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config.xml")
public class FooAcceptanceTest {
    @Autowired
    private ConfigurationFacade config;

    @Test
    public void should_return_service_descriptor() throws Exception {
        HttpResponse response = Request.Get("http://localhost:9998/sampleapp/rest/foo/abc")
                .execute().returnResponse();

        assertThat(response.getFirstHeader("env").getValue(),
                equalTo(config.getEnvironment()));
        assertThat(response.getFirstHeader("enabled").getValue(),
                equalTo(String.valueOf(config.isFooServiceEnabled())));
    }
}
