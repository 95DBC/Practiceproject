package com.example.raymond.mvpdemo.model.net;

import com.example.raymond.mvpdemo.model.bean.Data;
import com.example.raymond.mvpdemo.model.bean.ResponseUserInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Raymond 陈徐锋 on 2018/3/9.
 * Email: raymond@hinteen.com
 * Description: 网络请求接口
 */

public interface Httpserviceable {

    @FormUrlEncoded
    @POST("/")
// TODO: 2018/3/9  暂时不知道返回的实体中的格式，先将返回实体转化为String 类型在做修改
    Call<String> postUserInfo(@FieldMap Map<String ,String > map);
}
