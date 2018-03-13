package com.example.raymond.mvpdemo.savepicture.presenter;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/3/13.
 * Email: raymond@hinteen.com
 * Description:
 */

public interface AddUserIconable {

//    添加用户头像
    void addUserIcon(Context context,String userIcon);

//    查看用户头像
    void showUserIcon(Context context,long iconId);
}
