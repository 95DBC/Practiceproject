package com.example.raymond.mvpdemo.talk.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.talk.view.ShowTalkDataOnView;

/**
 * Created by Raymond 陈徐锋 on 2018/4/25.
 * Email: raymond@hinteen.com
 * Description:
 */
public class QueryTalkContext implements QuerTalkContextable {
    private DBoperationable mDBoperationable;
    private ShowTalkDataOnView mShowTalkDataOnView;

    public QueryTalkContext(ShowTalkDataOnView showTalkDataOnView){
        this.mShowTalkDataOnView = showTalkDataOnView;
        mDBoperationable = new DBoperationIml();
    }

    @Override
    public void queryTalkDataFromDB(Context context) {
        mDBoperationable.queryAllTalkText(context);
        mShowTalkDataOnView.showTalkContextOnView();

    }
}
