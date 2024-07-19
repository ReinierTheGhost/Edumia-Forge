package com.legends.edumia.utils;

import com.legends.edumia.EdumiaLog;

import java.lang.reflect.Field;

public class EdumiaUtil {

    public static void unlockFinalField(Field f){
        try {
            f.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(f, (f.getModifiers() & -3 & -5 | 1) & -17);
        } catch (SecurityException | IllegalAccessException | NoSuchFieldException var2){
            EdumiaLog.error("Error unlocking final field " + f.toString());
            var2.printStackTrace();
        }

    }
}
