package com.example.raymond.mvpdemo.tinypng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.raymond.mvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TinyPngTest extends AppCompatActivity {

    @BindView(R.id.iv_test_tinypng)
    ImageView ivTestTinypng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiny_png_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_test_tinypng)
    public void onViewClicked() {
        Intent intent = new Intent(this,TinyPngTest2.class);
        startActivity(intent);
    }
}
