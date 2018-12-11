package com.yantianpeng.entity.kuaiDiaNiao;

import lombok.Data;

/**

* @Description:    商品信息类

* @Author:        yantianpeng

* @CreateDate:     2018/11/29 下午4:30


*/
@Data
public class GoodsCommiodity {
    /**
     * 商品名称  必填项
     */
    private String goodsName;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品件数
     */
    private int goodsQuantity;
    /**
     * 商品价格
     */
    private Double goodsPrice;
    /**
     * 商品重量
     */
    private Double goodsWeight;
    /**
     * 商品描述
     */
    private String goodsDesc;
    /**
     * 商品体积
     */
    private Double goodsVol ;

}
