package com.example.raymond.mvpdemo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.com.raymond.downloader.greendao.DaoMaster;
import com.com.raymond.downloader.greendao.LabelDao;
import com.com.raymond.downloader.greendao.UserIconDao;
import com.com.raymond.downloader.greendao.UserInfoDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Raymond 陈徐锋 on 2018/3/13.
 * Email: raymond@hinteen.com
 * Description: 用于数据库升级，在build.gradle 中需手动修改schema 中的version
 * 详细参考：https://github.com/yuweiguocn/GreenDaoUpgradeHelper/blob/master/README_CH.md
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper{
    public MySQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db,ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db,ifExists);
            }
        }, UserInfoDao.class, LabelDao.class, UserIconDao.class);
    }
}
