package com.example.raymond.mvpdemo.userdetail.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.userdetail.presenter.UserDetailIml;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailAty extends AppCompatActivity implements ShowUserDetialable {

    @BindView(R.id.tv_user_id)
    TextView tvUserId;
    @BindView(R.id.tv_user_account)
    TextView tvUserAccount;
    private Context mContext;
    private UserDetailIml mUserDetailIml;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detai);
        ButterKnife.bind(this);

        mContext = this;
        mUserDetailIml = new UserDetailIml(this);
        mUserDetailIml.queryUser(mContext);
    }

    @Override
    public void getBundleData(Context context) {
        Bundle bundle = this.getIntent().getExtras();
        String user_id = bundle.getString("userid");
        String user_account = bundle.getString("useraccount");
        tvUserAccount.setText(user_id);
        tvUserId.setText(user_account);
    }
}
