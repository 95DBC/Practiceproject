package com.example.raymond.mvpdemo.login.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.login.view.ShowLoginInfo;
import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.model.dao.DBoperationIml;

/**
 * Created by Raymond 陈徐锋 on 2018/2/28.
 * Email: raymond@hinteen.com
 * Description: 该Presenter 用于登录的逻辑操作和登录UI的交互
 */

public class LoginIml implements Loginable {
    private ShowLoginInfo showLoginInfo;
    private DBoperationable dBoperationable;

    public LoginIml(ShowLoginInfo showLoginInfo){
        this.showLoginInfo = showLoginInfo;
        dBoperationable = new DBoperationIml();
    }


    @Override
    public void queryUser(Context context) {
        dBoperationable.openDB(context);
        dBoperationable.queryData(context);
    }
}
