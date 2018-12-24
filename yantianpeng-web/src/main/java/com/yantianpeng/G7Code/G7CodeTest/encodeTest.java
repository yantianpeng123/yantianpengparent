package com.yantianpeng.G7Code.G7CodeTest;

import java.net.URLEncoder;

/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/11 下午8:33


*/
public class encodeTest {
    public static void main(String[] args) throws Exception{
        String string = unicode("上海上海市青浦区菘泽大道7508号");
        String str = unicode("7508");
        System.out.println(str);
        System.out.println(string);
    }

    public static String unicode(String source) {
        StringBuffer sb = new StringBuffer();
        char[] source_char = source.toCharArray();
        String unicode = null;
        for (int i = 0; i < source_char.length; i++) {
            unicode = Integer.toHexString(source_char[i]);
            if (unicode.length() <= 2) {
                unicode = "00" + unicode;
            }
            sb.append("\\u" + unicode);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
