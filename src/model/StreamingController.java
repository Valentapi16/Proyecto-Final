package model;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Random;



import java.util.GregorianCalendar;

public class StreamingController {

    public ArrayList<Audio> audios;
    public ArrayList<User> users;
    public ArrayList<Store> stores;
    public static final int ROWS = 6;
    public static final int COLUMNS= 6;

    public StreamingController(){

        users= new ArrayList<User>();
        audios = new ArrayList<Audio>();
        stores = new ArrayList<Store>(); 
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

        int matriz[][]=new int[6][6];

        for(int i=0;i<6;i++){
          for(int j=0;j<6;j++){
              matriz[i][j]=generateANumber();
          }
        }
        return matriz;
    }

    /**
     * findAudio: This method compares the names of existing audios to see if there is already one.
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
            for (int i = matriz.length; i > 0; i--) {
                code += matriz[i - 1][0];
              }
                  for (int i = 1, j = 1; i < matriz.length -1; i++, j++) {           
                    code+= matriz[i][j];        
                  }
              for (int i = matriz.length; i > 0; i--) { 
                code += matriz[i - 1][matriz[0].length - 1];
              }
            break;

            case 2:
            for (int j = 0; j < matriz.length -4; j++) { 
                code+= matriz[0][j];
            }
            for (int i = 0; i < matriz.length; i++) { 
                code += matriz[i][2];
            }
            for (int i = matriz.length; i > 0; i--) { 
                code += matriz[i - 1][3];
            }
            for (int j = matriz.length -2; j < matriz.length; j++ ) { 
                code += matriz[0][j];
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

    public String createPodcast(String nickname, String nameAudio, String urlImage, int durationAudio,int option,String description, int typePodcast){
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
            msj = "This user doesnt exists";

        }else{
            if(user instanceof Artist){
                Audio song = findAudio(nameAudio);
                if(song!= null){
                    msj = "This song already exists";
                }
                else{
                    audios.add(new Song(nameAudio, urlImage, durationAudio, urlAlbum, cost, typeGenre));
                    Artist artist = ((Artist)(user));
                    artist.getSongs().add(new Song(nameAudio, urlImage, durationAudio, urlAlbum, cost, typeGenre));
                }
            }
            else{
                msj = "This user isnt an artist";
            }
        }
        return msj ;
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
            msj = "This song doesnt exists MALDITA SEAAAAAAA";
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
                msj = "This user doesn't exist"; 
            }
            else{
                if(option == 1){
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
                if(option == 2){
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
            }
        }
        return msj;
    }
    /**
     * ShareThePlaylist: Share trough a code an specific type of playlist according to the user 
     * @param nickname : String : User's nickname.
     * @param namePlaylist: String: Playlist's name.
     * @return  code: String: The playlist. 
     */
    public String shareThePlaylist(String nickname,String namePlayslit){
        String code = "";
        User user = findUser(nickname);

        if( user == null){
            code = "This user doesnt exists";
        }
        else {
            if(user instanceof Standard){
                Standard newStandart=((Standard)(user));
                code = newStandart.sharePlaylist(namePlayslit)+ "\n" + newStandart.shareMatrizPlaylist(namePlayslit);
            }
            else if(user instanceof Premium){
                Premium newPremium = ((Premium)(user));
                code = newPremium.sharePlaylist(namePlayslit) + "\n"+ newPremium.shareMatrizPlaylist(namePlayslit);
            }
            else{
                code = "This is only for consumer users";
            }
        }
        return code;
    }
    /**
     * reproductionAudio: this method plays an audio. 
     * @param nickname : String : this is the user nickname.
     * @param nameAudio: String: the audios name.
     * @return  msj: String: a confirm message.
     */
    public String reproductionAudio(String nickname, String nameAudio){
        String msj = "";
        User user = findUser(nickname);

        if(user== null){
            msj = "This user doesnt exist in the platform";
        }
        else{
            Audio newAudio = findAudio(nameAudio);
            if(newAudio == null){
                msj = "This audio doesnt exists";
            }
            else{
                if(user instanceof Standard){
                    Standard newStandard = ((Standard)(user));
                    msj =  newStandard.play(newAudio);
                    stateAudio(newAudio);
                }
                else if(user instanceof Premium){
                    Premium newPremium = ((Premium)(user));
                    msj = newPremium.play(newAudio);
                    stateAudio(newAudio);
                }else{
                    msj = "This is only for consumers users";
                }
            }
        }
        return msj ;
    }

