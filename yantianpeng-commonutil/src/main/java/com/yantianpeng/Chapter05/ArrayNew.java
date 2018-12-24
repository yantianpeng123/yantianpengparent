package com.yantianpeng.Chapter05;

import java.util.Arrays;
import java.util.Random;

/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/24 下午10:02


*/
public class ArrayNew {

    public static void main(String[] args) {
//        test01();
//        Integer[] integers = test02();
//        for (Integer a: integers) {
//            System.out.print(a+" ");
//        }

//        Integer[] integers1 = test03();
////        for (Integer b :integers1) {
////            System.out.print(b+" ");
////        }

        printArray(new Object[]{1,'e',new Double(9.0),new Float(3.4)});
        System.out.println();
        printArray01(new Object[]{1,'e',new Double(3.9),new Float(9.0)});

        test04(1,'a');
        test04('a','b');

    }

    public static void test04(Integer a,Character... character){
        System.out.println("first");
    }


    public static void test04(Character... c){
        System.out.println("second");
    }

public static void f(int i,String...trailing){
        System.out.println("require "+ i);
        for(String s:trailing)
            System.out.print(s+" ");
        System.out.println();
    }


    public static void  printArray01(Object... args){
        for (Object a : args){
            System.out.print(a+" '");
        }
    }
    public static void printArray(Object [] args){
        for (Object object : args){
            System.out.print(object+" ");
        }
    }

    public static Integer [] test03(){
        Integer a [] ={
                new Integer(1),
                new Integer(2),
                3
        };
        return a;
    }

    public static Integer [] test02(){
        Integer a[];
        Random random =new Random(47);
        a = new Integer[random.nextInt(20)];
        for (int i = 0; i <a.length ; i++) {
            a[i] = random.nextInt(500);
        }
        Arrays.sort(a);
        return a;
    }
    public static int [] test01(){
        int [] a;
        Random random =new Random(47);
        a =new int[random.nextInt(20)];
        System.out.println(a.length);
         Arrays.sort(a);
         return  a;
    }
}
