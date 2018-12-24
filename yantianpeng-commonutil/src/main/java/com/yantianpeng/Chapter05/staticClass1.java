package com.yantianpeng.Chapter05;
/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/18 下午10:19


*/
public class staticClass1 {
    public static void main(String[] args) {
        System.out.println("Inside main");
        Cups.cup1.f(99);
    }
}

class Cup{
    Cup(int mark){
        System.out.println("Cup("+mark+")");
    }
    void f(int mark){
        System.out.println("f("+mark+")");
    }
}
class Cups{
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 =new Cup(1);
        cup2 = new Cup(2);
    }
    Cups(){
        System.out.println("Cpus()");
    }
}