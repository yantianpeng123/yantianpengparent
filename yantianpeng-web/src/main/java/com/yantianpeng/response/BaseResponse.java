package com.yantianpeng.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;


/**

* @Description:    平台通用返回数据

* @Author:        yantianpeng

* @CreateDate:     2018/11/22 上午11:26


*/
public class BaseResponse {

    //状态 是否成功
    @JsonInclude(Include.NON_NULL)
    private boolean success;
    //错误代码
    @JsonInclude(Include.NON_NULL)
    private String errorCode;
    //数据
    @JsonInclude(Include.NON_NULL)
    private List<?> data;
    //备注
    @JsonInclude(Include.NON_NULL)
    private String notes;
    public BaseResponse(){}
    public BaseResponse(boolean success, List<?> data, String notes) {
        super();
        this.success = success;
        this.data = data;
        this.notes = notes;
    }

    public BaseResponse(boolean success, String errorCode, String notes) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.notes = notes;
    }

    public BaseResponse(boolean success, String notes) {
        super();
        this.success = success;
        this.notes = notes;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



}
