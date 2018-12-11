package com.yantianpeng.entity.kuaiDiaNiao;

import lombok.Data;

import java.util.Date;

/**

* @Description:    订单类

* @Author:        yantianpeng

* @CreateDate:     2018/11/29 下午4:14


*/
@Data
public class Order {
    /**
     * 仓库标识(备用字段)
     */
    private String WarehouseID;
    /**
     * 仓库地址(备用字段)
     */
    private String WarehouseAddress;
    /**
     * 用户自定义回传字段
     */
    private String Callback;
    /**
     * ERP 系统、电商平台等系统或平 台类型用户的会员 ID 或店铺账号 等唯一性标识，用于区分其用户
     */
    private String MemberID;
    /**
     *
     * 快递公司编码
     */
    private String ShipperCode;
    /**
     * 选择快递柜支持预约的快递公司 (ShipperCode 为 FCBOX 时必填) SF:顺丰速运(仅支持 ExpType 为 1 和 2 两种业务类型) ZTO:中通快递 STO:申通快递 YD:韵达速递
     * EMS:EMS
     */
    private String FcBoxShipperCode;
    /**
     * 快递单号
     */
    private String LogisticCode;
    /**
     * 订单编号(自定义，不可重复)
     */
    private String OrderCode;
    /**
     * 运费支付方式: 1- 现付 2- 到付 3-月结 4-第三方支付(近SF支持)
     */
    private String PayType;
    /**
     * 月结编号
     */
    private String   MonthCode;
    /**
     * 详细快递类型参考《快递公司快 递业务类型.xlsx》
     */
    private int ExpType;
    /**
     快递运费
     */
    private Double Cost;
    /**
     * 其他费用
     */
    private Double OtherCost;
    /**
     * 上门揽件时间段，格式:
     * YYYY-MM-DD HH24:MM:SS
     */
    private Date StartDate;
    /**
     * 上门揽件时间段，格式:
     *  YYYY-MM-DD HH24:MM:SS
     */
    private Date EndDate;
    /**
     * 包裹总重量 kg
     */
    private Double Weight;
    /**
     * Quantity
     * Int(2)
     * R
     * 包裹数，一个包裹对应一个运单 号，如果是大于 1 个包裹，返回 则按照子母件的方式返回母运单号和子运单号
     */
    private int Quantity;
    /**
     * 包裹总体积 m3
     */
    private Double Volume;
    /**
     * 备注
     */
    private String Remark;
}
