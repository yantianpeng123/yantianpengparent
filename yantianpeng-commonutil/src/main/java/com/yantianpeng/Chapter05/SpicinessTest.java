package com.yantianpeng.Chapter05;
/**

* @Description:    枚举类型的测试

* @Author:        yantianpeng

* @CreateDate:     2018/12/24 下午11:02


*/
public class SpicinessTest {
    public static void main(String[] args) {
        for (Spiciness spiciness: Spiciness.values()) {
            System.out.println(spiciness+",ordinal "+spiciness.ordinal());
            test01(spiciness);
        }
    }



    public static void test01(Spiciness spiciness){
        switch (spiciness){
            case HOT: System.out.println("not spicy at all");
            break;
            case MILD:System.out.println("a little hot");
            break;
            case MEDIUM:System.out.println("medium");
            break;
            case FLAMING: System.out.println("flaming");
            break;
            default:System.out.println("not");
        }
    }
}
