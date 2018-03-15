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

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> implements View.OnClickListener {

    private List<UserInfo> mUserInfoList;
    private OnItemClickListener mOnItemClickListener = null;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        ViewHolder holder = new ViewHolder(view);
//        将View创建View 注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserInfo mUser = mUserInfoList.get(position);
        holder.userID.setText(String.valueOf(mUser.getId()));
        holder.userAccount.setText(mUser.getUserAccount());
//         将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);

    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }


    /**
     * @param listener
     * 暴露给外部调用者，定义一个设置Listener 的方法（）
     */
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;

    }

    @Override
    public int getItemCount() {
        return mUserInfoList.size();
    }

    public UserInfoAdapter(List<UserInfo> UserInfoList) {
        mUserInfoList = UserInfoList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView userAccount;
        TextView userID;

        public ViewHolder(View itemView) {
            super(itemView);
            userAccount = itemView.findViewById(R.id.tv_user_account);
            userID = itemView.findViewById(R.id.tv_user_id);

        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
