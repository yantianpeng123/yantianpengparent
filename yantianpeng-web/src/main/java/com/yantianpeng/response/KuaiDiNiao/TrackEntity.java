package com.yantianpeng.response.KuaiDiNiao;

import lombok.Data;

import java.util.List;
/**

* @Description:    即时查询物流轨迹

* @Author:        yantianpeng

* @CreateDate:     2018/11/22 下午2:51


*/
@Data
public class TrackEntity {
   private String LogisticCode;
    private String ShipperCode;
    private String State;
    private String EBusinessID;
    private boolean  Success;
    private String Reason;
    private List<TracesEntity> Traces;
}
