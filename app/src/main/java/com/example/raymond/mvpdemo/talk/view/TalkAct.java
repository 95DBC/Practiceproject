package com.example.raymond.mvpdemo.talk.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.raymond.mvpdemo.R;
import com.example.raymond.mvpdemo.adapter.TalkContextAdapter;
import com.example.raymond.mvpdemo.base.MyApplication;
import com.example.raymond.mvpdemo.model.bean.TalkContext;
import com.example.raymond.mvpdemo.talk.presenter.InsertTalkContext;
import com.example.raymond.mvpdemo.talk.presenter.QueryTalkContext;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Create by Raymond 陈徐锋 on 2018/4/25
 * Email:raymond@hinteen.com
 * Description: 评论功能的实现，插入数据库的，有评论的内容，还包含回答者和问答者，回答者和问答者用
 * SpanableString 和SpanableStringBuilder 实现，判断Session 中的 user_nickName 是否和item 中的user_nickName
 * 是否一致，从而添加对应的回答者和提问者，回答的提问通过Item 的点击实现
 */

public class TalkAct extends AppCompatActivity implements ShowTalkDataOnView {

    @BindView(R.id.edt_answerContext)
    EditText edtAnswerContext;
    @BindView(R.id.iv_commitAn)
    ImageView ivCommitAn;
    @BindView(R.id.rly_commitAnswer)
    RelativeLayout rlyCommitAnswer;
    @BindView(R.id.rlv_talkContextt)
    RecyclerView rlvTalkContextt;
    @BindView(R.id.ly_talkContext)
    LinearLayout lyTalkContext;
    @BindView(R.id.iv_packUp)
    ImageView ivPackUp;

    private QueryTalkContext mQueryTalkContext;
    private InsertTalkContext mInsertTalkContext;

    private String asker = "Asker";
    private String answer = "Answer";
    private String huifu = "回复";
    private Long askerId = 1L;
    private Long responderId = 1L;


    private Context mContext = this;

    List<TalkContext> mTalkContextList = new ArrayList<TalkContext>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        ButterKnife.bind(this);

        mQueryTalkContext = new QueryTalkContext(this);
        mQueryTalkContext.queryTalkDataFromDB(mContext);
    }

    @Override
    public void showTalkContextOnView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        rlvTalkContextt.setLayoutManager(layoutManager);
        mTalkContextList = MyApplication.appSingleInstance().mTalkContextList;
        TalkContextAdapter adapter = new TalkContextAdapter(mTalkContextList);
//        for ( TalkContext talkContext: mTalkContextList){
//            String mTalkContext = talkContext.getTalkContext();
//            int start = mTalkContext.indexOf("回复");
//            int end = start+1;
//            SpannableString spanableString = new SpannableString(mTalkContext);
//            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
//            spanableString.setSpan(colorSpan,start,end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        }

        rlvTalkContextt.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        adapter.setOnItemClickListener(new TalkContextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                rlyCommitAnswer.setVisibility(View.VISIBLE);
                MyApplication.appSingleInstance().TalkState = 1;
                Toast.makeText(mContext, "你好", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @OnClick({R.id.iv_commitAn, R.id.iv_packUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_commitAn:
                String talkContext = edtAnswerContext.getText().toString();
                String finalTalk = null;
                mInsertTalkContext = new InsertTalkContext(this);

//
                if (0 == MyApplication.appSingleInstance().TalkState) {
                    finalTalk = answer + " 回复：" + talkContext;


                } else if (1 == MyApplication.appSingleInstance().TalkState) {
                    finalTalk = answer + " 回复" + asker + "：" + talkContext;

                }

                mInsertTalkContext.insertDataToDB(mContext, askerId, responderId, finalTalk);
                MyApplication.appSingleInstance().TalkState = 0;
                edtAnswerContext.setText("");
//                rlyCommitAnswer.setVisibility(View.INVISIBLE);

                break;
            case R.id.iv_packUp:
                lyTalkContext.setVisibility(View.INVISIBLE);

                break;
        }
    }


}
