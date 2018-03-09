package com.example.raymond.mvpdemo.register.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.register.view.ShowRegisterInfo;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description: 注册实现类
 */

public class RegisterableIml implements Registerable {
    private ShowRegisterInfo showRegisterInfo;
    private DBoperationable DBoperationable;

    public RegisterableIml(ShowRegisterInfo showRegisterInfo) {
        this.showRegisterInfo = showRegisterInfo;
        DBoperationable = new DBoperationIml();
    }

    @Override
    public void addUser(Context context, long id, String name, String password) {
        showRegisterInfo.insertDataing(context);
        DBoperationable.openDB(context);
        DBoperationable.insertData(context,id, name, password);
    }

}
