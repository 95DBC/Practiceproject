package com.example.raymond.mvpdemo.base;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.raymond.mvpdemo.model.Session;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;
import com.google.gson.Gson;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Raymond 陈徐锋 on 2018/3/2.
 * Email: raymond@hinteen.com
 * Description: 创建用于存放全局变量的
 */

public class MyApplication extends Application {

    private static MyApplication sApp;
    private Session mSession;
    private boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        /**
         * 初始化Bugly 设置
         * 可直接在代码设置，或直接在Mainfest.xml 中进行配置
         * 详细可参考如下文档：https://bugly.qq.com/docs/user-guide/instruction-manual-android/?v=20180119105842
         */
        Context context = getApplicationContext();
        // 获取当前包名
        String packageName = context.getPackageName();
        // 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // 初始化Bugly
        CrashReport.initCrashReport(context, "4f9888c39a", isDebug, strategy);
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }


    /**
     * @return 返回MyApplication 实例
     */
    public static MyApplication appSingleInstance() {
        return sApp;
    }

    /**
     * 获取当前对话实例
     * @return 返回一个Session
     */
    public Session getSession() {
        if (mSession == null) {
            String sessionJsonStr = (String) SharePrefenceHelper.get(this, "Session", "");
            Gson gson = new Gson();
            mSession = gson.fromJson(sessionJsonStr, Session.class);
        }
        return mSession;
    }

    /**
     * 需要传入
     * @param session
     */
    public void setSession(Session session) {
        this.mSession = session;
        Gson gson = new Gson();
        String sessionJsonStr = gson.toJson(session);
        SharePrefenceHelper.put(this, "Session", sessionJsonStr);
    }

}
