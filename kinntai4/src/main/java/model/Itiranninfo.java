package model;

import java.io.Serializable;

public class Itiranninfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;//氏名
    private String attendance;
    private String datetime;
    //コンストラクタ
    public Itiranninfo(){}

    //氏名
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getAttendance(){
        return attendance;
    }
    public void setAttendance(String attendance){
        this.attendance = attendance;
    }
    public String getDatetime(){
        return datetime;
    }
    public void setDatetime(String datetime){
        this.datetime = datetime;
    }
}
