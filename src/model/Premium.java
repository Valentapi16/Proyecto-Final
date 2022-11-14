package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Premium extends Consumer implements ICreateAPlaylist, IEditAPlaylist {

    private ArrayList<Playlist> playlist;
    private ArrayList <Audio> audios;

    public Premium(String id, String nickname, Calendar vinculationDate,Calendar purchaseDate){
        super(id, nickname, vinculationDate, purchaseDate);
        playlist = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
        
    }

    @Override
    public String deleteAudio(Audio audio, String namePlaylist, String nameAudio) {
        String msj ="";
        Playlist thePlaylist = findPlaylist(namePlaylist);
        if(thePlaylist ==null){
            msj= "That playlist doesnt exists";
        }
        else{
            boolean repitAudio=thePlaylist.findAudio(nameAudio);
            if(repitAudio == true){
                thePlaylist.getAudios().remove(audio);
                msj="The audio has been removed";
            }
            else{
                msj = "It is not possible to found that audio nopuedeserrrrrr";
            }
        }
        return msj;
    }

    @Override
    public String addAudioToPlaylist(String namePlaylist, int typeAudio, Audio audio, String nameAudio) {
            String msj = "";
            Playlist playlist = findPlaylist(namePlaylist);
            if(playlist == null){
                msj ="This playlist doesnt exists";
            }
            else{

                if(playlist.typePlaylist()==1){

                    if(playlist.typePlaylist()==typeAudio){
                        boolean repitAudio= playlist.findAudio(nameAudio);
                        if(repitAudio == false){
                            playlist.getAudios().add(audio);
                            msj= "The audio has been added";
                        }
                        else{
                            msj = "It is not possible to add this audio due to it is a differente type pf playlist";
                        }
                    }
                    if(playlist.typePlaylist()==2){
                        if(playlist.typePlaylist()==typeAudio){
                            boolean repitAudio = playlist.findAudio(nameAudio);
                            if(repitAudio== false){
                                playlist.getAudios().add(audio);
                                msj = "The audio has been added";
                            }
                            else{
                                msj= "It is not possible to add this audio due to it is a different type of playlist";
                            }
                        }
                    }
                    if(playlist.typePlaylist()== 3){
                        boolean repitAudio = playlist.findAudio(nameAudio);
                        if(repitAudio == false){
                            playlist.getAudios().add(audio);
                            msj= "The audio has been added";
                        }
                        else{
                            msj="It is not possible to add this audio due to it is a differente type of playlist";
                        }
                    }
                }
            }
            return msj;
        }

    @Override
    public Playlist findPlaylist(String namePlaylist) {        Playlist newPlaylist = null;
        boolean validate = false;
        for(int i= 0; i<playlist.size() && !validate; i++){
            if(playlist.get(i).getName().equalsIgnoreCase(namePlaylist)){
                newPlaylist = playlist.get(i);
                validate = true;
            }

        }
        return newPlaylist;
    }

    @Override
    public boolean addPlaylist(String namePlaylist, int[][] matriz, String codePlaylist, int option) {

        boolean msj = true;
        Playlist newPlaylist = findPlaylist(namePlaylist);

        if(newPlaylist != null){
            msj = false;
        }
        else{
            playlist.add(new Playlist(namePlaylist, matriz,codePlaylist,option));
        }
        return msj;
    }

    
}
