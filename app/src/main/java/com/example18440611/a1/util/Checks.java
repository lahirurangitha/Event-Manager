package com.example18440611.a1.util;

public class Checks {

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static boolean isNotNullAndNonEmpty(String string) {
        return string != null && !string.isEmpty();
    }
}
