package com.example.raymond.mvpdemo.query.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.adapter.UserInfoAdapter;
import com.example.raymond.mvpdemo.model.UserInfo;
import com.example.raymond.mvpdemo.query.presenter.QueryIml;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;
import com.example.raymond.mvpdemo.widget.SpacesItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by Raymond 陈徐锋 on 2018/3/6
 * Email:raymond@hinteen.com
 * Description: 主要用于GreenDAO 中条件查询
 */


public class QueryAty extends AppCompatActivity implements ShowQueryInfo {
    @BindView(R.id.floatBtn_refresh)
    FloatingActionButton floatBtnRefresh;
    @BindView(R.id.rlv_user_info)
    RecyclerView rlvUserInfo;
//    @BindView(R.id.swrLay_refresh)
//    SwipeRefreshLayout swrLayRefresh;
    @BindView(R.id.coLay)
    CoordinatorLayout coLay;
    private Context mContext;

    private QueryIml queryIml;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_aty);
        ButterKnife.bind(this);

        mContext = this;
        queryIml = new QueryIml(this);
        queryIml.queryAllUser(mContext);
//        自定义RecyclerView 之间Item 的间隔
        int spacingInPixels = 8;
        rlvUserInfo.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
    }


    /**
     * 在该View 被销毁时调用 remove() 方法，销毁多余数据
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        SharePrefenceHelper.remove(mContext, "UserList");
    }


    @Override
    public void showOnRecycleView(List<UserInfo> userInfoList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rlvUserInfo.setLayoutManager(layoutManager);
        UserInfoAdapter adapter = new UserInfoAdapter(userInfoList);
        rlvUserInfo.setAdapter(adapter);
    }
}
