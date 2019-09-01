package com.yantianpeng.Chapter02;
/**

* @Description:    证明&&是短路的代码

* @Author:        yantianpeng

* @CreateDate:     2018/12/6 下午10:39


*/
public class Demo02 {
//    public static void main(String[] args) {
//        boolean b = test01(0)&& test02(2)&& test03(3);
//        System.out.println(b);
//    }

    public static boolean test01(int value){
        System.out.println("test01 value = "+value);
        return value < 1;
    }

    public static boolean test02(int value){
        System.out.println("test02 value = "+value);
        return value < 2;
    }

    public static boolean test03(int value){
        System.out.println("test03 value = "+value);
        return value < 3;
    }
}
