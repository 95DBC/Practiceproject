package com.example.raymond.mvpdemo.model.bean;

/**
 * Created by Raymond 陈徐锋 on 2018/3/9.
 * Email: raymond@hinteen.com
 * Description:
 */

public class RequestDayData {
    private int UserID;
    private String Date;
    private int Step;
    private int Distance;
    private int Calorie;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getStep() {
        return Step;
    }

    public void setStep(int step) {
        Step = step;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public int getCalorie() {
        return Calorie;
    }

    public void setCalorie(int calorie) {
        Calorie = calorie;
    }
}
