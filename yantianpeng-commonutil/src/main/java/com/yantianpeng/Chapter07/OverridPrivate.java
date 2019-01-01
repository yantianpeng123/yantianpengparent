package com.yantianpeng.Chapter07;
/**

* @Description:    尝试着重写fianl修饰的方法

* @Author:        yantianpeng

* @CreateDate:     2018/12/31 下午4:58


*/
public class OverridPrivate extends withFinal{
    private final void f(){
        System.out.println("OverridPrivate.f()");
    }

    private void g(){
        System.out.println("OverridPrivate.g()");
    }
}
