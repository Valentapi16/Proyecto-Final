package model;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

public class StreamingController {

    public ArrayList<Audio> audios;
    public ArrayList<User> users;
    public static final int ROWS = 6;
    public static final int COLUMNS= 6;

    public StreamingController(){

        users= new ArrayList<User>();
        audios = new ArrayList<Audio>();
    }

    /**
     * findUser: This method checks if the user exists
     * @param nickname: String: the nickname user.
     * @return pos: a object of type user. 
     */
    public User findUser(String nickname){
        User user= null;
        boolean isFound = false;
        for(int i= 0;i<users.size() && !isFound; i++){
            if(users.get(i).getNickName().equalsIgnoreCase(nickname)){
                user= users.get(i);
                isFound = true;
            }
        }
        return user;
    }

    /**
     * actualDate: This method will give the actual date.
     * @return calendar: the day actual. 
     */
    
    public Calendar actualDate(){
        
        Calendar calendar = new GregorianCalendar(2022,Calendar.NOVEMBER,8);
        return calendar;
    }
    
     /**
     * generateANumber: This method will generate random numbers
     * @return num : int: a random number. 
     */
    public int generateANumber(){


        Random r = new Random();
        int value = r.nextInt(8+1)+ 1;

        return value;

    }

    /**
     * createMatriz: this method generate a matriz.
     * @return matriz : a matriz as a type int. 
     */    
    public int[][] createMatriz(){

        int matriz[][] = new int[ROWS][COLUMNS];

        for(int i= 0; i<ROWS; i++){
            for(int j= 0; i<COLUMNS; i++){
                matriz[i][j] =generateANumber(); 
            }
        }
        return matriz;
    }

    /**
     * finAudio: This method compares the names of existing audios to see if there is already one.
     * @param nameAudio: String: the audios name.
     * @return pos: a object of type audio. 
     */
    public Audio findAudio(String nameAudio){
        Audio audio = null;
        boolean isFound = false;

        for(int i= 0; i<audios.size() && !isFound; i++){
            if(audios.get(i).getName().equalsIgnoreCase(nameAudio)){
                
                audio = audios.get(i);
                isFound = true;
            }
        }
        return audio;
    }

    /**
     * produceCode: This method generate a code depended of the playlist type
     * @param option: int: the playlist type.
     * @param matriz: int[][]: the playlist matriz.
     * @return code : a msj of the matriz. 
     */
    public String produceCode(int option,int[][]matriz){
        String code=null;

        switch(option){
            case 1:
             for(int i=5;i<0;i--){
                code+=matriz[i][0];
             }
             for(int j=1, h=1;j>4 && h>4;j++,h++){
                code+=matriz[j][h];
             }
             for(int k=5;k<0;k--){
                code+=matriz[k][5];
             }
            break;

            case 2:
             for(int i=0;i<2;i++){
                code+=matriz[0][i];
             }
             for(int j=1;j<5;j++){
                code+=matriz[j][2];
             } 
             for(int k=5;k<0;k--){
                code+=matriz[k][3];
             }
             for(int u=3;u>5;u++){
                code+=matriz[0][u];
             }

             break;
               
             case 3:
             for (int i=5;i>=0;i--){
                for(int j=5;j>=0;j--){
                    int sum = i+j;
                    if (sum%2!=0){
                        if(sum!=1){
                            code+=matriz[i][j]+" ";
                        }
                    }

                }
            }
             break;

        }

      return code;

    }
    /**
     * createConsumer: This method register a consumer.
     * @param nickname: String: This is the nickname of the consumer.
     * @param id: String: This is the id of the consumer.
     * @param option: int: the consumer type. 
     * @return msj: String: a confirmation message.
     */
    public String createConsumer(String nickname, String id, int option){

        String msj = "";
        User objectUser = findUser(nickname);

        if(objectUser != null){
            msj = "This user already exists";

        }
        else{
            Calendar vinculationDate = actualDate();
            if(option==1){
                users.add(new Standard(id, nickname, vinculationDate, vinculationDate));
                msj = "Now you are a Costumer with a Plan Standar ";
            }
            else{
                users.add(new Premium(id, nickname, vinculationDate, vinculationDate));
                msj = "Now you are a Costumer with a Plan Premium";
            }
        }
        return msj;
    }
    /**
     * createProducer: This method will register a producer.
     * @param nickname: String: This is the nickname of the producer
     * @param id: String: This is the id of the producer.
     * @param url: String: This is the image url.
     * @param name: String: This is the real producer name.
     * @param option: int: the producer type. 
     * @return msj: String: a confirmation message.
     */
    public String createProducer(String nickname, String id, String url,String name, int option){
        String msj;
        User user = findUser(nickname);

        if(user != null){
            msj = "This user already exists";
        }
        else{
            Calendar vinculationDate = actualDate();
            if(option == 1){
                users.add(new Creator(id, nickname, vinculationDate, url, name));
                msj = "The creator of Content has been created";
            }
            else{
                users.add(new Artist(id, nickname, vinculationDate, url, name));
                msj = "The artist has been created";
            }
        }
        return msj;
    }
    /**
     * createPodcast: this method register a podcast.
     * @param nickname: String: this is the autor nickname.
     * @param name: String: this is the real podcast name.
     * @param urlImage: String: this is the image url.
     * @param durationAudio: int : the podcast duration. 
     * @param description: String: the description of the podcast. 
     * @param typePodcast: int: the podcast type. 
     * @return msj: String: a confirm message.
     */

