package com.example.raymond.mvpdemo.talk.presenter;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/4/25.
 * Email: raymond@hinteen.com
 * Description:
 */
public interface InsertTalkContextable {

    void insertDataToDB(Context context,Long uid,Long questionid,String talkContext);
}
