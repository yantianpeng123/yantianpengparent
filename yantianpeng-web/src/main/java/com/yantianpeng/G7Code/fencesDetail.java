package com.yantianpeng.G7Code;

import lombok.Data;

/**

* @Description:    fencesDetail

* @Author:        yantianpeng

* @CreateDate:     2018/12/14 下午2:21


*/
@Data
public class fencesDetail {
    /**
     * 片区编码
     */
 private  String  areacode	;
    /**
     * 片区名称
     */
 private String areaname	;
    /**
     * 片区说明
     */
 private  String remark	;
    /**
     * 信息说明（匹配成功时为空）
     */
  private  String message	;
//    /**
//     * 片区说明
//     */
//  private String remark	;
}
