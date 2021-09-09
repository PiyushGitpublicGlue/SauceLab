package com.selenium.pom.utils;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }

        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("urlBase");
        if (prop != null) return prop;
        else throw new RuntimeException("property base url not specified in config.properties file");
    }

    public String loginPageExpectedTitle() {
        String prop = properties.getProperty("loginPageExpectedTitle");
        if (prop != null) return prop;
        else throw new RuntimeException("property loginPageExpectedTitle not specified in config.properties file");
    }
    public String productPageExpectedTitle() {
        String prop = properties.getProperty("productPageExpectedTitle");
        if (prop != null) return prop;
        else throw new RuntimeException("property productPageExpectedTitle not specified in config.properties file");
    }
    public String checkOutPageExpectedTitle() {
        String prop = properties.getProperty("checkOutPageExpectedTitle");
        if (prop != null) return prop;
        else throw new RuntimeException("property checkOutPageExpectedTitle not specified in config.properties file");
    }
    public String checkOutPageOverviewExpectedTitle() {
        String prop = properties.getProperty("checkOutPageOverviewExpectedTitle");
        if (prop != null) return prop;
        else throw new RuntimeException("property checkOutPageOverviewExpectedTitle not specified in config.properties file");
    }
    public String successInformationExpectedTitle() {
        String prop = properties.getProperty("successInformationExpectedTitle");
        if (prop != null) return prop;
        else throw new RuntimeException("property successInformationExpectedTitle not specified in config.properties file");
    }
    public String errorMessageExpectedTitle() {
        String prop = properties.getProperty("errorMessageOnLoginPage");
        if (prop != null) return prop;
        else throw new RuntimeException("property errorMessageOnLoginPage not specified in config.properties file");
    }

}
