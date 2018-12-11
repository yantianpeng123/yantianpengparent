package com.yantianpeng.Chapter02;

import java.util.Random;

/**

* @Description:    测试Java控制语句

* @Author:        yantianpeng

* @CreateDate:     2018/12/8 下午9:24


*/
public class Controll {


    public static void main(String[] args) {
//        while (contaianl()){
//            System.out.println("Inside while ");
//        }
//        System.out.println("循环终止");

        //test01();
       // test02();
      //  test03();
       // test04();
        int[] fibonaccisequence = Fibonaccisequence(6);


    }
    static boolean contaianl(){
        return   Math.random()<0.99;
    }

    /**
     *  测试for循环
     */
    public static void test01(){
        for (char i = 0; i <128 ; i++) {
            if(Character.isLowerCase(i)){
                System.out.println("value: "+(int)i+" character : "+i);
            }
        }
    }

    /**
     * 产生25个随机数对于每一个随机数使用if-else语句来将其分类为大于 小于 等于紧随他产生的值
     */
    public static void test02(){
        int firstRandom = 0;
        for (int i = 0; i <24 ; i++) {
            //产生随机数int
            int random =(int) (Math.random()*100)+1;
            //设置最小数为0
            if((i+1)==1){
                System.out.println("第"+(i+1)+"个产生的随机数： "+random);
                firstRandom =random;
                continue;
            }
            if(random>firstRandom){
                System.out.println("第"+(i+1)+"个产生的随机数： "+random+"大于："+firstRandom);
                firstRandom =random;
            }else if(random<firstRandom){
                System.out.println("第"+(i+1)+"个产生的随机数： "+random+"小于："+firstRandom);
                firstRandom =random;
            }else {
                System.out.println("第"+(i+1)+"个产生的随机数： "+random+"等于："+firstRandom);
                firstRandom =random;
            }
        }
    }

    public static void test03(){
        int i = 0;
        outer :
        for (;true;){
            inner :
            for (;i < 10;i++){
                System.out.println("i ="+i);
                if(i==2){
                    System.out.println("continue");
                    continue ;
                }
                if(i == 3){
                    System.out.println("break;");
                    i++;
                    break ;
                }
                if(i == 7 ){
                    System.out.println("break outer");
                    i++;
                    continue   outer;
                }
                if(i == 8 ){
                    System.out.println("break outer");
                    break outer;
                }
                for (int j = 0; j <5 ; j++) {
                    if(j == 3 ){
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }

    /**
     * 测试switch语句
     */
    public static void test04(){
        Random random = new Random(47);
        for (int i = 0; i <100 ; i++) {
            int c = random.nextInt(26)+'a';
            System.out.println((char)(c)+" ,"+c+" :");
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'Y':
                case 'W':
                    System.out.println("Sometimes is vowel");
                    break;
                    default:System.out.println("consonat");
            }
        }
    }

    //斐波那契数列
    public static int [] Fibonaccisequence(int index){
     int [] strList = new int[index];
       strList[0] = 1;
       strList[1] = 1;
        for (int i = 2; i <index ; i++) {
            strList[i] = strList[i-2]+strList[i-1];
        }
        return strList;
    }
}
