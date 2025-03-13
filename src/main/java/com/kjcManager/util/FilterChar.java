package com.kjcManager.util;

public class FilterChar {

    public static String filterChar(String content) {
        char[] ch = {'|', '\'', '@', '\"', '+', '(', ')', '\\', '~', '^', '?', '/'};
        for(char c : ch) {
            if(content.indexOf(c) > 0) {
                return "2021";
            }
        }
        return content;
    }
}
