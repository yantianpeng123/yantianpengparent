package com.yantianpeng.Chapter07;
/**

* @Description:    private 和final 关键字

* @Author:        yantianpeng

* @CreateDate:     2018/12/31 下午4:56


*/
public class withFinal {

    private final void f(){
        System.out.println("withFinal.f()");
    }

    private void g(){
        System.out.println("withFinal.g()");
    }
}
