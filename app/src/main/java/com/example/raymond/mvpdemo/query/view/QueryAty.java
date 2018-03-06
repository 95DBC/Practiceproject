package com.example.raymond.mvpdemo.query.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;

/**
 *  Create by Raymond 陈徐锋 on 2018/3/6
 *  Email:raymond@hinteen.com
 *  Description: 主要用于GreenDAO 中条件查询
 */
public class QueryAty extends AppCompatActivity implements ShowQueryInfo{
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_aty);
        mContext = this;
    }

    /**
     * 在该View 被销毁时调用 remove() 方法，销毁多余数据
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharePrefenceHelper.remove(mContext,"UserList");
    }

    @Override
    public void showOnRecycleView() {

    }
}
