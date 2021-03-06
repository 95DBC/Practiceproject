package com.example.raymond.mvpdemo.model.dao;

import android.content.Context;
import android.util.Log;

import com.com.raymond.downloader.greendao.DaoMaster;
import com.com.raymond.downloader.greendao.DaoSession;
import com.com.raymond.downloader.greendao.LabelDao;
import com.com.raymond.downloader.greendao.TalkContextDao;
import com.com.raymond.downloader.greendao.UserIconDao;
import com.com.raymond.downloader.greendao.UserInfoDao;
import com.example.raymond.mvpdemo.base.MyApplication;
import com.example.raymond.mvpdemo.model.bean.Label;
import com.example.raymond.mvpdemo.model.bean.Session;
import com.example.raymond.mvpdemo.model.bean.TalkContext;
import com.example.raymond.mvpdemo.model.bean.UserIcon;
import com.example.raymond.mvpdemo.model.bean.UserInfo;
import com.example.raymond.mvpdemo.utils.MySQLiteOpenHelper;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description: Dao 层数数据库操作实现类
 * 这里除了前五个方法会以实例呈现，其他条件查询不铺开
 */

public class DBoperationIml implements DBoperationable {
//    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private UserInfoDao mUserInfoDao;
    private LabelDao mLabelDao;
    private UserIconDao mUserIconDao;
    private TalkContextDao mTalkContextDao;

    /**
     * @param context 初始化并打开数据库
     */
    @Override
    public void openDB(Context context) {
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(context, "user.db",null);
        mDaoMaster = new DaoMaster(mMySQLiteOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
        mUserInfoDao = mDaoSession.getUserInfoDao();
        mLabelDao = mDaoSession.getLabelDao();
        mUserIconDao= mDaoSession.getUserIconDao();
        mTalkContextDao = mDaoSession.getTalkContextDao();

    }

    /**
     * @param context
     * @param id
     * @param name
     * @param password 插入数据
     */
    @Override
    public void insertData(Context context, long id, String name, String password) {
        openDB(context);
        UserInfo userinfo = new UserInfo(id, name, password);
        mUserInfoDao.insert(userinfo);
    }

    /**
     * @param context 查询用户
     */
    @Override
    public void queryData(Context context) {
        openDB(context);
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder().list();
        String userAccount = userInfoList.get(0).getUserAccount();
        long userID = userInfoList.get(0).getId();

        /*创建临时对话，用于存放在线用户*/
        Session session = new Session(userAccount, userID);
        MyApplication.appSingleInstance().setSession(session);

        Log.e("测试", "" + session.getmUserAccount());

    }

    /**
     * @param context
     * @param id      删除数据
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
     * @param password 更新用户数据
     */
    @Override
    public void updateData(Context context, long id, String name, String password) {
        openDB(context);
        UserInfo userInfo = new UserInfo(id, name, password);
        mUserInfoDao.insertOrReplace(userInfo);
    }

    /**
     * @param context
     * @param labelName 插入标签
     */
    @Override
    public void insertLabel(Context context, String labelName) {
        openDB(context);
        Label label = new Label(null,labelName);
        mLabelDao.insertOrReplace(label);
    }

    /**
     * @param context
     * @param labelName 获取标签
     */
    @Override
    public void queryLabel(Context context, String labelName) {
        openDB(context);
        Label label = mLabelDao.queryBuilder().where(LabelDao.Properties.LabelName.like(labelName)).unique();
        Gson gson = new Gson();
        String labelJsonStr = gson.toJson(label);
        SharePrefenceHelper.put(context, "label", labelJsonStr);
    }

    /**
     * @param context
     * @param iconId
     * 根据ID 查询Icon
     */
    @Override
    public void queryUserIcon(Context context, long iconId) {
        openDB(context);
        UserIcon userIcon = mUserIconDao.queryBuilder().where(UserIconDao.Properties.IconID.eq(1)).unique();
        String  userIconData = userIcon.getUserIcon();
        SharePrefenceHelper.put(context,"userIcon",userIconData);
    }

    /**
     * @param context
     * @param userIcon
     * 插入用户头像
     */

    @Override
    public void insertUserIcon(Context context, String userIcon) {
        openDB(context);
        UserIcon userIcon1 = new UserIcon(null,userIcon);
        mUserIconDao.save(userIcon1);
    }


    /**
     * 查询所有用户
     */
    @Override
    public void queryAll() {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder().list();
        MyApplication.appSingleInstance().setUserInfoList(userInfoList);
    }


    /**
     * @param context
     * 查询所有讨论
     */
    @Override
    public void queryAllTalkText(Context context) {
        openDB(context);
        List<TalkContext> talkContextList =mTalkContextDao.queryBuilder().list();
        MyApplication.appSingleInstance().mTalkContextList = talkContextList;

    }

    /**
     * @param context
     * @param talkContext
     * 存储讨论内容
     */
    @Override
    public void insertTalkContext(Context context, Long uid ,Long questionid ,String talkContext) {
        openDB(context);
        TalkContext mTalkContext = new TalkContext(null,uid,questionid,talkContext);
        mTalkContextDao.save(mTalkContext);
    }

    /**
     * @param context
     * @param id
     * @param name    eq: 精确查询,查询单一匹配用户
     */
    @Override
    public void queryEq(Context context, long id, String name) {
        UserInfo userInfo = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.eq(name)).unique();
    }

    /**
     * @param context
     * @param id
     * @param name    notEq: not equal 精确查询
     */
    @Override
    public void queryNotEq(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.notEq(name)).list();

    }

    /**
     * @param context
     * @param id
     * @param name    模糊查询：可以通过通赔符"%" 进行模糊搜索
     */
    @Override
    public void queryLike(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.like(name + "%")).list();

    }

    /**
     * @param context
     * @param sid     开始id
     * @param eid     结束id
     * @param name    用户账号
     *                区间搜索：开始ID 和 结束ID 之间
     */
    @Override
    public void queryBetween(Context context, long sid, long eid, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.between(sid, eid)).list();

    }

    /**
     * @param context
     * @param id
     * @param name    gt: greater than 半开区间查询，大于输入id
     */
    @Override
    public void queryGt(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.gt(id)).list();
    }

    /**
     * @param context
     * @param id
     * @param name    ge: greater equal 半封闭区间查询，id 值大于或者等于输入id
     */
    @Override
    public void queryGe(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.ge(id)).list();

    }

    /**
     * @param context
     * @param id
     * @param name    lt: less than 半开区间查询，id小于输入id
     */
    @Override
    public void queryLt(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.lt(id)).list();

    }

    /**
     * @param context
     * @param id
     * @param name    le: less equal 半封闭区间查询，id小于或者等于输入id
     */
    @Override
    public void queryLe(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.Id.le(id)).list();

    }

    /**
     * @param context
     * @param id
     * @param name    增序排列
     */
    @Override
    public void queryLikeAsc(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.like(name + "%"))
                .orderAsc(UserInfoDao.Properties.Id).list();

    }

    /**
     * @param context
     * @param id
     * @param name    降序排列
     */
    @Override
    public void queryLikeDesc(Context context, long id, String name) {
        List<UserInfo> userInfoList = mUserInfoDao.queryBuilder()
                .where(UserInfoDao.Properties.UserAccount.like(name + "%"))
                .orderDesc(UserInfoDao.Properties.Id).list();

    }


}
