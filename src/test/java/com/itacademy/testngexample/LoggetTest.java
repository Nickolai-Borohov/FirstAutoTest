package com.itacademy.testngexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggetTest {
   private static final Logger LOGGER= LogManager.getLogger(LoggetTest.class);
    @Test
    public void loggerTest(){
    LOGGER.info("Hello world");
        LOGGER.error("Hello world");
    }
}
