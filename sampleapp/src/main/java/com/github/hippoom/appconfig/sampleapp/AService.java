package com.github.hippoom.appconfig.sampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AService {
    @Autowired
    private ConfigurationFacade config;

    public boolean isEnabled() {
        return config.isAServiceEnabled();
    }

    public void setConfig(ConfigurationFacade config) {
        this.config = config;
    }
}
