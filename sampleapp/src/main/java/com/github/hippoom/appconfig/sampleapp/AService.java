package com.github.hippoom.appconfig.sampleapp;

public class AService {
    private ConfigurationFacade config;

    public boolean isEnabled() {
        return config.isAServiceEnabled();
    }

    public void setConfig(ConfigurationFacade config) {
        this.config = config;
    }
}
