package com.picsartacademy.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Config {

    public static void configure() {
        System.setProperty("log4j.configurationFile", "path/to/log4j2.xml");
    }

    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}
