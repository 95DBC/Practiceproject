package com.example.raymond.mvpdemo.delete.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.delete.view.ShowDeleteInfo;
import com.example.raymond.mvpdemo.model.DBoperationable;
import com.example.raymond.mvpdemo.model.DBoperationableIml;

/**
 * Created by Raymond 陈徐锋 on 2018/3/5.
 * Email: raymond@hinteen.com
 * Description: Delete 实现类
 */

public class DeleteIml implements Deleteable {
    private ShowDeleteInfo showDeleteInfo;
    private DBoperationable dBoperationable;

    public DeleteIml(ShowDeleteInfo showDeleteInfo){
        this.showDeleteInfo = showDeleteInfo;
        dBoperationable = new DBoperationableIml();
    }
    @Override
    public void delteUser(Context context, long id) {
        // TODO: 2018/3/5   dBoperationable.openDB(context); 该行代码有无必要需要验证
        dBoperationable.openDB(context);
        dBoperationable.deleteData(context,id);
    }
}
