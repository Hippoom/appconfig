package com.github.hippoom.appconfig.sampleapp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AServiceTest {
    private AService subject = new AService();

    private ConfigurationFacade config = new ConfigurationFacade();

    @Before
    public void injects() {
        subject.setConfig(config);
    }

    @Test
    public void should_return_true_given_configured_enabled() {
        assertThat(subject.isEnabled(), is(true));
    }

    @Test
    public void should_return_false_given_configured_disabled() {
        config.setAServiceEnabled(false);
        assertThat(subject.isEnabled(), is(false));
    }
}
