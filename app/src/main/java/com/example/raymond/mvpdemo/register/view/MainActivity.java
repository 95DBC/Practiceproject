package com.example.raymond.mvpdemo.register.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.delete.view.DeleteAty;
import com.example.raymond.mvpdemo.login.view.LoginAty;
import com.example.raymond.mvpdemo.register.presenter.RegisterableIml;
import com.example.raymond.mvpdemo.update.presenter.UpdateInfoable;
import com.example.raymond.mvpdemo.update.view.UpdateInfoAty;

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
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;

    private RegisterableIml registerIml;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
    }


    @OnClick({R.id.btn_commit, R.id.btn_querry,R.id.btn_delete, R.id.btn_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_commit:
                registerIml = new RegisterableIml(this);
                registerIml.addUser(mContext, Long.parseLong(edtUserID.getText().toString())
                        , edtUserAccount.getText().toString(), edtUserPassword.getText().toString());
                break;
            case R.id.btn_querry:
                Intent intent = new Intent(this, LoginAty.class);
                startActivity(intent);
                break;
            case R.id.btn_delete:
                Intent intent1 = new Intent(this, DeleteAty.class);
                startActivity(intent1);
                break;
            case R.id.btn_update:
                Intent intent2 = new Intent(this, UpdateInfoAty.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
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


}
