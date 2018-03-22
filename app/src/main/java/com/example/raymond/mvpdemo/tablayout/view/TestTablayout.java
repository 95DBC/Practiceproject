package com.example.raymond.mvpdemo.tablayout.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.adapter.LabelAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestTablayout extends FragmentActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLay_tabLabel)
    TabLayout tabLayTabLabel;

    private LabelAdapter mLabelAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tablayout);
        ButterKnife.bind(this);

        mLabelAdapter = new LabelAdapter(getSupportFragmentManager(),this);
        viewpager.setAdapter(mLabelAdapter);
        tabLayTabLabel.setupWithViewPager(viewpager);
        tabLayTabLabel.setTabMode(TabLayout.MODE_FIXED);

    }
}
