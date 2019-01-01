package com.yantianpeng.Chapter07;

class Insect {
    private int i = 0;

    protected int j ;

    Insect(){
        System.out.println(i+" i,"+j+" j");
        j =39;
    }

    private static int x =printInit("static Insect.x1 inittialized");


    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}


