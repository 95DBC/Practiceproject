package com.example.raymond.mvpdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.raymond.mvpdemo.tablayout.view.ChoicedFragment;
import com.example.raymond.mvpdemo.tablayout.view.ChoicingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/3/22.
 * Email: raymond@hinteen.com
 * Description:
 */

public class LabelAdapter extends FragmentPagerAdapter{
    private Context context;
    private String[] mTitles= new String[]{"已选","未选"};
    private List<Fragment> list = new ArrayList<Fragment>();



    public LabelAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ChoicedFragment.newInstance();
            case 1:
                return ChoicingFragment.newInstance();
        }
        return  ChoicedFragment.newInstance();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}
