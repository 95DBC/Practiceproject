package com.example.raymond.mvpdemo.query.view;

import com.example.raymond.mvpdemo.model.UserInfo;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/3/5.
 * Email: raymond@hinteen.com
 * Description: 将用户信息显示在RecyclerView 上
 */

public interface ShowQueryInfo {
//    将用户信息显示在RecyclerView 上
    void showOnRecycleView(List<UserInfo> userInfoList);
}
