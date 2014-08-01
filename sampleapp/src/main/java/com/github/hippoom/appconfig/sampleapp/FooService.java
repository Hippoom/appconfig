package com.github.hippoom.appconfig.sampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService {
    @Autowired
    private ConfigurationFacade config;

    public boolean isEnabled() {
        return config.isFooServiceEnabled();
    }

    public void setConfig(ConfigurationFacade config) {
        this.config = config;
    }
}
