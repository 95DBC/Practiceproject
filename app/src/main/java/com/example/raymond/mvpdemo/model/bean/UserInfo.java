package com.example.raymond.mvpdemo.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Raymond 陈徐锋 on 2018/2/26.
 * Email: raymond@hinteen.com
 * Description: DAO 层映射model 类
 */
@Entity
public class UserInfo {
    @Id
    private long id;
    private String UserAccount;
    private String UserPasword;
    @Generated(hash = 94866158)
    public UserInfo(long id, String UserAccount, String UserPasword) {
        this.id = id;
        this.UserAccount = UserAccount;
        this.UserPasword = UserPasword;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserAccount() {
        return this.UserAccount;
    }
    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }
    public String getUserPasword() {
        return this.UserPasword;
    }
    public void setUserPasword(String UserPasword) {
        this.UserPasword = UserPasword;
    }


}
