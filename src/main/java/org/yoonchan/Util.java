package org.yoonchan;

public class Util {
    /**
     * Formats each word in a string to title case. Assumes words in str are always separated by space.
     * @param str The input string to be formatted.
     * @return The formatted string, in title case.
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.toUpperCase();
        return str.charAt(0) + str.substring(1).toLowerCase();
    }
}
