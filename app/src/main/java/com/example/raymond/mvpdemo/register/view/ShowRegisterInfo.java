package com.example.raymond.mvpdemo.register.view;


import android.content.Context;

/**
 * ShowRegisterInfo 接口
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description: 该接口用于Veiw 层各类View 操作方法的剥离
 */

public interface ShowRegisterInfo {
//    插入数据成功
    void showSuccess(Context context);

//    插入数据失败
    void showFaile(Context context);

//    插入数据中
    void insertDataing(Context context);


}
