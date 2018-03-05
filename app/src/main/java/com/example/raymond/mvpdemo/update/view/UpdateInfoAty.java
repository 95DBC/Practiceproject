package com.example.raymond.mvpdemo.update.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.update.presenter.UpdateIfnoIml;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateInfoAty extends AppCompatActivity implements ShowUpdateInfoable {
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.edt_userID)
    EditText edtUserID;
    @BindView(R.id.edt_userAccount)
    EditText edtUserAccount;
    @BindView(R.id.edt_userPassword)
    EditText edtUserPassword;


    private Context mContext;
    private UpdateIfnoIml updateIfnoIml;

    private String mAccount;
    private String mPssword;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_info_aty);
        ButterKnife.bind(this);

        updateIfnoIml = new UpdateIfnoIml(this);

    }

    private void initDatas() {
        mContext = this;
        if (!edtUserID.getText().toString().equals("")){
        id = Long.parseLong(edtUserID.getText().toString());
        }
        mAccount = edtUserAccount.getText().toString();
        mPssword = edtUserPassword.getText().toString();
    }

    @Override
    public void showUpdateSuccess() {
        Log.e("修改信息","修改成功");

    }

    @Override
    public void showUpdateFaile() {

    }

    @OnClick()
    public void onViewClicked() {

    }

    @OnClick({R.id.btn_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                initDatas();
                updateIfnoIml.updateUserInfo(mContext,id,mAccount,mPssword);
                showUpdateSuccess();
                break;
        }
    }
}
