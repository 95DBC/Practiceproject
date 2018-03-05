package com.example.raymond.mvpdemo.model;

import android.content.Context;
import android.util.Log;

import com.com.raymond.downloader.greendao.DaoMaster;
import com.com.raymond.downloader.greendao.DaoSession;
import com.com.raymond.downloader.greendao.UserInfoDao;
import com.example.raymond.mvpdemo.base.MyApplication;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description: Dao 层数数据库操作实现类
 */

public class DBoperationableIml implements DBoperationable {
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private UserInfoDao mUserInfoDao;

    /**
     * @param context
     * 打开数据库
     */
    @Override
    public void openDB(Context context) {
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context,"user.db",null);
        mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
        mUserInfoDao = mDaoSession.getUserInfoDao();
    }

    /**
     * @param context
     * @param id
     * @param name
     * @param password
     * 插入数据
     */
    @Override
    public void insertData(Context context,long id,String name,String password) {
        openDB(context);
        UserInfo userinfo = new UserInfo(id,name,password);
        mUserInfoDao.insert(userinfo);
    }

    /**
     * @param context
     * 查询用户
     */
    @Override
    public void queryData(Context context) {
        openDB(context);
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder().list();
        String userAccount =  userInfoList.get(0).getUserAccount();
        long userID = userInfoList.get(0).getId();

        /*创建临时对话，用于存放在线用户*/
        Session session = new Session(userAccount,userID);
        MyApplication.appSingleInstance().setSession(session);

        Log.e("测试",""+ session.getmUserAccount());

    }

    /**
     * @param context
     * @param id
     * 删除数据
     */
    @Override
    public void deleteData(Context context, long id) {
        openDB(context);
        mUserInfoDao.deleteByKey(id);

    }

    /**
     * @param context
     * @param id
     * @param name
     * @param password
     * 更新用户数据
     */
    @Override
    public void updateData(Context context, long id,String name, String password) {
        openDB(context);
        UserInfo userInfo = new UserInfo(id,name,password);
        mUserInfoDao.insertOrReplace(userInfo);
    }


}
