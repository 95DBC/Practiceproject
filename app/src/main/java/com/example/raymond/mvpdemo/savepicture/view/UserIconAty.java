package com.example.raymond.mvpdemo.savepicture.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.savepicture.presenter.AddUserIconIml;

public class UserIconAty extends AppCompatActivity implements UserIconable {
    private Context mContext;
    private AddUserIconIml mAddUserIconIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_icon);
        mAddUserIconIml = new AddUserIconIml(this);
//        mAddUserIconIml.addUserIcon(mContext);
    }

    @Override
    public void getUserIconFromImg() {

    }
}
