package com.yantianpeng.StringUtils;

public class StringUtilsDemo {

    public static void main(String[] args) {
        test02();
    }

    public static void test01(){
        String str="23";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }
    //#######################正则表达式学习#######################################################

    /**
     * 正则表达式入门
     */
    public static void test02(){
        String string ="abc1234def";
        String str =string.replaceAll("/[0-9]+/",string);
        System.out.println(str);
    }
}
