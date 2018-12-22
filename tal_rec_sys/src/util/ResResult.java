package util;

import java.io.Serializable;

public class ResResult implements Serializable {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public ResResult() {
        super();
    }

    public ResResult(Integer status,String msg,Object data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResResult build(Integer status, String msg, Object data) {
        return new ResResult(status, msg, data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
