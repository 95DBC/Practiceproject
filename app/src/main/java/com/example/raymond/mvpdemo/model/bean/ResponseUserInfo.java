package com.example.raymond.mvpdemo.model.bean;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/3/8.
 * Email: raymond@hinteen.com
 * Description:
 */

public class ResponseUserInfo {
    private int code;
    private List<Data> data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }

}
