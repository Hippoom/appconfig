package com.github.hippoom.appconfig.sampleapp.config;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.equalTo;

public class ConfigurationFacadeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void should_throw_exception_when_validate_given_incompatible_config_version() {
        thrown.expect(IncompatibleConfigurationVersionException.class);
        thrown.expectMessage(equalTo("Incompatible configuration version detected, expect <2> but got <1>."));

        new ConfigurationFacade("2", "1");
    }

    @Test
    public void should_pass_when_validate_given_compatible_config_version() {

        new ConfigurationFacade("2", "2");
    }
}