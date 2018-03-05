package com.example.raymond.mvpdemo.delete.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.delete.presenter.DeleteIml;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeleteAty extends AppCompatActivity implements ShowDeleteInfo {

    @BindView(R.id.btn_deleteUser)
    Button btnDeleteUser;

    private Context mContext;
    private DeleteIml deleteIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_aty);
        ButterKnife.bind(this);

        mContext = this;
        deleteIml = new DeleteIml(this);
    }

    @Override
    public void showDeleteInfo() {
        Log.e("删除操作","删除成功");

    }

    @OnClick(R.id.btn_deleteUser)
    public void onViewClicked() {
        // TODO: 2018/3/5 这里可考虑加入删除临时对话里的内容
        deleteIml.delteUser(mContext,2L);
        showDeleteInfo();
    }
}
