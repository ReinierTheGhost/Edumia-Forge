package com.legends.edumia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EdumiaLog {
    private static Logger LOGGER = LogManager.getLogger();
    public EdumiaLog(){

    }
    public static void error(String s){
        LOGGER.error(Edumia.MOD_ID + ": " + s);
    }
    public static void error(String s, Object... params){
        LOGGER.error(String.format(Edumia.MOD_ID + ": " + s, params));
    }
}
