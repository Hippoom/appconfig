package com.github.hippoom.appconfig.sampleapp;

import org.springframework.stereotype.Component;

@Component
public class ConfigurationFacade {
    private boolean fooServiceEnabled = true;

    public boolean isFooServiceEnabled() {
        return fooServiceEnabled;
    }

    public void setFooServiceEnabled(boolean enabled) {
        this.fooServiceEnabled = enabled;
    }
}
