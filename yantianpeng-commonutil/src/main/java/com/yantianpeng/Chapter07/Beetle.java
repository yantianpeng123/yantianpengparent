package com.yantianpeng.Chapter07;

public class Beetle extends Insect {

    private int k  = printInit("Beetle.k initialzed");

    public Beetle(){
        System.out.println("k ="+k);
        System.out.println("j = "+j);
    }

    private static int x2 =printInit("Beetle.x2 initalzed");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
