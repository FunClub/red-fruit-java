package com.taomei.redfruit.api.area.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties("log_id")
public class AreaResponse {
    private String ret;
    private String msg;
    private List<Area> data;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Area> getData() {
        return data;
    }

    public void setData(List<Area> data) {
        this.data = data;
    }
}
