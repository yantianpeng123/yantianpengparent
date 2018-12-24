package com.yantianpeng.Chapter05;
/**

* @Description:    Static 关键词的

* @Author:        yantianpeng

* @CreateDate:     2018/12/18 下午9:57


*/
public class staticClass {
    public static void main(String[] args) {
        System.out.println("Creating new Cupbpard() in main");
        new Cupboard();
        System.out.println("Createing new Cupboard in main");
        new Cupboard();
    }

    static  Table table =new Table();
    static Cupboard cupboard = new Cupboard();
}


class Bowl{
    Bowl(int mark){
        System.out.println("Bowl:("+mark+")");
    }

    void f1(int mark){
        System.out.println("f1("+mark+")");
    }
}

class Table{
    static  Bowl bowl = new Bowl(1);
    Table(){
        System.out.println("Table");
        bowl2.f1(1);
    }

    void f2(int mark){
        System.out.println("f2("+mark+")");
    }
    static Bowl bowl2 =new Bowl(2);
}

class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 =new Bowl(4);
    Cupboard(){
        System.out.println("Cupboard");
        bowl4.f1(2);
    }
    void f3(int mark){
        System.out.println("f3:("+mark+")");
    }

    static Bowl bowl5 = new Bowl(5);
}