package com.example.raymond.mvpdemo.network.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.model.net.NetworkoperationIml;
import com.example.raymond.mvpdemo.model.net.Networkoperationable;
import com.example.raymond.mvpdemo.network.view.ShowNetworkable;

/**
 * Created by Raymond 陈徐锋 on 2018/3/7.
 * Email: raymond@hinteen.com
 * Description:
 */

public class NetworkIml implements Networkable {
    private ShowNetworkable showNetworkable;
    private Networkoperationable networkoperationable;


    public NetworkIml(ShowNetworkable showNetworkable){
        this.showNetworkable = showNetworkable;
        networkoperationable = new NetworkoperationIml();
    }


    @Override
    public void commitUserInfo(Context context) {
        networkoperationable.postUserInfo(context);
    }

    @Override
    public void updateWatchFirware() {

    }
}
