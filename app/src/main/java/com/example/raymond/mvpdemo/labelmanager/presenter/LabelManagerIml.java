package com.example.raymond.mvpdemo.labelmanager.presenter;

import android.content.Context;

import com.example.raymond.mvpdemo.labelmanager.view.AddLabelable;
import com.example.raymond.mvpdemo.model.dao.DBoperationIml;
import com.example.raymond.mvpdemo.model.dao.DBoperationable;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;

/**
 * Created by Raymond 陈徐锋 on 2018/3/12.
 * Email: raymond@hinteen.com
 * Description: 该类用于测试GreeDAO 其ID 是否为自增
 */

public class LabelManagerIml implements LabelManagerable {

    private DBoperationable mDBoperationable;
    private AddLabelable mAddLabelable;

    public LabelManagerIml(AddLabelable mAddLabelable) {
        this.mAddLabelable = mAddLabelable;
        mDBoperationable = new DBoperationIml();
    }

    @Override
    public void addLabel(Context context, String labelName) {
        mDBoperationable.openDB(context);
        mDBoperationable.insertLabel(context, labelName);
    }

    @Override
    public void getLabelID(Context context,String labelName) {
        mDBoperationable.openDB(context);
        mDBoperationable.queryLabel(context,labelName);

        mAddLabelable.putLabelID();
    }
}
