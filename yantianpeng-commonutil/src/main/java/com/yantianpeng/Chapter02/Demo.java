package com.yantianpeng.Chapter02;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
      //  System.getProperties().list(System.out);
        //test01();
        test02();
    }

    public static void test01(){
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 12;
        t2.level = 23;

        System.out.println("t1.level = "+t1.level+" t2.level ="+t2.level);
        t1 = t2;
        System.out.println("t1.level = "+t1.level+" t2.level ="+t2.level);
        t1.level =98;
        System.out.println("t1.level = "+t1.level+" t2.level ="+t2.level);
    }

    public static void test02(){
        Random random = new Random(47);
        int i = random.nextInt(100)+1;
        System.out.println(i);
    }
}
