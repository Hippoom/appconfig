package com.github.hippoom.appconfig.sampleapp;

import org.springframework.stereotype.Component;

@Component
public class ConfigurationFacade {
    private boolean aServiceEnabled = true;

    public boolean isAServiceEnabled() {
        return aServiceEnabled;
    }

    public void setAServiceEnabled(boolean enabled) {
        this.aServiceEnabled = enabled;
    }
}
