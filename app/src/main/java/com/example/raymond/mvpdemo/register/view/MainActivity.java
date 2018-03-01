package com.example.raymond.mvpdemo.register.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.register.presenter.RegisterIml;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ShowRegisterInfo {

    @BindView(R.id.edt_userID)
    EditText edtUserID;
    @BindView(R.id.edt_userAccount)
    EditText edtUserAccount;
    @BindView(R.id.edt_userPassword)
    EditText edtUserPassword;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.btn_querry)
    Button btnQuerry;

    private RegisterIml registerIml;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = this;


    }


    @Override
    public void showSuccess(Context context) {
        Log.e("Show", "Success");
    }

    @Override
    public void showFaile(Context context) {
        Log.e("Show", "Fail");
    }

    @Override
    public void insertDataing(Context context) {
        Log.e("Show", "Inserting");
    }


    @OnClick({R.id.btn_commit, R.id.btn_querry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_commit:

                registerIml = new RegisterIml(this);
                registerIml.addUser(mContext, Long.parseLong(edtUserID.getText().toString())
                        , edtUserAccount.getText().toString(), edtUserPassword.getText().toString());
                registerIml.CommitUserInfoResult(this);

                break;
            case R.id.btn_querry:
                registerIml = new RegisterIml(this);
                registerIml.queryUser(this);
                break;
        }
    }
}
