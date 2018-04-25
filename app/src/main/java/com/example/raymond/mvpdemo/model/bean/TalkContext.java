package com.example.raymond.mvpdemo.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Raymond 陈徐锋 on 2018/4/24.
 * Email: raymond@hinteen.com
 * Description:
 */
@Entity
public class TalkContext {
    @Id(autoincrement = true)
    private Long id;

    private Long uid;
    private Long questionid;
    private String talkContext;
    @Generated(hash = 183494293)
    public TalkContext(Long id, Long uid, Long questionid, String talkContext) {
        this.id = id;
        this.uid = uid;
        this.questionid = questionid;
        this.talkContext = talkContext;
    }
    @Generated(hash = 837326724)
    public TalkContext() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUid() {
        return this.uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getQuestionid() {
        return this.questionid;
    }
    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }
    public String getTalkContext() {
        return this.talkContext;
    }
    public void setTalkContext(String talkContext) {
        this.talkContext = talkContext;
    }

   
    



}
