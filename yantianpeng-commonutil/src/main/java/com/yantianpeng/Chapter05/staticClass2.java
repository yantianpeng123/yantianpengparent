package com.yantianpeng.Chapter05;
/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/18 下午10:26


*/
public class staticClass2 {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(1) completed");
    }
}
class Mug{
    Mug(int mark){
        System.out.println("Mug("+mark+")");
    }

    void f(int mark){
        System.out.println("f("+mark+")");
    }
}

