package org.yoonchan;

public class Util {
    /**
     * Formats each word in a string to title case. Assumes words in the string are always separated by space.
     * @param str The input string to be formatted.
     * @return The formatted string, in title case.
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.strip();
        String result = "";
        String[] substrings = str.split(" ");
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = substrings[i].toUpperCase();
            substrings[i] = substrings[i].charAt(0) + substrings[i].substring(1).toLowerCase();
            if (i < substrings.length - 1) {
                result += substrings[i] + " ";
            } else {
                result += substrings[i];
            }
        }
        return result;
    }
}
