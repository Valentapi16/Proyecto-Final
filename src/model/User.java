package model;


import java.util.Calendar;

public abstract class User {

    public String id;
    public String nickname;
    private Calendar vinculationDate;
    private Calendar purchaseDate;

    public User(String id, String nickname, Calendar vinculationDate, Calendar purchaseDate){
        this.id = id;
        this.nickname = nickname;
        this.vinculationDate = vinculationDate;
        this.purchaseDate = purchaseDate;
    }

    public User (String id, String nickname, Calendar vinculationDate){
        this.id = id;
        this.nickname = nickname;
        this.vinculationDate = vinculationDate;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNickName(){
        return nickname;
    }

    public void setNicknName(String nickname){
        this.nickname = nickname;
    }

    public Calendar getVinculationDate(){
        return vinculationDate;
    }

    public void setVinculationDate(Calendar vinculationDate){
        this.vinculationDate = vinculationDate;
    }
    
}