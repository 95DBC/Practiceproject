package com.example.raymond.mvpdemo.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.base.MyApplication;
import com.example.raymond.mvpdemo.login.presenter.LoginIml;
import com.example.raymond.mvpdemo.model.Session;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Create by Raymond 陈徐锋 on 2018/3/2
 * Email:raymond@hinteen.com
 * Description:
 */

public class LoginAty extends AppCompatActivity implements ShowLoginInfo {

    @BindView(R.id.tv_current_user)
    TextView tvCurrentUser;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private Context mContext;
    private LoginIml mLoginIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_aty);
        ButterKnife.bind(this);

        mContext = this;
        mLoginIml = new LoginIml(this);

    }

    @Override
    public void showLoginInfo() {
        Session session = MyApplication.appSingleInstance().getSession();
        tvCurrentUser.setText(session.getmUserAccount());
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mLoginIml.queryUser(mContext);
        showLoginInfo();
    }
}
