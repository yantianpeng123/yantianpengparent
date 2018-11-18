package com.yantianpeng.TimeUtils;

import java.time.LocalDate;

/**

* @Description:    JDk1.8中日期类

* @Author:        yantianpeng

* @CreateDate:     2018/11/12 下午3:00


*/
public class LocalDateController {

    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        LocalDate now = LocalDate.now();
        System.out.println(now.toString());
    }
}
