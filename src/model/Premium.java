package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Premium extends Consumer implements ICreateAPlaylist, IEditAPlaylist, IPlayAudio {

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
                msj = "It is not possible to found that audio ";
            }
        }
        return msj;
    }

    @Override
    public String addAudioToPlaylist(String namePlaylist, int typeAudio, Audio audio, String nameAudio) {
            String msj = "";
            Playlist thePlaylist = findPlaylist(namePlaylist);
            if(thePlaylist == null){
                msj ="This playlist doesnt exists";
            }
            else{

                if(thePlaylist.typePlaylist()==1){

                    if(thePlaylist.typePlaylist()==typeAudio){
                        boolean repitAudio= thePlaylist.findAudio(nameAudio);
                        if(repitAudio == false){
                            thePlaylist.getAudios().add(audio);
                            msj= "The audio has been added";
                        }
                        else{
                            msj = "The audio is repited";
                        }
                    }
                    else{
                        msj = "You cant add this audio due to this is a different kind of playlist";
                    }
                }
                if(thePlaylist.typePlaylist()==2){

                    if(thePlaylist.typePlaylist()==typeAudio){
                        boolean repitAudio= thePlaylist.findAudio(nameAudio);
                        if(repitAudio == false){
                            thePlaylist.getAudios().add(audio);
                            msj= "The audio has been added";
                        }
                        else{
                            msj = "The audio is repited";
                        }
                    }
                    else{
                        msj = "You cant add this audio due to this is a different kind of playlist";
                    }
                }
                if(thePlaylist.typePlaylist()==3){

                    if(thePlaylist.typePlaylist()==typeAudio){
                        boolean repitAudio= thePlaylist.findAudio(nameAudio);
                        if(repitAudio == false){
                            thePlaylist.getAudios().add(audio);
                            msj= "The audio has been added";
                        }
                        else{
                            msj = "The audio is repited";
                        }
                    }
                    else{
                        msj = "You cant add this audio due to this is a different kind of playlist";
                    }
                }

            }
            return msj;
        }

    @Override
    public Playlist findPlaylist(String namePlaylist) {
        Playlist newPlaylist = null;

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

    @Override
    public String play(Audio audio) {
        String msj = "."+ "."+"."+"."+"\n" +"The audio is playing at the moment"+ "\n";
        audios.add(audio);
        return msj;
    }

    @Override
    public String sharePlaylist(String namePlaylist) {
        String msj = "";
        Playlist playlist = findPlaylist(namePlaylist);
        if(playlist == null){
            msj ="This playlist doesnt exists";
        }
        else{
            msj = playlist.getCode();
        }
        return msj;
    }

    @Override
    public String shareMatrizPlaylist(String namePlaylist) {
        String msj = "";
        Playlist playlist = findPlaylist(namePlaylist);
        if(playlist == null){
            msj = "This playlist doesnt exists";
        }
        else{
            msj = showMatriz(playlist.getMatriz());
        }
        return msj;
    }

    @Override
    public String showMatriz(int[][] matrix) {
        String show = "";
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                show += matrix[i][j];
            }
            show += "\n";

        }
    
        return show;
    }

    public String mostViewsPodcast(){
        String msj= "";
        int [] generate = {0,0,0,0};
        int pos = 0;
        if(audios.size() !=0){
            for(int i= 0; i<audios.size();i++){
                if(audios.get(i) instanceof Podcast){
                    Podcast podcast = ((Podcast)(audios.get(i)));

                    switch(podcast.typePodcast()){
                        case 1:
                        generate[0]++;
                        break;

                        case 2:
                        generate[1]++;
                        break;

                        case 3:
                        generate[2]++;
                        break;

                        case 4:
                        generate[3]++;
                        break;

                        default:
                        break;
                    }
                }
            }
            int mayor = 0;
            for(int i = 0; i<4;i++){
                if(generate[i]> mayor){
                    pos = i;
                }
            }
            switch(pos){
                case 0:
                msj = "The most listened type of podcast according to this user is: ENTERTAINMENT \n"+ "with amount of views:" +generate[pos];
                break;

                case 1:
                msj = "The most listened type of podcast according to this user is: FASHION \n"+ "with amount of views:" +generate[pos];
                break;

                case 2:
                msj = "The most listened type of podcast according to this user is: POLITICS \n"+ "with amount of views:" +generate[pos];
                break;

                case 3:
                msj = "The most listened type of podcast according to this user is: VIDEOGAMES \n"+ "with amount of views:" +generate[pos];
                break;
            }
        }
        else{
            msj = "The user doesnt have a historial of views";
        } 
        return msj;

    }

    public String mostViewsSong(){
        String msj= "";
        int [] generate = {0,0,0,0};
        int pos = 0;
        if(audios.size() !=0){
            for(int i= 0; i<audios.size();i++){
                if(audios.get(i) instanceof Song){
                    Song song = ((Song)(audios.get(i)));

                    switch(song.typeGenre()){
                        case 1:
                        generate[0]++;
                        break;

                        case 2:
                        generate[1]++;
                        break;

                        case 3:
                        generate[2]++;
                        break;

                        case 4:
                        generate[3]++;
                        break;

                        default:
                        break;
                    }
                }
            }
            int mayor = 0;
            for(int i = 0; i<4;i++){
                if(generate[i]> mayor){
                    pos = i;
                }
            }
            switch(pos){
                case 0:
                msj = "The most listened genre of songs according to this user is: HOUSE \n"+ "with amount of views:" +generate[pos];
                break;

                case 1:
                msj = "The most listened type of podcast according to this user is: POP \n"+ "with amount of views:" +generate[pos];
                break;

                case 2:
                msj = "The most listened type of podcast according to this user is: ROCK \n"+ "with amount of views:" +generate[pos];
                break;

                case 3:
                msj = "The most listened type of podcast according to this user is: TRAP \n"+ "with amount of views:" +generate[pos];
                break;
            }
        }
        else{
            msj = "The user doesnt have a historial of views";
        } 
        return msj;

    }

    
}
