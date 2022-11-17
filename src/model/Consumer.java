package model;

import java.util.Calendar;



public abstract class Consumer extends User {



    public Consumer(String id, String nickname, Calendar vinculationDate, Calendar purchaseDate){
        super(id, nickname, vinculationDate, purchaseDate);
        
    }

    public abstract String sharePlaylist(String namePlaylist);
    public abstract String shareMatrizPlaylist(String namePlaylist);
    public abstract String showMatriz(int[][] matrix);

    
}
