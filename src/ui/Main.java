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

    public String optionMenu( ){
        return
        "<<<<<Neotunes Streaming>>>>> \n\n" +
				"1. Register Users: Producers, artist and content creators\n" +
				"2. Register Users: Consumers, Estandar and Premium.\n" +
				"3. Register Songs and Podcasts.\n" + 
				"4. Create a Playlist.\n" +
				"5. Edit playlist.\n" +
				"6. Share a playlist.\n" +
				"7. consult if a particular apartment is available.\n" +
                "8. \n"+
                "9. \n"+
				"0. Exit. "; 
    }
    public void executeOption(int option){



		switch(option){
	


			case 2:


				
				break; 

			case 3: 


				break;

			case 4:

				break;

			case 5:


				break; 

			case 6:

				

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

