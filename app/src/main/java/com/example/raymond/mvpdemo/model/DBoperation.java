package com.example.raymond.mvpdemo.model;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description:
 */

public interface DBoperation {
//    打开数据库
    void openDB(Context context);

//    插入数据
    void insertData(Context context,long id,String name,String account);

//    查询数据
    void queryData(Context context);

}
