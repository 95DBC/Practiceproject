package com.example.raymond.mvpdemo.utils;

import android.util.Log;

import com.example.raymond.mvpdemo.model.bean.RequestUserInfo;
import com.example.raymond.mvpdemo.model.bean.ResponseUserInfo;
import com.example.raymond.mvpdemo.model.net.Httpserviceable;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raymond 陈徐锋 on 2018/3/9.
 * Email: raymond@hinteen.com
 * Description: 封装Retrofit2.3 + RxJava 2.3
 */

public class HttpUtils {

    public void postUserInfoData(String device){

//       使用Gson 创建requestUserInfo 的json 映射
        RequestUserInfo requestUserInfo = new RequestUserInfo();
        requestUserInfo.setDevice(device);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(requestUserInfo);

        String time = String.valueOf(System.currentTimeMillis());
        String methodName = "user_info";
        String API_AUTH_KEY = "digilink.com%$#@!";

        String seed = "" + time + "|" + methodName + "|" + API_AUTH_KEY;
        String auth = MD5Utils.Md5(MD5Utils.Md5(seed));

        //           初始提交的 url
        Map<String,String> mUserMap = new HashMap<String ,String>();
        mUserMap.put("method",methodName);
        mUserMap.put("time",time);
        mUserMap.put("auth",auth);
        mUserMap.put("content",jsonStr);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://seventeen.tech/CI/index.php/Api/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Httpserviceable mHttpserviceable = retrofit.create(Httpserviceable.class);
        Call<String> call = mHttpserviceable.postUserInfo(mUserMap);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("返回的数据",""+response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("测试连接","连接失败");

            }
        });
    }

}
