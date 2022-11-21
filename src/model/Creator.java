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

    /**
     * findAutorAudio: Search for an audio for this creator. 
     * @param podcast: Podcast: the obj podcast
     * @return isFoud : boolean: if is found o isnot found. 
     */
    public boolean findAutorAudio(Podcast podcast){
        boolean isFound = false;
        for(int i = 0; i < podcasts.size() && !isFound; i++){
            if(podcasts.get(i) == podcast){
                isFound = true;
            }
        }
        return isFound;
    }
    
}
