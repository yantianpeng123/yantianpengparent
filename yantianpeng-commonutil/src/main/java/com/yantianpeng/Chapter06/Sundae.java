package com.yantianpeng.Chapter06;
/**

* @Description:    构造器私有化

* @Author:        yantianpeng

* @CreateDate:     2018/12/30 下午6:27


*/
public class Sundae {
    /**
     * 私有化构造器
     */
    private Sundae(){

    }

    /**
     *  返回Sunade实例对象
     *
     * @return
     */
    public static Sundae makeSundae(){
        return new Sundae();
    }

    private static Sundae sundae;

    /**
     * 判断该类的实例是否已经创建
     * @return
     */
    public static Sundae returnSunade(){
        if(sundae==null)
            return sundae;
        return null;
    }
}
