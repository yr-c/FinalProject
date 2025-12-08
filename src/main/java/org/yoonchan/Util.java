package org.yoonchan;

public class Util {
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.toUpperCase();
        return str.charAt(0) + str.substring(1).toLowerCase();
    }
}
