package com.example.raymond.mvpdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.model.bean.UserInfo;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/3/6.
 * Email: raymond@hinteen.com
 * Description: 用户适配器，整合项目时，可改为蓝牙设备的适配器
 * 下次可考虑创建个万能的RecyclerAdapter
 */

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder>{

    private List<UserInfo> mUserInfoList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserInfo mUser = mUserInfoList.get(position);
        holder.userID.setText(String.valueOf(mUser.getId()));
        holder.userAccount.setText(mUser.getUserAccount());

    }

    @Override
    public int getItemCount() {
        return mUserInfoList.size();
    }

    public UserInfoAdapter (List<UserInfo> UserInfoList){
        mUserInfoList = UserInfoList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView userAccount;
        TextView userID;

        public ViewHolder(View itemView) {
            super(itemView);
            userAccount = itemView.findViewById(R.id.tv_user_account);
            userID = itemView.findViewById(R.id.tv_user_id);

        }
    }
}
