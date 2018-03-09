package com.example.raymond.mvpdemo.update.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.update.view.ShowUpdateInfoable;

/**
 * Created by Raymond 陈徐锋 on 2018/3/2.
 * Email: raymond@hinteen.com
 * Description:
 */

public class UpdateIfnoIml implements UpdateInfoable{

    private ShowUpdateInfoable showUpdateInfoable;
    private DBoperationable dboperationable;

    public UpdateIfnoIml(ShowUpdateInfoable showUpdateInfoable){
        this.showUpdateInfoable = showUpdateInfoable;
        dboperationable = new DBoperationIml();
    }

    @Override
    public void updateUserInfo(Context context,long id,String name,String password) {
        dboperationable.openDB(context);
        dboperationable.updateData(context,id, name, password);
    }
}
