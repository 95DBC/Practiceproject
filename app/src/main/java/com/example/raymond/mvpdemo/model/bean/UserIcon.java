package com.example.raymond.mvpdemo.model.bean;

import android.support.annotation.IntDef;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;



/**
 * Created by Raymond 陈徐锋 on 2018/3/13.
 * Email: raymond@hinteen.com
 * Description: 该类用于实验GreenDAO 存储图片资源
 * 两种思路：一种是将Bitmap 转化为Byte[] 再将Byte[] 转化为String
 * 一种是将图片找个位置放起来，数据库存储该图片的位置信息即可
 */
@Entity
public class UserIcon {
    @Id(autoincrement = true)
    private Long IconID;
    private String UserIcon;

    @Generated(hash = 1333558050)
    public UserIcon(Long IconID, String UserIcon) {
        this.IconID = IconID;
        this.UserIcon = UserIcon;
    }

    @Generated(hash = 1934944464)
    public UserIcon() {
    }

    public Long getIconID() {
        return IconID;
    }

    public void setIconID(Long iconID) {
        IconID = iconID;
    }

    public String getUserIcon() {
        return UserIcon;
    }

    public void setUserIcon(String userIcon) {
        UserIcon = userIcon;
    }
}
