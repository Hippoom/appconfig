package com.github.hippoom.appconfig.sampleapp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FooServiceTest {
    private FooService subject = new FooService();

    private ConfigurationFacade config = new ConfigurationFacade(2, 2);

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
        config.setFooServiceEnabled(false);
        assertThat(subject.isEnabled(), is(false));
    }
}
