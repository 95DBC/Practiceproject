package com.example.raymond.mvpdemo.model;

import android.content.Context;
import android.util.Log;

import com.com.raymond.downloader.greendao.DaoMaster;
import com.com.raymond.downloader.greendao.DaoSession;
import com.com.raymond.downloader.greendao.UserInfoDao;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description:
 */

public class DBoperationIml implements DBoperation {
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private UserInfoDao mUserInfoDao;

    @Override
    public void openDB(Context context) {
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context,"user.db",null);
        mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
        mUserInfoDao = mDaoSession.getUserInfoDao();
    }

    @Override
    public void insertData(Context context,long id,String name,String password) {
        openDB(context);
        UserInfo userinfo = new UserInfo(id,name,password);
        mUserInfoDao.insert(userinfo);
    }

    @Override
    public void queryData(Context context) {
        openDB(context);
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder().list();
        Log.e("第一数据为",""+userInfoList.get(0).getUserAccount());

    }

}
