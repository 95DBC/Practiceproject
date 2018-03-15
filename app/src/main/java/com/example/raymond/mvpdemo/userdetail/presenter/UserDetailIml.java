package com.example.raymond.mvpdemo.userdetail.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.userdetail.view.ShowUserDetialable;

/**
 * Created by Raymond 陈徐锋 on 2018/3/15.
 * Email: raymond@hinteen.com
 * Description:
 */

public class UserDetailIml implements UserDetailable{
    private ShowUserDetialable mShowUserDetialable;
    private DBoperationable mDBoperationable;

    public UserDetailIml(ShowUserDetialable showUserDetialable){
        this.mShowUserDetialable = showUserDetialable;
        mDBoperationable = new DBoperationIml();
    }

    @Override
    public void queryUser(Context context) {
        mShowUserDetialable.getBundleData(context);

    }
}
