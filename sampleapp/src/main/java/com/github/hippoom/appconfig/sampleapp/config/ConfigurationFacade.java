package com.github.hippoom.appconfig.sampleapp.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import static java.lang.String.format;

public class ConfigurationFacade {
    private final Logger logger = LoggerFactory.getLogger(ConfigurationFacade.class);

    private final int expectedVersion;

    private final int actualVersion;
    private String environment = "dev";
    private boolean fooServiceEnabled = true;

    public ConfigurationFacade(int expectedVersion, int actualVersion) {
        this.expectedVersion = expectedVersion;
        this.actualVersion = actualVersion;
        validateVersion(this.expectedVersion, this.actualVersion);
    }

    public boolean isFooServiceEnabled() {
        return fooServiceEnabled;
    }

    public void setFooServiceEnabled(boolean enabled) {
        this.fooServiceEnabled = enabled;
    }

    private void validateVersion(int expectedVersion, int actualVersion) {
        if (expectedVersion != actualVersion) {
            throw new IncompatibleConfigurationVersionException(
                    format("Incompatible configuration version detected, expect <%d> but got <%d>.",
                            expectedVersion, actualVersion));
        }
    }

    @PostConstruct
    public void printVersionAndEnvironment() {
        logger.info(format(
                "================>config version & environment:%d,%s", this.actualVersion, this.environment));
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