    public void stateAudio(Audio audio){
        if(audio instanceof Song){
            Song song = ( (Song)(audio) );
            boolean val=false;
            for(int i=0;i<users.size() && !val;i++){
                if(users.get(i) instanceof Artist){
                    Artist artist = ( (Artist) (users.get(i)) );
                    if(artist.findAutorAudio(song)){
                        artist.setTotalViews(artist.getTotalPLayedTime()+1);
                        artist.setTotalPLayedTime(song.getDuration()+artist.getTotalPLayedTime());
                        song.setView(song.getView()+1);
                        val=true;
                    }
                }
            }
    
        }
        else if(audio instanceof Podcast){
            Podcast podcast = ( ( Podcast)(audio));
            boolean val=false;
            for(int i=0;i<users.size() && !val;i++){
                if(users.get(i) instanceof Creator){
                    Creator creator = ( (Creator)(users.get(i)) );
                    if(creator.findAutorAudio(podcast)){
                        creator.setTotalViews(creator.getTotalPLayedTime()+1);
                        creator.setTotalPLayedTime(podcast.getDuration()+creator.getTotalPLayedTime());
                        podcast.setView(podcast.getView()+1);
                        val=true;
                    }
                }
            }
        }
    }
    /**
     * countPurchases: this method count the buys for user. 
     * @param nickname : String : this is the user nickname.
     * @return  count: int: a int count .
     */
    public int countPurchases(String nickname){
        int count =0; 
        if(stores.size() != 0){

            for(int i = 0; i <stores.size(); i++ ){
                stores.get(i).getNickname().equalsIgnoreCase(nickname);
                count++;
            }

        }
        return count; 

    }
    /**
     * purchaseSong: Buys a song. 
     * @param nickname : String : User's nickname.
     * @param nameAudio: String: Audio's name.
     * @return  msj: String: a confirm message.
     */
    public String purchaseSong(String nickname, String nameAudio){

        String msj = "Thank you for purchasing"; 
        User user = findUser(nickname);

        if(user == null){
            msj = "This user doesnt exists in the system";
        }
        else{
            Audio newAudio = findAudio(nameAudio);
            if(newAudio == null){
                msj = "This audio doesnt exists";
            }

            else{
                if(newAudio instanceof Song){
                    Song newSong = ( (Song)(newAudio) );
                    if(user instanceof Standard){
                        int numBuys = countPurchases(nickname);
                        if(numBuys<100){
                            Store newStore = new Store(actualDate(), nickname, nameAudio); 
                            stores.add(newStore); 
                            newSong.setNumberSales(newSong.getAmountSales()+1);

                        }else{
                            msj = "You reached the purchasing limit "; 
                        }

                    } else if( user instanceof Premium){
                        Store newShop = new Store(actualDate(), nickname, nameAudio); 
                        stores.add(newShop); 
                        newSong.setNumberSales(newSong.getAmountSales()+1);

                    }
                }
                else if(newAudio instanceof Podcast){
                    msj = "You cant buy podcast";
                    
                }
                else{
                    msj = "Digit a type consumer"; 
                }
            } 

        }
        return msj; 

    }
    /**
     * reportTotalViews: this method inform the total views
     * @return msj: a confirmation message.
     */
    public String reportTotalViews(){
        String msj = ""; 
        int totalViews=0;
        if(audios.size()!=0){
            for(int i=0;i<audios.size();i++){
            totalViews+=audios.get(i).getView();
            }
        }
        msj = "the total views is  " + totalViews ;
        return msj;

    }
    public String infoMostViewSong(String nickname){
        String msj = ""; 
        User user = findUser(nickname);

        if(user == null){
            msj = "this user doesnt exist";
        }
        else{

            if(user instanceof Standard){
                Standard standard = ((Standard)(user)); 
                 msj=mostSongViews() + standard.mostViewsSong();
            }
            else if(user instanceof Premium){
                Premium premium = ((Premium)(user)); 
                 msj=mostSongViews() + premium.mostViewsSong();

            }
            else{
                msj="you must enter a user type consumer";
            }
        }
    return msj;

    }
    /**
     * mostSongViews: this method inform the most view song in the app. 
     * @return msj: String : a confirmation message.
     */

    public String mostSongViews(){
        String msj ="";
        int[]  geners ={0,0,0,0};
        int position =0;
        if(audios.size()!=0){
            for(int i =0; i< audios.size(); i++){
                if(audios.get(i) instanceof Song){
                    Song song = ( (Song)(audios.get(i)) );
                    switch(song.typeGenre()){
                     case 1:
                      geners[0]++;
                      break;
                     case 2:
                     geners[1]++;
                      break;
                     case 3:
                     geners[2]++;
                      break;
                     case 4:
                     geners[3]++;
                      break;
                     default:
                      break;
                   }
                }
            }
            int mayor =0;
            for(int i =0; i<4; i++){
                if(geners[i]> mayor){
                    position =i; 
                }
            }
            switch(position){
             case 0:
             msj="\n The most listened genre  rock \n"+"views: "+geners[position];
             break;
             case 1:
             msj="\n The most listened genre: pop \n"+"views: "+geners[position];
             break;
             case 2:
             msj="\n The most listened genre : trap \n"+"views: "+geners[position];
             break;
             case 3:
             msj="\n The most listened genre: house \n"+"views: "+geners[position];
             break;
             case 4:
             msj="This song doesnt exists";
             break;
            }

        }
        else{
            msj = "The platform doesnt have audios to do the reports";
        }
        return msj; 
    }

