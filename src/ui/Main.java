package ui;

import java.util.Scanner;
import model.StreamingController;

public class Main {


    private Scanner reader;
    private StreamingController streaming;

    public Main(){
        reader = new Scanner(System.in);
        streaming = new StreamingController();
    }

    public StreamingController getStreamming(){
        return streaming;
    }

    public Scanner getReader(){
        return reader;

    }

    public static void main(String[] args){
        Main main = new Main();
        int option = 0;
        do{
            option = main.optionMenu();
            main.executeOption(option);
        }while(option != 0);

        main.getReader().close();
    }
	/**
	validateIntegerOption: This method will make that the system doesnt close when the user put
    a invalid option
	@return option: int:the option make by the user. 
	*/
    public int validateIntegerOption(){
        int option = 0;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine();
            option = -1;
        }
        return option;
    }


	/**
	optionMenu: This method shows all the options available in the menu, 
					after having the user enter an option.
	@return option: int: this parameter read the option entered by the user. 
	*/
    public int optionMenu( ){
        int option = 0;
        
       System.out.println("<<<<<Neotunes Streaming>>>>> \n\n" +
				"1. Register Users: Producers, artist and content creators\n" +
				"2. Register Users: Consumers, Estandar and Premium.\n" +
				"3. Register Songs or Podcasts.\n" + 
				"4. Create a Playlist.\n" +
				"5. Edit playlist.\n" +
				"6. Share a playlist\n" +
				"7. Listen a song\n" +
                "8. Purchase a song\n"+
                "9. Show reports\n"+
				"0. Exit. "); 
        option = validateIntegerOption();
        return option;
    }


    public void executeOption(int option){
        String name,nickname,id,namePlaylist, nameAudio = " ";
        String urlAlbum, urlImage = "";
        String description = "";
        int type, durationAudio,typeGenre,typePodcast = 0;
        double cost = 0.0;
		switch(option){

			case 1:
            System.out.println("You are doing the register of a producer");

            System.out.println("Digit the nickname of the user: ");
            nickname = reader.next();

            System.out.println("Digit the identification: ");
            id = reader.next();

            System.out.println("Digit the url of the image");
            urlImage = reader.next();

            System.out.println("Digit the real name of the producer: ");
            name = reader.next();
            
            System.out.println("Choose the type of producer : \n"+
            
            "1.Creator of content \n" +
            "2.Artist");
            type = validateIntegerOption();

            if((type ==2 || type ==1)&& type != -1){
                System.out.println(streaming.createProducer(nickname, id, urlImage, name, type));
            }else{
                System.out.println("Only valid options...");
            }
				break; 

			case 2: 
            System.out.println("You are doing the register of a consumer user");

            System.out.println("Digit the nickname of the user: ");
            nickname = reader.next();
            System.out.println("Digit the identification: ");
            id = reader.next();
            System.out.println("Choose the Plan you want to have: \n"+
            "1.Standard \n"+
            "2.Premium");
            type = validateIntegerOption();

            if((type ==2 || type ==1)&& type != -1){
                System.out.println(streaming.createConsumer(nickname, id, type));
            }else{
                System.out.print("Only valid options...");
            }
				break;
			case 3:
            System.out.println("Digit the nickname of the Artist or the content creator: ");
            nickname= reader.next();

            System.out.println("Digit the audio name: ");
            reader.nextLine();
            nameAudio = reader.nextLine();

            System.out.println("Digit the url:");
            urlImage = reader.next();
            System.out.println("Digit the duration of the audio:");
            durationAudio = validateIntegerOption();

            if(durationAudio ==-1){
                System.out.println("Only valid options: ");
            }
            System.out.println("Choose the type of Audio \n"+
            "1.Song\n"+
            "2.Podcast");
            type = validateIntegerOption();

            switch(type){
                case 1:
                System.out.println("Digit the name of the album");
                urlAlbum = reader.next();
                System.out.println("Digit the cost of the song");
                cost = validDoubleOption();
                if(cost ==-1){
                    System.out.println("Only valid options..");
                }
                System.out.println("Digit the genre of the song \n"+
                "1.House\n"+
                "2.Pop\n"+
                "3.Rock\n"+
                "4.Trap");
                typeGenre= reader.nextInt();
                if(typeGenre>4|| typeGenre<1){
                    System.out.println("Only valid options...");
                }else{
                    System.out.println(streaming.createSong(nickname, nameAudio, urlImage, durationAudio,type, urlAlbum, cost, typeGenre));
                }
                break;

                case 2:
                
                System.out.println("Digit the description that will have the podcast");
                reader.nextLine();
                description= reader.nextLine();
                reader.nextLine();
                System.out.println("Digit the type of podcast is this one : \n"+
                "1.Entertainment \n"+
                "2.Fashion\n"+
                "3.Politics \n"+
                "4.Videogames");
                typePodcast = validateIntegerOption();
                if(typePodcast >4 || typePodcast<1){
                    System.out.println("Only valid options...");
                }
                System.out.println(streaming.createPodcast(nickname, nameAudio, urlImage, durationAudio,type, description, typePodcast));
                break;

                default:
                System.out.println("Only valid options");
                break;
                }  

				break;

			case 4:
            System.out.println("You are creating a playlist");
            System.out.println("Digit the user nickname");
            nickname = reader.next();
            System.out.println("Digit the playlist name:");
            namePlaylist = reader.next();
            System.out.println("Digit the type of playlist is this \n"+
            "1.Songs\n"+
            "2.Podcast\n"+
            "3.Podcast and Songs");
            type = validateIntegerOption();

            if(type>4||type<1){
                System.out.println("Only valid options...");
            }
            else{
                System.out.println(streaming.registerPlaylist(nickname, namePlaylist, type));
            }
				break; 

			case 5:
            System.out.println("You are editing a playlist");
            System.out.println("Enter the nickname of the consumer user:");
            nickname = reader.next();

            System.out.println("You want to do what: \n"+
            "1.Delete an audio\n"+
            "2.Add an audio to playlist" );

            type = validateIntegerOption();
            if((type ==1 || type ==2)&& type !=-1){
                System.out.println("Digit the name of the playlist");
                namePlaylist = reader.next();
                System.out.println("Digit the name of the audio: ");
                nameAudio = reader.next();

                System.out.println(streaming.editAudioPlaylist(nickname, type, namePlaylist, nameAudio));
            }
            else{
                System.out.println("Only valid options...");
            }	
				break;

			case 6: 

			
				break;

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}
	/**
	validateDoubleOption: This method make that the system doesnt close when a option is invalid
	@return option: the option of the user. 
	*/
    public double validDoubleOption(){
        double option = 0;

        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }
        else{
            reader.nextLine();
            option = -1;
        }
        return option;

    }
    
}

