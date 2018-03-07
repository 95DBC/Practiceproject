package com.example.raymond.mvpdemo.query.presenter;


import android.content.Context;

import com.example.raymond.mvpdemo.base.MyApplication;
import com.example.raymond.mvpdemo.model.DBoperationable;
import com.example.raymond.mvpdemo.model.DBoperationableIml;
import com.example.raymond.mvpdemo.model.UserInfo;
import com.example.raymond.mvpdemo.query.view.ShowQueryInfo;

import java.util.List;
import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Raymond 陈徐锋 on 2018/3/5.
 * Email: raymond@hinteen.com
 * Description: 这里访问整个数据库，属于耗时操作，我们用RxJava2
 * 来解决问题 这里的Observerable 不支持被压，如果我们数据用的过多的话
 * 用Flowable
 */

public class QueryIml implements Queryable {
    private ShowQueryInfo showQueryInfo;
    private DBoperationable dBoperationable;

    private List<UserInfo> mUserInfoList;
    private static Disposable mDisposable;

    public QueryIml(ShowQueryInfo showQueryInfo) {
        this.showQueryInfo = showQueryInfo;
        dBoperationable = new DBoperationableIml();
    }

    @Override
    public void queryAllUser(Context context) {
        dBoperationable.openDB(context);
        dBoperationable.queryAll();

//        做一个定时器，让数据库查询完数据后再进行View 的更新
        Observable.timer(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                mUserInfoList = MyApplication.appSingleInstance().getUserInfoList();
                showQueryInfo.showOnRecycleView(mUserInfoList);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });







    }
}
