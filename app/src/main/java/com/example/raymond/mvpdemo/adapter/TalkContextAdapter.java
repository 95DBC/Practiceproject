package com.example.raymond.mvpdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.model.bean.TalkContext;

import java.util.List;

/**
 * Created by Raymond 陈徐锋 on 2018/4/24.
 * Email: raymond@hinteen.com
 * Description:
 */
public class TalkContextAdapter extends RecyclerView.Adapter<TalkContextAdapter.ViewHolder> implements View.OnClickListener {

    private List<TalkContext> mTalkCotextList;
    private OnItemClickListener mOnItemClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_talk, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TalkContext mTalkContext = mTalkCotextList.get(position);
        holder.talkContext.setText(mTalkContext.getTalkContext());
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mTalkCotextList.size();
    }

    public TalkContextAdapter(List<TalkContext> talkContextList) {
        mTalkCotextList = talkContextList;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener !=null){

            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView talkContext;

        public ViewHolder(View itemView) {
            super(itemView);

            talkContext = itemView.findViewById(R.id.tv_talkContext);
        }
    }
}
