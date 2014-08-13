package com.github.hippoom.appconfig.sampleapp.service;

import com.github.hippoom.appconfig.sampleapp.config.ConfigurationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FooService {
    private final Logger logger = LoggerFactory.getLogger(FooService.class);

    @Autowired
    private ConfigurationFacade config;


    @PostConstruct
    public void printConfig() {
        logger.info("========================>FooService enabled:" + isEnabled());
    }

    public boolean isEnabled() {
        return config.isFooServiceEnabled();
    }

    public void setConfig(ConfigurationFacade config) {
        this.config = config;
    }

    public String anotherServiceUrl() {
        return config.getAnotherServiceUrl();
    }
}
