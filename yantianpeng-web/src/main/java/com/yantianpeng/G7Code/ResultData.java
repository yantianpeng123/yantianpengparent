package com.yantianpeng.G7Code;

import lombok.Data;

import java.util.List;

/**

* @Description:    G7data数据类型

* @Author:        yantianpeng

* @CreateDate:     2018/12/14 下午2:16


*/
@Data
public class ResultData {

     private List<resultDetail> result;
    private 	List<errorDeatil> error	;
}
