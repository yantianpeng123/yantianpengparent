package com.yantianpeng.Reflect;
/**

* @Description:   java反射的应用

* @Author:        yantianpeng

* @CreateDate:     2018/11/19 下午2:48


*/
public class reflectCar {
    private String color;
    private String brand;

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void method(){
        System.out.println("测试反射");
    }
}
