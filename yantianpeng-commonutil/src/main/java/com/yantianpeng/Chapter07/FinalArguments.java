package com.yantianpeng.Chapter07;
/**

* @Description:    Final 参数化

* @Author:        yantianpeng

* @CreateDate:     2018/12/31 下午4:49


*/
public class FinalArguments {

    void without(final Gizmo gizmo){
//        gizmo = new Gizmo();  非法  gizmo  是一个常量
    }

    /**
     * 可以被参数化
     * @param
     */
//    void  without(Gizmo gizmo){
//        gizmo = new Gizmo();
//        gizmo.spin();
//    }

    int g(final  int i){
        return i+1;
    }
}
