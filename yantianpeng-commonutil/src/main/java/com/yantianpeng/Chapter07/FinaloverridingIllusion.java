package com.yantianpeng.Chapter07;

import java.util.Vector;

public class FinaloverridingIllusion {
    public static void main(String[] args) {
        OverridPrivate2 overridPrivate2 = new OverridPrivate2();
        overridPrivate2.f();
        overridPrivate2.g();
        OverridPrivate overridPrivate= overridPrivate2;//   可以实现引用的传递 但是不能调用方法
//         overridPrivate).f();  不能实现方法的调用
    }
}
