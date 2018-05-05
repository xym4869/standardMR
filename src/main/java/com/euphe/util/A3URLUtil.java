package com.euphe.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class A3URLUtil {
    public static List<String> Analyze(String urlStr) throws MalformedURLException {
        final String errorChar = "*";
        List<String> URLLists = new ArrayList<String>();
            if(urlStr == null || urlStr.endsWith(errorChar)){
                URLLists.add(null);
                URLLists.add(null);
                return URLLists;
            }
            URL url = new URL(urlStr);

            //协议
            URLLists.add(url.getProtocol());
        //主机名
            URLLists.add(url.getHost());

            return URLLists;
    }
}