     /**
     * infoMostViewPodcast: this method inform the most view podcast for user. 
     * @param nickname : String : this is the user nickname.
     * @return msj: String : a confirmation message.
     */

    public String infoMostViewPodcast(String nickname){
        String msj = ""; 
        User user = findUser(nickname);

        if(user == null){
            msj = "this user doesnt exist";
        }
        else{

            if(user instanceof Standard){
                Standard standard = (Standard) user; 
                 msj=mostPodcastViews() + standard.mostViewsPodcast();
            }
            else if(user instanceof Premium){
                Premium premium = ( Premium) user; 
                msj=mostPodcastViews() + premium.mostViewsPodcast();

            }
            else{
                msj="you must enter a user type consumer";
            }
        }
        return msj;
    }
    /**
     * mostPodcastViews: this method inform the most view podcast in the app. 
     * @return msj: String : a confirmation message.
     */

    public String mostPodcastViews(){
    String msj="";
    int [] geners= {0,0,0,0};
    int position=4;
     if(audios.size()!=0){
       for(int i=0; i<audios.size();i++){
         if(audios.get(i) instanceof Podcast){
          Podcast podcast = ( (Podcast)(audios.get(i)) );
           switch(podcast.typePodcast()){
             case 1:
              geners[0]++;
              break;
             case 2:
             geners[1]++;
              break;
             case 3:
             geners[2]++;
              break;
             case 4:
             geners[3]++;
              break;
             default:
              break;
           }
         }
       }
       int mayor=0;
        for(int i=0; i<4;i++){
         if(geners[i]>mayor){
           position=i;
         }
        }
       switch(position){
         case 0:
         msj="The most listened genre: Politic \n"+"views: "+geners[position];
         break;
         case 1:
         msj="The most listened genre: Entertaiment \n"+"views: "+geners[position];
         break;
         case 2:
         msj="The most listened genre : Fashion \n"+"views: "+geners[position];
         break;
         case 3:
         msj="The most listened genre: Videogame \n"+"views: "+geners[position];
         break;
         case 4:
         msj="This podcast doesnt exists";
         break;
       }
       
     }
     else{
       msj="This platform doesnt have audios for reporting";
     }
    return msj;
   }
   /**
     * bestSellingSong: this method inform the most sold song in the app.
     * @return msj: String : a informative message.
     */
    public String bestSellingSong(){
        String msj = ""; 
        int solds =0;
        String name = "";
        double totalSales =0.0; 
    
        if(audios.size() !=0){
            for(int i =0; i< audios.size(); i++){
                if(audios.get(i) instanceof Song){
                    Song song = ( (Song)(audios.get(i)) );
                    if(song.getAmountSales() > solds){
                        solds = song.getAmountSales();
                        name = song.getName(); 
                        totalSales = song.getAmountSales() * song.getCost(); 
                    }
                }
            }
    
        } else{
            msj = "The platform doesnt have audios for reporting"; 
          }
    
          msj = "The best selling song is:  " +  name + " to these sales " + solds + " and the total sales value " + totalSales; 
          return msj; 
       }

    /**
     * allSalesSongs: Report the total sales for song sold in the platform.
     * @return msj: String : The report messaje.
     */

    public String allSalesSongs(){
        String msj = ""; 
        double totalSales = 0.0; 
        if(audios.size()!=0){
            for(int i =0; i< audios.size(); i++){
                if(audios.get(i) instanceof Song){
                     Song song = ( (Song)(audios.get(i)) );
                    totalSales += song.getAmountSales() *  song.getCost(); 
                }
            }
        }else{
            msj="The platform doesnt have audios for reporting";
        }
        msj = " The total number of songs sold is... " + totalSales; 
        return msj; 
    }
    /**
     * reportSongsSold: this method inform the song sold for genred in the app.
     * @return msj: String : a informative message.
     */
    public String reportSongsSold(){
        String msj = ""; 
        int countRock = 0;
        int countPop =0;
        int countTrap =0;
        int countHouse =0; 
        if(audios.size()!=0){
            for(int i =0; i< audios.size(); i++){
                if(audios.get(i) instanceof Song){
                    Song song = ( (Song)(audios.get(i)) );
                    switch(song.typeGenre()){
                         case 1:
                          countHouse += song.getAmountSales(); 
                          break;
                         case 2:
                         countPop += song.getAmountSales(); 
                          break;
                         case 3:
                         countRock += song.getAmountSales(); 
                          break;
                         case 4:
                         countTrap += song.getAmountSales(); 
                          break;
    
                         default:
                          break;
                    }
                }
            }
        }else{
            msj="The platform doesnt have audios for reporting";
        }
        msj = "The amount of sales according to the genre is: \n" +
            "House: " + countHouse + "\n"+
            "Pop: " +  countPop + "\n"+
            "Rock: " + countRock +"\n"+
            "Trap: "+ countTrap + "\n"; 
            return msj; 
       }
}
