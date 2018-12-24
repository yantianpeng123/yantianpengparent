package com.yantianpeng.Chapter05;
/**

* @Description:    java类作用描述

* @Author:        yantianpeng

* @CreateDate:     2018/12/18 下午9:45


*/
public class Counter {
    int i;
    Counter(){
        i =7;
    }

    public static void main(String[] args) {
       // Counter counter = new Counter();
        House house = new House();
        house.f();
    }
}


class Window{
    Window(int mark){
        System.out.println("window:("+mark+")");
    }
}

class House{
    void g(){
        System.out.println("g");
    }
    Window window1 =new Window(1);

    House(){
        System.out.println("House");
        Window window2 =new Window(2);
    }
    Window window3 = new Window(3);
    void f(){
        System.out.println("f()");
    }

    Window window4 = new Window(4);
}