package model;

import java.util.Calendar;


public abstract class Producer extends User {

    private String name;
    private String urlImage;
    private int totalViews;
    private int playedTime;

    public Producer(String id,String nickname,Calendar vinculationDate,String name, String urlImage){
        super(id, nickname, vinculationDate);
        this.urlImage = urlImage;
        this.name = name;
        this.totalViews = 0;
        this.playedTime = 0;
    }

    public String getUrl() {
        return urlImage;
    }


    public void setUrl(String urlImage) {
        this.urlImage = urlImage;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getTotalViews() {
        return totalViews;
    }


    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }


    public int getTotalPLayedTime() {
        return playedTime;
    }


    public void setTotalPLayedTime(int playedTime) {
        this.playedTime = playedTime;
    }

    

    




    
    
}
