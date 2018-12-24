package com.yantianpeng.Chapter05;

public class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 =new Mug(1);
        mug2 = new Mug(2);
    }

    Mugs(){
        System.out.println("Mugs");
    }

    Mugs(int i){
        System.out.println("Mugs(int)");
    }

}
