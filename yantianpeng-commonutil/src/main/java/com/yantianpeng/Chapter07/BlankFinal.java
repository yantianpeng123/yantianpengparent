package com.yantianpeng.Chapter07;
/**

* @Description:    空白fianl

* @Author:        yantianpeng

* @CreateDate:     2018/12/31 下午4:41


*/
public class BlankFinal {

    private final int i =0;
    private final int j;
    private final Poppet poppet;  //定义为final的值不能为空但是可以在构造器里面进行赋值操作

    /**
     *
     */
    public BlankFinal(){
        j = 1;
        poppet =new Poppet(1);
    }

    public BlankFinal(int x){
        j = x;
        poppet =new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
