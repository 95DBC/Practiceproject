package com.example.raymond.mvpdemo.model.net;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/3/7.
 * Email: raymond@hinteen.com
 * Description:
 */

public interface Networkoperationable {

//    获取固件
    void getFirmware();

//    提交用户信息
    void postUserInfo(Context context);

//    提交单日数据
    void postDayData();

//    查询天气
    void queryWeather();

//    查询注册信息
    void queryRegisterInfo();

//    数据恢复
    void recoverData();

//    注册排行榜名字
    void registerRank();

//    查询好友用户信息
    void queryFriendInfo();

//    查询好友步数信息
    void queryFriendStep();

//    随机获得好友
    void randFriend();

//    Follow/点赞/踩
    void fansOperation();

//    消息刷新
    void getRankData();

//    获取世界排行榜数据
    void getRankWorld();

//   获取城市排行榜数据
    void getRankCity();

//    上传运动数据
    void postSportData();

//    上传运动GPS 心率数据
    void postGPSData();


}
