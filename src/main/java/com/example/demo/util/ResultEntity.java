package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回格式类
 *
 */
public class ResultEntity {
 
    /**
     * 是否成功
     */
    private Boolean success;
 
    /**
     * 状态码
     */
    private Integer code;
 
    /**
     * 返回的消息
     */
    private String message;
 
    /**
     * 放置响应的数据
     */
    private Map<String, Object> data = new HashMap<>();
 
    public ResultEntity() {}
 
    /** 以下是定义一些常用到的格式，可以看到调用了我们创建的枚举类 */
    
    public static ResultEntity ok() {
        ResultEntity r = new ResultEntity();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }
 
    public static ResultEntity error() {
        ResultEntity r = new ResultEntity();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }
 
    public static ResultEntity setResult(ResultCodeEnum resultCodeEnum) {
        ResultEntity r = new ResultEntity();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }
 
    public ResultEntity success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
 
    public ResultEntity message(String message) {
        this.setMessage(message);
        return this;
    }
 
    public ResultEntity code(Integer code) {
        this.setCode(code);
        return this;
    }
 
    public ResultEntity data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
 
    public ResultEntity data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
 
    /** 以下是get/set方法，如果项目有集成lombok可以使用@Data注解代替 */
 
    public Boolean getSuccess() {
        return success;
    }
 
    public void setSuccess(Boolean success) {
        this.success = success;
    }
 
    public Integer getCode() {
        return code;
    }
 
    public void setCode(Integer code) {
        this.code = code;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public Map<String, Object> getData() {
        return data;
    }
 
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}