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
public class InsertTalkContext implements InsertTalkContextable {

    private DBoperationable mDBoperationable;
    private ShowTalkDataOnView mShowTalkDataOnView;

    public InsertTalkContext(ShowTalkDataOnView showTalkDataOnView){
        this.mShowTalkDataOnView = showTalkDataOnView;
        mDBoperationable = new DBoperationIml();
    }
    @Override
    public void insertDataToDB(Context context,Long uid,Long questionid,String talkContext) {
        mDBoperationable.insertTalkContext(context,uid,questionid,talkContext);
    }
}
