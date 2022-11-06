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
            option = main.getOptionShowMenu();
            main.executeOption(option);
        }while(option != 0);

        main.getReader().close();
    }

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

    public int getOptionShowMenu(){
        int option = 0;
        System.out.println(optionMenu());
        option = validateIntegerOption();
        return option;
    }

    public int optionMenu( ){
        int option = 0;
        
       System.out.println("<<<<<Neotunes Streaming>>>>> \n\n" +
				"1. Register Users: Producers, artist and content creators\n" +
				"2. Register Users: Consumers, Estandar and Premium.\n" +
				"3. Register Songs or Podcasts.\n" + 
				"4. Create a Playlist.\n" +
				"5. Edit playlist.\n" +
				"6. Share a playlist.\n" +
				"7. consult if a particular apartment is available.\n" +
                "8. \n"+
                "9. \n"+
				"0. Exit. "); 
        option = validateIntegerOption();
        return option;
    }
    public void executeOption(int option){
        String name,nickname,urlAlbum,id,urlImage,description,namePlaylist, audio = " ";
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
            

				break;

			case 4:


				break; 

			case 5:

				

				break;

			case 7: 

				

				break;

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}
    
}

