package com.dextwelwe.carcomparaison.service;
import java.lang.reflect.Field;
public class Outils {
    public boolean anyFieldIsNull(Object obj) {
        if (obj == null) {
            return true;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.get(obj) == null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
