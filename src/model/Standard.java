package model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Standard extends Consumer implements ICreateAPlaylist, IEditAPlaylist, IPlayAudio {
    private Playlist[] playlist;
    private ArrayList<Audio> audios;
    private final int SIZE_PLAYLIST = 20;


    public Standard(String id, String nickname, Calendar vinculationDate, Calendar purchaseDate){
        super(id, nickname, vinculationDate, purchaseDate);

        playlist = new Playlist[SIZE_PLAYLIST];
        audios = new ArrayList<Audio>();
    }

    /**
     * findPlaylist: This method compares the names of existing playlist to see if there is already one.
     * @param namePlaylist: String: The playlist name.
     * @return newPlaylist: An object of playlist audio. 
     */
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

    /**
     * addPlaylist: Add a playlist for the user. 
     * @param namePlaylist: String:The playlists name.
     * @param matriz: int[][]. The matriz of the playlist
     * @param code: String: The code of the matriz
     * @param option: the type of the playlist
     * @return validation : a boolean for confirmation. 
     */
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
    /**
     * spaceForPlaylist: Look for an available position in the array 
     * @return validation: Boolean of found or not found
     */
    public boolean spaceForPlaylist(){
        boolean validate = true;
        if(playlist[19] != null){
            validate = false;
        }
        return validate;
    }

    /**
     * deleteAudio: Delete an audio for a specific playlist.
     * @param audio:  Audio: the object audio.
     * @param namePlaylist: String: The name of the playlist
     * @param nameAudio: String: The name of the audio
     * @return msj: String: a confirmation message 
     */
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

     /**
     * addAudioToPlaylist: Add an audio for a specific playlist.
     * @param namePlaylist: String: the playlist name
     * @param typeAudio: int: The type of the audio.
     * @param audio:  Audio: the object audio. 
     * @param nameAudio: String: The name of the audio
     * @return msj: String: a confirmation message 
     */
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

    /**
     * sharePlaylist: Share a specific  users playlist. 
     * @param namePlaylist: String: Playlist name.
     * @return  msj:String: The playlist. 
     */
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

    /**
     * shareMatrizPlaylist: Share a matriz playlist  for user.
     * @param namePlaylist: String: Playlist's name.
     * @return   msj:String: The playlist. 
     */
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


    @Override
    public String play(Audio audio) {
        String msj = "."+ "."+"."+"."+"\n" +"The audio is playing at the moment"+ "\n";
        if(audios.size()==0){

        }else{
            int reproduction = audios.size();
            String adOne = "Coca-Cola -Open Happiness" + "\n";
            String adTwo = "Nike-Just do it" + "\n";
            String adThree = "M&Ms- Melts in Your Mouth, Not in Your Hands" + "\n";

            if(reproduction %2 ==0){
                int number = createNumber();
                switch(number){
                    case 1:
                    msj =adOne;
                    break;
                    
                    case 2:
                    msj = adTwo;
                    break;

                    case 3:
                    msj = adThree;
                    break;
                }
            }else{
                audios.add(audio);
            }
        }
        return msj;
        
    }
    public int createNumber(){

        Random r= new Random();
       
         int value = r.nextInt(2 + 1) + 1;
       
        return value;
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

    

}
