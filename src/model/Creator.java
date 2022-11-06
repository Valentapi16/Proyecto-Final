package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Creator extends Producer {

    private ArrayList<Podcast> podcasts;

    public Creator(String id,String nickname,Calendar vinculationDate, String urlImage, String name){
        super(id, nickname, vinculationDate, urlImage, name);
        podcasts = new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPodcasts(){
        return podcasts;
    }

    public void setPodcast(ArrayList<Podcast> podcasts){
        this.podcasts = podcasts;
    }
    
}
