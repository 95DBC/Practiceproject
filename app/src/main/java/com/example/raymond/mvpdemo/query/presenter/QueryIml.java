package com.example.raymond.mvpdemo.query.presenter;


import android.content.Context;

import com.example.raymond.mvpdemo.model.DBoperationable;
import com.example.raymond.mvpdemo.model.DBoperationableIml;
import com.example.raymond.mvpdemo.query.view.ShowQueryInfo;

/**
 * Created by Raymond 陈徐锋 on 2018/3/5.
 * Email: raymond@hinteen.com
 * Description:
 */

public class QueryIml implements Queryable {
    private ShowQueryInfo showQueryInfo;
    private DBoperationable dBoperationable;

    public QueryIml (ShowQueryInfo showQueryInfo){
        this.showQueryInfo = showQueryInfo;
        dBoperationable = new DBoperationableIml();
    }

    @Override
    public void queryAllUser(Context context) {
        dBoperationable.openDB(context);
        dBoperationable.queryAll();
        showQueryInfo.showOnRecycleView();
    }
}
