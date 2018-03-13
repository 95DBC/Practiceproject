package com.example.raymond.mvpdemo.labelmanager.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.labelmanager.presenter.LabelManagerIml;
import com.example.raymond.mvpdemo.model.bean.Label;
import com.example.raymond.mvpdemo.utils.SharePrefenceHelper;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddLabelAty extends AppCompatActivity implements AddLabelable {

    @BindView(R.id.tv_labelId)
    TextView tvLabelId;
    @BindView(R.id.edt_labelName)
    EditText edtLabelName;
    @BindView(R.id.btn_setLabelName)
    Button btnSetLabelName;
    @BindView(R.id.btn_getLabelID)
    Button btnGetLabelID;

    private LabelManagerIml mLabelManagerIml;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_label);
        ButterKnife.bind(this);

        mContext = this;
    }

    @OnClick({R.id.btn_setLabelName, R.id.btn_getLabelID})
    public void onViewClicked(View view) {
        String labelName = edtLabelName.getText().toString();
        switch (view.getId()) {
            case R.id.btn_setLabelName:
                mLabelManagerIml = new LabelManagerIml(this);
                mLabelManagerIml.addLabel(mContext, labelName);
                break;
            case R.id.btn_getLabelID:
                mLabelManagerIml = new LabelManagerIml(this);
                mLabelManagerIml.getLabelID(mContext, labelName);
                break;
            default:
                break;
        }
    }


    @Override
    public void putLabelID() {
        String LabelJsonStr = (String) SharePrefenceHelper.get(mContext,"label","");
//        Log.e("ID",LabelJsonStr);
        Gson gson = new Gson();
        Label label = gson.fromJson(LabelJsonStr,Label.class);
        tvLabelId.setText(String.valueOf(label.getLabelID()));
    }
}
