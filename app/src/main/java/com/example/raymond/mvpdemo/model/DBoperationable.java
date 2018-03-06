package com.example.raymond.mvpdemo.model;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description: DAO 层数据库库方法类
 */

public interface DBoperationable {
    //    打开数据库
    void openDB(Context context);

    //    插入数据
    void insertData(Context context, long id, String name, String account);

    //    查询数据
    void queryData(Context context);

    //    删除数据
    void deleteData(Context context, long id);

    //    修改数据
    void updateData(Context context, long id, String name, String password);

    /**
     * 下面的内容为 GreenDAO 的各类条件查询
     */

//    查询所有
    void queryAll();

    //    eq: equal 精确查询
    void queryEq(Context context, long id, String name);

    //    notEq: not equal 精确查询
    void queryNotEq(Context context, long id, String name);

    //   like  模糊查询
    void queryLike(Context context, long id, String name);

    //   between 区间查询 年龄在开始ID到结束ID之间
    void queryBetween(Context context ,long sid, long eid,String name);

    //    gt: greater than 半开区间查询，年龄大于18
    void queryGt(Context context,long id,String name);

    //    ge:greater equal 半封闭区间查询，年龄大于或者等于18
    void queryGe(Context context,long id,String name);

    //    lt: less than 半开区间查询，年龄小于18
    void queryLt(Context context,long id,String name);

    //    le: less equal 半封闭区间查询，年龄小于或者等于18
    void queryLe(Context context,long id,String name);

    //    名字以jackie开头，年龄升序排序
    void queryLikeAsc(Context context,long id,String name);

    //    名字以jackie开头，年龄降序排序
    void queryLikeDesc(Context context,long id,String name);


}
