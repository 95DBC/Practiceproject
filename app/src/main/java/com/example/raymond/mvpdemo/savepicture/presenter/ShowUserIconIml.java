package com.example.raymond.mvpdemo.savepicture.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.savepicture.view.QueryIconable;
import com.example.raymond.mvpdemo.update.view.ShowUpdateInfoable;

/**
 * Created by Raymond 陈徐锋 on 2018/3/14.
 * Email: raymond@hinteen.com
 * Description:
 */

public class ShowUserIconIml implements ShowUserIconable{

    private QueryIconable mQueryIconable;
    private DBoperationable mDBoperationable;

    public ShowUserIconIml(QueryIconable queryIconable){
        this.mQueryIconable = queryIconable;
        mDBoperationable = new DBoperationIml();
    }

    @Override
    public void showUserIcon(Context context, long iconId) {
        mDBoperationable.queryUserIcon(context,iconId);
        mQueryIconable.showUserIconOnImg();
    }
}
