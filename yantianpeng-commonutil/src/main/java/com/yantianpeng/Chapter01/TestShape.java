package com.yantianpeng.Chapter01;
/**

* @Description:   多态和继承的理解

* @Author:        yantianpeng

* @CreateDate:     2018/11/18 下午5:37


*/
public class TestShape {

    public static void main(String[] args) {
        Circle circle= new Circle();
        doSomething(circle);
        Traingle traingle =new Traingle();
        doSomething(traingle);
        Line line =new Line();
        doSomething(line);
    }

    public static void doSomething(Shape shape){
        shape.draw();
        shape.move();
    }
}
