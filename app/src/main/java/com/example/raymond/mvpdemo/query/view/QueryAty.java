package com.example.raymond.mvpdemo.query.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.adapter.UserInfoAdapter;
import com.example.raymond.mvpdemo.model.bean.UserInfo;
import com.example.raymond.mvpdemo.query.presenter.QueryIml;
import com.example.raymond.mvpdemo.userdetail.view.UserDetailAty;
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
    @BindView(R.id.tb_toolbar)
    Toolbar tbToolbar;

    private Context mContext;

    private QueryIml queryIml;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iv_more:

                break;
            case R.id.iv_share:

                break;
            default:
                break;
        }
        return true;
    }

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

        rlvUserInfo.setNestedScrollingEnabled(false);


        setSupportActionBar(tbToolbar);
        tbToolbar.setNavigationIcon(R.drawable.ic_back);
        tbToolbar.setLogo(R.mipmap.ic_launcher);
        tbToolbar.setTitle("中国人");
        tbToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

//        创建item 点击事件
        adapter.setOnItemClickListener(new UserInfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                TextView iv_userId = view.findViewById(R.id.tv_user_id);
                TextView iv_userAccount = view.findViewById(R.id.tv_user_account);
                String mUserId = iv_userId.getText().toString();
                String mUserAccount = iv_userAccount.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("userid", mUserId);
                bundle.putString("useraccount", mUserAccount);

                Intent intent = new Intent(QueryAty.this, UserDetailAty.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
