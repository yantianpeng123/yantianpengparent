package com.yantianpeng.response.KuaiDiNiao;

import lombok.Data;

import java.util.List;

/**

* @Description:    单号识别

* @Author:        yantianpeng

* @CreateDate:     2018/11/22 下午2:52


*/
@Data
public class OrderIdentify {
  private String  LogisticCode;
   private String EBusinessID;
//   private String Code;
//   private boolean Success;
   private List<Shippers> Shippers;
}
@Data
class Shippers{
   private String ShipperName;
    private String ShipperCode;
}
