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
public class TalkContextAdapter extends RecyclerView.Adapter<TalkContextAdapter.ViewHolder> {
    private List<TalkContext> mTalkCotextList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_talk,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TalkContextAdapter.ViewHolder holder, int position) {
        TalkContext mTalkContext = mTalkCotextList.get(position);
        holder.talkContext.setText(mTalkContext.getTalkContext());

    }

    @Override
    public int getItemCount() {
        return mTalkCotextList.size();
    }

    public TalkContextAdapter(List<TalkContext> talkContextList){
        mTalkCotextList = talkContextList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView talkContext;

        public ViewHolder(View itemView) {
            super(itemView);

            talkContext = itemView.findViewById(R.id.tv_talkContext);
        }
    }
}
