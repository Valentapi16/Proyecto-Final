package model;

import java.util.ArrayList;

public class Playlist {
    
    private String namePlaylist;
    private ArrayList <Audio> audios;
    private int matriz[][];
    private String codePlaylist;
    private TypePlaylist typePlaylist;

    public Playlist(String namePlaylist, int[][] matriz,String codePlaylist, int option){
        this.namePlaylist = namePlaylist;
        this.matriz= matriz;
        this.codePlaylist= codePlaylist;
        audios= new ArrayList<Audio>();
        switch(option){
            case 1:
            typePlaylist= TypePlaylist.SONG;
            break;

            case 2:
            typePlaylist = TypePlaylist.PODCAST;
            break;

            case 3:
            typePlaylist = TypePlaylist.PODCASTSONG;
            break;
            

        }
    }
	/**
	getName: This method will get the name of the playlist
	@return option: int: this parameter read the option entered by the user. 
	*/
    public String getName(){
        return namePlaylist;
    }

    public void setName(String namePlaylist){
        this.namePlaylist = namePlaylist;
    }

    public ArrayList<Audio> getAudios(){
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios){
        this.audios = audios;
    }

    public int[][] getMatriz() {
        return matriz;
    }


    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }


    public String getCode() {
        return codePlaylist;
    }


    public void setCode(String codePlaylist) {
        this.codePlaylist = codePlaylist;
    }

    public int typePlaylist(){
        switch(typePlaylist){
            case SONG:
             return 1;
            case PODCAST:
             return 2;
            case PODCASTSONG:
             return 3;
            default: 
             return 0;
        }
    }

    public boolean findAudio(String nameAudio){

        Audio object = null;
        boolean find = false;
        if (audios !=null){
            for (int i = 0; i <audios.size() && !find; i++){
                if(audios.get(i).getName().equalsIgnoreCase(nameAudio)){
                    object = audios.get(i);
                    find = true;
                }

            }
        }
        return find;
    }
}
