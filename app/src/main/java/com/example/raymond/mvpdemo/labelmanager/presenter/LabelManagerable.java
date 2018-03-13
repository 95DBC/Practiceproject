package com.example.raymond.mvpdemo.labelmanager.presenter;

import android.content.Context;

/**
 * Created by Raymond 陈徐锋 on 2018/3/12.
 * Email: raymond@hinteen.com
 * Description:
 */

public interface LabelManagerable {
//    添加标签
    void addLabel(Context context,String labelName);

//    获取标签对应的ID
    void getLabelID(Context context,String labelName);


}
