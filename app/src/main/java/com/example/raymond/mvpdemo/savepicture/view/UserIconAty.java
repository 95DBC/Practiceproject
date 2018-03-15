package com.example.raymond.mvpdemo.savepicture.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.savepicture.presenter.AddUserIconIml;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;

public class UserIconAty extends AppCompatActivity implements UserIconable {
    private Context mContext;
    private AddUserIconIml mAddUserIconIml;

    private ImageView iv_userIcon;
    private Button btn_querry;
    private Button btn_commitpicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_icon);
        mAddUserIconIml = new AddUserIconIml(this);
        mContext = this;
        btn_querry = findViewById(R.id.btn_queryPicture);
        btn_commitpicture = findViewById(R.id.btn_commitpicture);

        btn_querry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserIconAty.this,QueryIconAty.class);
                startActivity(intent);
            }
        });

        btn_commitpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_userIcon = findViewById(R.id.user_icon);
                iv_userIcon.setImageResource(R.drawable.cn);
                iv_userIcon.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                        , View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                iv_userIcon.layout(0, 0, iv_userIcon.getMeasuredWidth(), iv_userIcon.getMeasuredHeight());
                iv_userIcon.buildDrawingCache();

                iv_userIcon.setDrawingCacheEnabled(true);
                Bitmap bitmap = iv_userIcon.getDrawingCache();

                byte[] bytesUserIcon = Bitmap2Bytes(bitmap);
                String iconStr = new String(bytesUserIcon);
                iv_userIcon.setDrawingCacheEnabled(false);

//        SharePrefenceHelper.put(mContext,"userIcon",iconStr);
                mAddUserIconIml.addUserIcon(mContext,iconStr);
            }
        });
    }

    @Override
    public void getUserIconFromImg() {
        Log.e("插入头像：","成功");

    }
    private byte[] Bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
