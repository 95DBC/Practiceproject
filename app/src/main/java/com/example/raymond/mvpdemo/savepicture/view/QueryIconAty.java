package com.example.raymond.mvpdemo.savepicture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.savepicture.presenter.AddUserIconIml;
import com.example.raymond.mvpdemo.savepicture.presenter.ShowUserIconIml;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryIconAty extends AppCompatActivity implements QueryIconable {

    @BindView(R.id.iv_usericon)
    ImageView ivUsericon;
    @BindView(R.id.btn_showIcon)
    Button btnShowIcon;


    private Context mContext;
    private ShowUserIconIml mShowUserIconIml;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_aty);
        ButterKnife.bind(this);
        mContext = this;
        mShowUserIconIml = new ShowUserIconIml(this);
        btnShowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowUserIconIml.showUserIcon(mContext, 1);
            }
        });


    }

    @Override
    public void showUserIconOnImg() {
        String userIconStr = (String) SharePrefenceHelper.get(mContext, "userIcon", "");
        byte[] iconByte = userIconStr.getBytes();
        Bitmap imgUserIcon = Bytes2Bimap(iconByte);
        ivUsericon.setImageBitmap(imgUserIcon);

    }

    private Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            Bitmap bit = BitmapFactory.decodeByteArray(b, 0, b.length);
            return bit;
        } else {
            return null;
        }
    }
}