    public String createPodcast(String nickname, String nameAudio, String urlImage, int durationAudio,String description, int typePodcast){
        String msj= "Podcast created";
        User user = findUser(nickname);

        if(user == null){
            msj = "This user doesnt exist in the system";
        }
        else{
            if(user instanceof Creator){
                Audio podcast = findAudio(nameAudio);
                if(podcast !=null){
                    msj = "This podcast already exists";
                }
                else{
                    audios.add(new Podcast(nameAudio, urlImage, durationAudio, description, typePodcast));
                    Creator creator = ((Creator)(user));
                    creator.getPodcasts().add(new Podcast(nameAudio, urlImage, durationAudio, description, typePodcast));
                }
            }
            else{
                msj = "This user is not a creator";
            }
        }
        return msj;
    }
    /**
     * createSong: this method register a song.
     * @param nickname: String: this is the autor nickname.
     * @param nameAudio: String: this is the real song name.
     * @param urlImage: String: this is the image url.
     * @param durationAudio: int : the song duration.
     * @param urlalbum: String: the album. 
     * @param cost: double: the price in dollars of the song. 
     * @param typeGenre: int: the song type. 
     * @return msj: String: a confirmation message.
     */
    public String createSong(String nickname, String nameAudio, String urlImage,int durationAudio,String urlAlbum, double cost, int typeGenre){
        String msj = "New song created";
        User user = findUser(nickname);

        if(user == null){
            msj = "This user doesnt exists in the system";
        }
        else{
            if(user instanceof Artist){
                audios.add(new Song(nameAudio, urlImage, durationAudio, urlAlbum, cost, typeGenre));
                Artist artist = ((Artist)(user));
                artist.getSongs().add(new Song(nameAudio, urlImage, durationAudio, urlAlbum, cost, typeGenre));
            }
            else{
                Audio song = findAudio(nameAudio);
                if(song!= null){
                    msj ="This song already exists";
                }

            }
        }
        return msj;
    }
     /**
     * registerPlaylist: This method will register a playlist.
     * @param nickname: String: this is the user nickname.
     * @param name: String: this is the playlist name.
     * @param option: int: the playlist type. 
     * @return msj: String: a confirmation message.
     */
    public String registerPlaylist(String nickname, String name, int option){

        String msj="The playlist has been created";
        User user = findUser(nickname);

        if(user == null){
            msj = "This user doesnt exists";
        }
        else{
            if(user instanceof Standard){
                int[][] matriz = createMatriz();
                String code = produceCode(option, matriz);
                Standard standard = ((Standard)(user));
                boolean validate = standard.addPlaylist(name, matriz, code, option);
                if(validate ==false){
                    msj= "This playlist already exists";
                }
            }
            else if(user instanceof Premium){
                int [][] matriz = createMatriz();
                String code = produceCode(option, matriz);
                Premium premium = ((Premium)(user));
                boolean validate = premium.addPlaylist(name, matriz, code, option);
                if(validate == false){
                    msj = "This playlist already exists";
                }
            }
            else{
                msj = "This user doesnt have a plan(Standar or Premium)";
            }
        }
        return msj;
    }

    /**
     * editAudioPlaylist: this method add a audio of aplaylist.
     * @param option: int: the playlist type. 
     * @param nickname: String: this is the user nickname.
     * @param namePlaylist: String: this is de playlist name.
     * @param audio: String: the audios name. 
     * @return msj: String: a confirmation message.
     */
    public String editAudioPlaylist(int option,String nickname,String namePlaylist, String nameAudio){
        String msj = ""; 
        Audio newAudio = findAudio(nameAudio);
        if(newAudio == null){
            msj = ("This song doesnt exists");
        }
        else{
            int type;
            if(newAudio instanceof Song){
                type = 1;
            }
            else{
                type = 2;
            }
            User theUser = findUser(nickname);
            if(theUser == null){
                msj = "This user doesnt exist"; 
            }
            else{
                if(option == 1){
                    if(theUser instanceof Standard){
                        Standard newStandart = ((Standard)(theUser));
                        msj = newStandart.deleteAudio(newAudio, namePlaylist, nameAudio);
                    }
                    else if(theUser instanceof Premium){
                        Premium newPremium = ((Premium)(theUser));
                        msj = newPremium.deleteAudio(newAudio, namePlaylist, nameAudio);
                    }
                    else{
                        msj = "This user doesnt have a Plan(Standard or Premium)";
                    }
                }
                if(option == 2){
                    if(theUser instanceof Standard){
                        Standard newStandart = ((Standard)(theUser));
                        msj = newStandart.addAudioToPlaylist(namePlaylist, type, newAudio,nameAudio); 
                    }
                    else if(theUser instanceof Premium){
                        Premium newPremium = ((Premium)(theUser));
                        msj = newPremium.addAudioToPlaylist(namePlaylist,type,newAudio, nameAudio);
                    }
                    else{
                        msj = "This user doesnt have a Plan(Standard or Premium)";
                    }

                }
            }
        }

        return msj;

    }

}
