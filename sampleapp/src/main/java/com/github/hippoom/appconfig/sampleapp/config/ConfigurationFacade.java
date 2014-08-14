package com.github.hippoom.appconfig.sampleapp.config;


import com.jcabi.manifests.Manifests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import static java.lang.String.format;

public class ConfigurationFacade {
    private final Logger logger = LoggerFactory.getLogger(ConfigurationFacade.class);

    private final String expectedVersion;

    private final String actualVersion;
    private String environment = "dev";
    private boolean fooServiceEnabled = true;
    private String anotherServiceUrl = "http://bar.com/api";

    public ConfigurationFacade(String expectedVersion, String actualVersion) {
        this.expectedVersion = expectedVersion;
        this.actualVersion = actualVersion;
        validateVersion(this.expectedVersion, this.actualVersion);
    }

    public ConfigurationFacade(String actualVersion) {
        this(Manifests.read("ExpectedConfigVersion"), actualVersion);
    }

    public boolean isFooServiceEnabled() {
        return fooServiceEnabled;
    }

    public void setFooServiceEnabled(boolean enabled) {
        this.fooServiceEnabled = enabled;
    }

    private void validateVersion(String expectedVersion, String actualVersion) {
        if (!expectedVersion.equals(actualVersion)) {
            throw new IncompatibleConfigurationVersionException(
                    format("Incompatible configuration version detected, expect <%s> but got <%s>.",
                            expectedVersion, actualVersion));
        }
    }

    @PostConstruct
    public void printVersionAndEnvironment() {
        logger.info(format(
                "[Application Configuration Management] config version & environment:%s,%s", this.actualVersion, this.environment));
        logger.info(format("[Application Configuration Management] fooServiceEnabled:%b", this.fooServiceEnabled));
        logger.info(format("[Application Configuration Management] anotherServiceUrl:%s", this.anotherServiceUrl));
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getAnotherServiceUrl() {
        return anotherServiceUrl;
    }

    public void setAnotherServiceUrl(String anotherServiceUrl) {
        this.anotherServiceUrl = anotherServiceUrl;
    }
}
