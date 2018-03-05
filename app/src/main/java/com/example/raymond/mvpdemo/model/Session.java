package com.example.raymond.mvpdemo.model;

import java.io.Serializable;

/**
 * Created by Raymond 陈徐锋 on 2018/3/2.
 * Email: raymond@hinteen.com
 * Description: 临时对话类，用于存放在线用户信息
 */

public class Session implements Serializable {
    private String mUserAccount;
    private long mUserId;

    public Session(String mUserAccount, long mUserId) {
        this.mUserAccount = mUserAccount;
        this.mUserId = mUserId;
    }

    public Session() {

    }

    public String getmUserAccount() {
        return mUserAccount;
    }

    public void setmUserAccount(String mUserAccount) {
        this.mUserAccount = mUserAccount;
    }

    public long getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }


}
