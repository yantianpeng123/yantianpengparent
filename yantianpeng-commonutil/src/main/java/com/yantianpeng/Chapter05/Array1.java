package com.yantianpeng.Chapter05;
/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/18 下午10:49


*/
public class Array1 {

    public static void main(String[] args) {
        int [] a1 ={1,2,3,4,5,6};
        int [] a2;
        a2 = a1 ;
        for (int i = 0; i <a2.length ; i++)
            a2[i] = a2[i]+1;
        for (int i = 0; i <a1.length ; i++)
            System.out.println(a1[i]);

    }
}
