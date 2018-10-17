package com.yantianpeng.Utils;

import java.lang.reflect.Array;
import java.util.*;

public class StringUtils {
    public static void main(String[] args) {
        String string ="12 23 34 45 56 67 78 89 90";
        System.out.println(SpiltByParent(string));
    }

    /**
     * 按照逗号拼接，并去掉最后一个逗号 一般又在sql的 in语句里面。
     * @param string
     * @return
     */
    public static String  SpiltByParent(String string){
        String[] split = string.split("\\s+");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" in ( ");
        for (String str: split) {
            stringBuffer.append("'"+str+"',");
        }
       String trimStr = stringBuffer.substring(0,stringBuffer.length()-1);

        return trimStr+" ) ";
    }



    /**
     *      去除四种括号里面的内容包含括号一块去除掉，并且去除中间的空格。
     * @param string
     * @return
     */
    public static String TrimParentheses (String string){
        String str=  string.replaceAll("\\(.*?\\)|\\{.*?}|\\[.*?]|（.*?）"," ").trim();
       return str.replace(" ","");
    }





    /**
     * 判断对象是空
     * @param object
     * @return
     */
    public static boolean IsEmptyOrNull(Object object){
       if(object ==null) return true;
       if(object instanceof String && object.toString().trim().length()==0){
            return true;
       }
       if(object.getClass().isArray()&& Array.getLength(object)==0){
            return  true;
       }
       if(object instanceof Collection && ((Collection)object).isEmpty()){
            return true;
       }
       if(object instanceof Map && ((Map)object).isEmpty()){
           return  true;
       }
       return  false;
    }
}
