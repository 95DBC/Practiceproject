package com.example.raymond.mvpdemo.savepicture.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.savepicture.view.QueryIconable;
import com.example.raymond.mvpdemo.savepicture.view.UserIconable;
import com.example.raymond.mvpdemo.update.presenter.UpdateInfoable;

/**
 * Created by Raymond 陈徐锋 on 2018/3/13.
 * Email: raymond@hinteen.com
 * Description:
 */

public class AddUserIconIml implements AddUserIconable {
    private DBoperationable mDBoperationable;
    private UserIconable mUserIconable;
    private QueryIconable mQueryIconable;

    public  AddUserIconIml(UserIconable userIconable) {
        this.mUserIconable = userIconable;
        mDBoperationable = new DBoperationIml();
    }

    public AddUserIconIml(QueryIconable queryIconable){
        this.mQueryIconable = queryIconable;
        mDBoperationable = new DBoperationIml();
    }

    @Override
    public void addUserIcon(Context context, String userIcon) {
        mDBoperationable.insertUserIcon(context,userIcon);
    }

    @Override
    public void showUserIcon(Context context, long iconId) {
        mDBoperationable.queryUserIcon(context,iconId);

    }
}
