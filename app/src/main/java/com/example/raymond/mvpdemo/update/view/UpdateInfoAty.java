package com.example.raymond.mvpdemo.update.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.update.presenter.UpdateIfnoIml;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateInfoAty extends AppCompatActivity implements ShowUpdateInfoable {
    @BindView(R.id.btn_update)
    Button btnUpdate;
    private Context mContext;
    private UpdateIfnoIml updateIfnoIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_info_aty);
        ButterKnife.bind(this);
    }

    @Override
    public void showUpdateSuccess() {

    }

    @Override
    public void showUpdateFaile() {

    }

    @OnClick(R.id.btn_update)
    public void onViewClicked() {
    }
}
