package model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Standard extends Consumer implements ICreateAPlaylist, IEditAPlaylist {
    private Playlist[] playlist;
    private ArrayList<Audio> audios;
    private final int SIZE_PLAYLIST = 20;


    public Standard(String id, String nickname, Calendar vinculationDate, Calendar purchaseDate){
        super(id, nickname, vinculationDate, purchaseDate);

        playlist = new Playlist[SIZE_PLAYLIST];
        audios = new ArrayList<Audio>();
    }


    @Override
    public Playlist findPlaylist(String namePlaylist){
        Playlist newPlaylist = null;
        boolean validate = false;
        for(int i= 0; i<20 && !validate; i++){
            if(playlist[i]!=null && playlist[i].getName().equals(namePlaylist)){
                newPlaylist = playlist[i];
                validate = true;

            }
        }
        return newPlaylist;
    }


    @Override
    public boolean addPlaylist(String namePlaylist, int[][] matriz, String code, int option){

        boolean validate = true;
        Playlist newPlaylist = findPlaylist(namePlaylist);
        
        if(newPlaylist !=null){
            validate = false;
        }
        else{
            boolean anotherValidate = spaceForPlaylist();
            if(anotherValidate==true){
                newPlaylist = new Playlist(namePlaylist, matriz, namePlaylist, option);
                anotherValidate = false;
                for(int i= 0; i< 20 && !anotherValidate ; i++){
                    if(playlist[i]==null){
                        playlist[i]= newPlaylist;
                        anotherValidate = true;
                    }
                }

            }
        }

        return validate;
    }

    public boolean spaceForPlaylist(){
        boolean validate = true;
        if(playlist[19] != null){
            validate = false;
        }
        return validate;
    }


    @Override
    public String deleteAudio(Audio audio, String namePlaylist, String nameAudio) {
        
        String msj="";
        Playlist thePlaylist= findPlaylist(namePlaylist);
        if(thePlaylist ==null){
            msj= "This playlist doesnt exists";
        }
        else{
            boolean repitAudio = thePlaylist.findAudio(nameAudio);
            if(repitAudio == true){
                thePlaylist.getAudios().remove(audio);
                msj = "The audio has been succesfully removed";
            }
            else{
                msj = "That audio doesnt exists";
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
    public String sharePlaylist(String namePlaylist) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String shareMatrizPlaylist(String namePlaylist) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String showMatriz(int[][] matrix) {
        // TODO Auto-generated method stub
        return null;
    }

    

}
