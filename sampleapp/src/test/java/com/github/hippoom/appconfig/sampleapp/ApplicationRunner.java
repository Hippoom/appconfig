package com.github.hippoom.appconfig.sampleapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root.xml")
public class ApplicationRunner {

    @Autowired
    private AService aService;

    @Test
    public void a_service_should_get_injected() {
        assertThat(aService.isEnabled(), is(true));
    }
}
