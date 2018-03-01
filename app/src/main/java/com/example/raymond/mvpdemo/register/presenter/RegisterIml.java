package com.example.raymond.mvpdemo.register.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.DBoperation;
import com.example.raymond.mvpdemo.model.DBoperationIml;
import com.example.raymond.mvpdemo.register.view.ShowRegisterInfo;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description:
 */

public class RegisterIml implements Register {
    private ShowRegisterInfo showRegisterInfo;
    private DBoperation DBoperation;

    public RegisterIml(ShowRegisterInfo showRegisterInfo) {
        this.showRegisterInfo = showRegisterInfo;
        DBoperation = new DBoperationIml();
    }

    public void addUser(Context context, long id, String name, String password) {
        showRegisterInfo.insertDataing(context);
        DBoperation.openDB(context);
        DBoperation.insertData(context,id, name, password);
    }

    public void queryUser(Context context){
        DBoperation.openDB(context);
        DBoperation.queryData(context);
    }

    @Override
    public void CommitUserInfoResult(Context context) {
        showRegisterInfo.showSuccess(context);
    }
}
