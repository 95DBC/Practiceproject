package com.example.raymond.mvpdemo.model.bean;

/**
 * Created by Raymond 陈徐锋 on 2018/3/8.
 * Email: raymond@hinteen.com
 * Description: BaseUrl 中的一部分
 */

public class BaseHttpEntity {

    private String method;
    private Long time;
    private String auth;
    private String content;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "method=" + method +
                "&time=" + time +
                "&auth=" + auth +
                "&content=" + content ;
    }
}
