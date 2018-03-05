package com.example.raymond.mvpdemo.update.presenter;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/3/2.
 * Email: raymond@hinteen.com
 * Description:
 */

public interface UpdateInfoable {

//    修改用户信息
    void updateUserInfo(Context context,long id,String name,String password);
}
