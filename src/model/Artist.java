package model;

import java.util.Calendar;
import java.util.ArrayList;


public class Artist extends Producer {

    private ArrayList<Song> songs;

    public Artist (String id,String nickname,Calendar vinculationDate, String urlImage,String name){
        super(id, nickname, vinculationDate, urlImage, name);
        songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs(){
        return songs;
    }

    public void setSongs(ArrayList<Song> songs){
        this.songs =songs;
    }
    
}
