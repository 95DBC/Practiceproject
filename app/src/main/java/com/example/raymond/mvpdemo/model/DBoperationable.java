package com.example.raymond.mvpdemo.model;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description:
 */

public interface DBoperationable {
//    打开数据库
    void openDB(Context context);

//    插入数据
    void insertData(Context context,long id,String name,String account);

//    查询数据
    void queryData(Context context);

//    删除数据
    void deleteData(Context context,long id);

//    修改数据
    void updateData(Context context,long id,String name,String password);

}
