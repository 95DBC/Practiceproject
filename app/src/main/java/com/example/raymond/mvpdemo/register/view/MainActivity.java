package com.example.raymond.mvpdemo.register.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.base.PermissionsActivity;
import com.example.raymond.mvpdemo.delete.view.DeleteAty;
import com.example.raymond.mvpdemo.labelmanager.view.AddLabelAty;
import com.example.raymond.mvpdemo.login.view.LoginAty;
import com.example.raymond.mvpdemo.network.view.NetworkAty;
import com.example.raymond.mvpdemo.query.view.QueryAty;
import com.example.raymond.mvpdemo.register.presenter.RegisterableIml;
import com.example.raymond.mvpdemo.savepicture.view.UserIconAty;
import com.example.raymond.mvpdemo.tinypng.TinyPngTest;
import com.example.raymond.mvpdemo.update.view.UpdateInfoAty;
import com.example.raymond.mvpdemo.utils.PermissionsChecker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ShowRegisterInfo {

    @BindView(R.id.edt_userID)
    EditText edtUserID;
    @BindView(R.id.edt_userAccount)
    EditText edtUserAccount;
    @BindView(R.id.edt_userPassword)
    EditText edtUserPassword;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.btn_querry)
    Button btnQuerry;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.btn_query_witch_key)
    Button btnQueryWitchKey;
    @BindView(R.id.btn_network)
    Button btnNetwork;
    @BindView(R.id.testTinyPng)
    Button testTinyPng;
    @BindView(R.id.btn_testGreenDAOID)
    Button btnTestGreenDAOID;
    @BindView(R.id.btn_picture)
    Button btnPicture;


    private RegisterableIml registerIml;
    private Context mContext;
    private static final int REQUEST_CODE = 0; // 请求码

    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.MODIFY_AUDIO_SETTINGS,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_LOGS,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE
    };

    private PermissionsChecker mPermissionsChecker; // 权限检测器


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        mPermissionsChecker = new PermissionsChecker(this);
    }

    protected void onResume() {
        super.onResume();

        // 缺少权限时, 进入权限配置页面
//        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
//            startPermissionsActivity();
//        }
    }

//    private void startPermissionsActivity() {
//        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }


    @OnClick({R.id.btn_commit, R.id.btn_querry, R.id.btn_delete, R.id.btn_update
            , R.id.btn_query_witch_key, R.id.btn_network, R.id.testTinyPng,R.id.btn_testGreenDAOID,R.id.btn_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_commit:
                registerIml = new RegisterableIml(this);
                registerIml.addUser(mContext, Long.parseLong(edtUserID.getText().toString())
                        , edtUserAccount.getText().toString(), edtUserPassword.getText().toString());
                break;
            case R.id.btn_querry:
                Intent intent = new Intent(this, LoginAty.class);
                startActivity(intent);
                break;
            case R.id.btn_delete:
                Intent intent1 = new Intent(this, DeleteAty.class);
                startActivity(intent1);
                break;
            case R.id.btn_update:
                Intent intent2 = new Intent(this, UpdateInfoAty.class);
                startActivity(intent2);
                break;
            case R.id.btn_query_witch_key:
                Intent intent3 = new Intent(this, QueryAty.class);
                startActivity(intent3);
                break;
            case R.id.btn_network:
                Intent intent4 = new Intent(this, NetworkAty.class);
                startActivity(intent4);
                break;
            case R.id.testTinyPng:
                Intent intent5 = new Intent(this, TinyPngTest.class);
                startActivity(intent5);
                break;
            case R.id.btn_testGreenDAOID:
                Intent intent6 = new Intent(this, AddLabelAty.class);
                startActivity(intent6);
                break;
            case R.id.btn_picture:
                Intent intent7 = new Intent(this, UserIconAty.class);
                startActivity(intent7);
            default:
                break;
        }
    }

    @Override
    public void showSuccess(Context context) {
        Log.e("Show", "Success");
    }

    @Override
    public void showFaile(Context context) {
        Log.e("Show", "Fail");
    }

    @Override
    public void insertDataing(Context context) {
        Log.e("Show", "Inserting");
    }


}
