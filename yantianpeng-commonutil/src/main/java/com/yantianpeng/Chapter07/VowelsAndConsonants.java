package com.yantianpeng.Chapter07;
/**

* @Description:    switch的用法

* @Author:        yantianpeng

* @CreateDate:     2019/9/1 下午5:15


*/
public class VowelsAndConsonants {

    public static void main(String[] args) {
        System.out.println("wwwwwwwww");
    }

    public static void test01(){
        for (int i = 0; i <100 ; i++) {
            char c = (char)(Math.random()*26+'a');
            System.out.println(c);
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;

                case 'y':
                case 'w':
                    System.out.println("Somtimes is volwe");
                    break;

                default:
                        break;
            }
        }
    }
}
