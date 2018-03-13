package com.example.raymond.mvpdemo.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Raymond 陈徐锋 on 2018/3/12.
 * Email: raymond@hinteen.com
 * Description: 该类用于测试GreenDAO生成数据库表的另一种写法
 */
@Entity
public class Label {
    @Id(autoincrement = true)
    private Long id;
    private String labelName;


    
    public Label(String labelName) {
    }


    @Generated(hash = 1109657579)
    public Label(Long id, String labelName) {
        this.id = id;
        this.labelName = labelName;
    }


    @Generated(hash = 2137109701)
    public Label() {
    }
    

    public Long getLabelID() {
        return id;
    }

    public void setLabelID(Long labelID) {
        this.id = labelID;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
