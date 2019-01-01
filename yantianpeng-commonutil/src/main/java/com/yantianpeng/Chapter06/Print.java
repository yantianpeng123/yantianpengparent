package com.yantianpeng.Chapter06;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**

* @Description:    定制打印方法

* @Author:        yantianpeng

* @CreateDate:     2018/12/25 下午10:48


*/
public class Print {
    /**
     * 打印换行
     */
    public static void printLine(){
        System.out.println();
    }

    /**
     * 打印int 类型
     * @param i
     */
    public static void printInt(int i){
        System.out.println(i);
    }

    /**
     * 打印Float类型
     * @param f
     */
    public static void printFloat(Float f){
        System.out.println(f);
    }

    /**
     * 打印String类型
     * @param string
     */
    public static void printString(String string){
        System.out.println(string);
    }

    /**
     * 打印基本类型和String
     * @param object
     */
    public static void printJeBen(Object object){
        if(object instanceof Integer)
            System.out.println((int)object);
        if(object instanceof Double)
            System.out.println((Double) object);
        if(object instanceof Float)
            System.out.println((Float) object);
        if(object instanceof Boolean)
            System.out.println((Boolean) object);
        if(object instanceof Byte)
            System.out.println((Byte)object);
        if(object instanceof Short )
            System.out.println((Short) object);
        if(object instanceof Character)
            System.out.println((Character) object);
        if(object instanceof String)
            System.out.println((String)object);
        if(object instanceof List){
           if(object instanceof ArrayList){
               List lsit = (ArrayList)(object);
               for (int i = 0; i <lsit.size() ; i++) {
                   System.out.println(lsit.get(i));
               }
           }
            /**
             * 遍历LinkList 使用迭代器进行遍历 不要使用普通的额for循环遍历
             */
           if(object instanceof LinkedList){
               List lsit = (LinkedList)(object);
               Iterator iterator = lsit.iterator();
               while (iterator.hasNext()){
                   System.out.println(iterator.next().toString());
               }
           }

        }
    }

    public static void printList(){

    }


    public static void main(String[] args) {
        printJeBen("kkkkkkkk");
    }
}
