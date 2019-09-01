package com.yantianpeng.Chapter02;
/**

* @Description:    直接变量

* @Author:        yantianpeng

* @CreateDate:     2018/12/6 下午10:45


*/
public class Demo03 {

//    public static void main(String[] args) {
//        test01();
//    }

    public static void test01(){
        int i1 = 0x2f;
        System.out.println("i1: = "+Integer.toBinaryString(i1));
        int i2 = 0x2F;
        System.out.println("i2: = "+Integer.toBinaryString(i2));
        int i3 = 0177;
        System.out.println("i3 = "+Integer.toBinaryString(i3));
        char c =0xffff;
        System.out.println("i4 = "+Integer.toBinaryString(c));
        byte b = 0x7f;
        System.out.println("i5 = "+Integer.toBinaryString(b));
        short s = 0x7fff;
        System.out.println("i6 = "+Integer.toBinaryString(s));
        long n1 = 200l;
        long n2 = 200L;
        long n3 =200;

    }
}
