package model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;//氏名
    private String date;
    private String stime;
    private String ttime;
    private String rtime;
    private String ztime;
    
    //コンストラクタ
    public UserInfo(){}

    //氏名
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getStime(){
        return stime;
    }
    public void setStime(String stime){
        this.stime = stime;
    }
    public String getTtime(){
        return ttime;
    }
    public void setTtime(String ttime){
        this.ttime = ttime;
    }
    public String getRtime(){
        return rtime;
    }
    public void setRtime(String rtime){
        this.rtime = rtime;
    }
    public String getZtime(){
        return ztime;
    }
    public void setZtime(String ztime){
        this.ztime = ztime;
    }
}
