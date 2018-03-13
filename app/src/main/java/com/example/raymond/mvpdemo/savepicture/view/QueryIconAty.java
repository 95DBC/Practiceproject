package com.example.raymond.mvpdemo.savepicture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.savepicture.presenter.AddUserIconIml;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryIconAty extends AppCompatActivity implements QueryIconable {
    @BindView(R.id.iv_usericon)
    ImageView ivUsericon;
    private AddUserIconIml mAddUserIconIml;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_aty);
        ButterKnife.bind(this);
        mAddUserIconIml = new AddUserIconIml(this);
        mAddUserIconIml.showUserIcon(mContext, 1);
        mContext = this;
    }

    @Override
    public void showUserIconOnImg() {
        String userIconStr = (String) SharePrefenceHelper.get(mContext,"userIcon",null);
        byte[] iconByte = userIconStr.getBytes();

        Bitmap imgUserIcon = BitmapFactory.decodeByteArray(iconByte, 0, iconByte.length);
        ivUsericon.setImageBitmap(imgUserIcon);
    }
}
