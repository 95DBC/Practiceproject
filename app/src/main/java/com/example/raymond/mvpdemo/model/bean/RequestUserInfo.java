package com.example.raymond.mvpdemo.model.bean;

/**
 * Created by Raymond 陈徐锋 on 2018/3/9.
 * Email: raymond@hinteen.com
 * Description: Post 请求提交的Json体
 */

public class RequestUserInfo {
    private String Device;
    private String NickName;
    private String City;
    private int Sex;
    private int Birth;
    private int Height;
    private String OS;
    private String url;

    public String getDevice() {
        return Device;
    }

    public void setDevice(String device) {
        Device = device;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public int getBirth() {
        return Birth;
    }

    public void setBirth(int birth) {
        Birth = birth;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
