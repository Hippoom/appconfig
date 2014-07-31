package com.github.hippoom.appconfig.sampleapp;

public class ConfigurationFacade {
    private boolean aServiceEnabled = true;

    public void setAServiceEnabled(boolean enabled) {
        this.aServiceEnabled = enabled;
    }

    public boolean isAServiceEnabled() {
        return aServiceEnabled;
    }
}
