package com.example.raymond.mvpdemo.network.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.network.presenter.NetworkIml;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetworkAty extends AppCompatActivity implements ShowNetworkable {

    @BindView(R.id.btn_commit)
    Button btnCommit;

    private NetworkIml mNetworkIml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_aty);
        ButterKnife.bind(this);
    }

    @Override
    public void showNetworkInfo() {
        Log.e("View中的测试","提交成功");

    }

    @OnClick(R.id.btn_commit)
    public void onViewClicked() {
        mNetworkIml = new NetworkIml(this);
        mNetworkIml.commitUserInfo(this);
    }
}
