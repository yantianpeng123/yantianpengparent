package com.yantianpeng.Chapter01;


/**

* @Description:    几何体类型

* @Author:        yantianpeng

* @CreateDate:     2018/11/18 下午5:24


*/
public class Shape {
    /**
     * 几何体的宽度
     */
    private String width;
    /**
     * 几何体的高度
     */
    private String height;
    /**
     * 几何体的长度
     */
    private String length;

    /**
     * 移除
     */
    public void move(){
        System.out.println(" 我是父类的移除");
    }

    /**
     * 画图行
     */
    public void draw(){
        System.out.println("我是父类的draw()");
    }
}
