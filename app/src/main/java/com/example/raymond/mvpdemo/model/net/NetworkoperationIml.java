package com.example.raymond.mvpdemo.model.net;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

import com.example.raymond.mvpdemo.model.bean.RequestUserInfo;
import com.example.raymond.mvpdemo.model.bean.ResponseUserInfo;
import com.example.raymond.mvpdemo.model.net.Networkoperationable;
import com.example.raymond.mvpdemo.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raymond 陈徐锋 on 2018/3/7.
 * Email: raymond@hinteen.com
 * Description:
 */

public class NetworkoperationIml implements Networkoperationable {
    private String mImei;

    @Override
    public void getFirmware() {

    }

    /**
     * 提交用户数据
     */
    @Override
    public void postUserInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
////           获取手机唯一标识
//            mImei = String.valueOf(telephonyManager.getDeviceId());
//        }
        mImei = "173180349530000";
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.postUserInfoData(mImei);


    }

    @Override
    public void postDayData() {

    }

    @Override
    public void queryWeather() {

    }

    @Override
    public void queryRegisterInfo() {

    }

    @Override
    public void recoverData() {

    }

    @Override
    public void registerRank() {

    }

    @Override
    public void queryFriendInfo() {

    }

    @Override
    public void queryFriendStep() {

    }

    @Override
    public void randFriend() {

    }

    @Override
    public void fansOperation() {

    }

    @Override
    public void getRankData() {

    }

    @Override
    public void getRankWorld() {

    }

    @Override
    public void getRankCity() {

    }

    @Override
    public void postSportData() {

    }

    @Override
    public void postGPSData() {

    }
}
