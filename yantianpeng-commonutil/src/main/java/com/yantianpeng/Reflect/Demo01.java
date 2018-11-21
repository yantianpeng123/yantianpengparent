package com.yantianpeng.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**

* @Description:   测试反射

* @Author:        yantianpeng

* @CreateDate:     2018/11/19 下午2:54


*/
public class Demo01 {
    public static void main(String[] args) throws Exception{
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aClass = contextClassLoader.loadClass("com.yantianpeng.Reflect.reflectCar");
        //获取构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor:declaredConstructors) {
        }
        //获取属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field:declaredFields){

        }
        //获取方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method:declaredMethods) {

        }
    }

}
