package com.example.raymond.mvpdemo.tinypng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.raymond.mvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TinyPngTest2 extends AppCompatActivity {

    @BindView(R.id.iv_test2_tinypng)
    ImageView ivTest2Tinypng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiny_png_test2);
        ButterKnife.bind(this);
    }
}
