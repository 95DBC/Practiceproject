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
 * 这里除了前五个方法会以实例呈现，其他条件查询不铺开
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

    /**
     * 查询所有用户
     */
    @Override
    public void queryAll() {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder().list();

    }

    /**
     * @param context
     * @param id
     * @param name
     * eq: 精确查询,查询单一匹配用户
     */
    @Override
    public void queryEq(Context context, long id, String name) {
        UserInfo userInfo = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.eq(name)).unique();
    }

    /**
     * @param context
     * @param id
     * @param name
     *     notEq: not equal 精确查询
     */
    @Override
    public void queryNotEq(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.notEq(name)).list();

    }

    /**
     * @param context
     * @param id
     * @param name
     *  模糊查询：可以通过通赔符"%" 进行模糊搜索
     */
    @Override
    public void queryLike(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.like(name+"%")).list();

    }

    /**
     * @param context
     * @param sid 开始id
     * @param eid 结束id
     * @param name 用户账号
     * 区间搜索：开始ID 和 结束ID 之间
     */
    @Override
    public void queryBetween(Context context, long sid, long eid,String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.between(sid,eid)).list();

    }

    /**
     * @param context
     * @param id
     * @param name
     * gt: greater than 半开区间查询，大于输入id
     */
    @Override
    public void queryGt(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.gt(id)).list();
    }

    /**
     * @param context
     * @param id
     * @param name
     * ge: greater equal 半封闭区间查询，id 值大于或者等于输入id
     */
    @Override
    public void queryGe(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.ge(id)).list();

    }

    /**
     * @param context
     * @param id
     * @param name
     * lt: less than 半开区间查询，id小于输入id
     */
    @Override
    public void queryLt(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.lt(id)).list();

    }

    /**
     * @param context
     * @param id
     * @param name
     * le: less equal 半封闭区间查询，id小于或者等于输入id
     */
    @Override
    public void queryLe(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.le(id)).list();

    }

    /**
     * @param context
     * @param id
     * @param name
     * 增序排列
     */
    @Override
    public void queryLikeAsc(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.like(name+"%"))
                .orderAsc(UserInfoDao.Properties.Id).list();

    }

    /**
     * @param context
     * @param id
     * @param name
     * 降序排列
     */
    @Override
    public void queryLikeDesc(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.like(name+"%"))
                .orderDesc(UserInfoDao.Properties.Id).list();

    }


}
