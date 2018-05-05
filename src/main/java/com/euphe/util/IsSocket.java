package com.euphe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsSocket {
    public static boolean IsMatch(String str){
        //IP/套接字正则表达式(\d{1,3}.){3}\d{1,3}(:\d{1,5})?
        String regEX = "(\\d{1,3}.){3}\\d{1,3}(:\\d{1,5})?";

        Pattern pattern = Pattern.compile(regEX);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();

        return rs;
    }
}
