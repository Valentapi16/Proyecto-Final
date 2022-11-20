package model;

public class Song extends Audio {
    
    private String urlAlbum;
    private int amountOfSales;
    private double cost;
    private TypeGenre typeGenre;

    public Song(String nameAudio, String url, int durationAudio, String urlAlbum, double cost, int option){
        super(nameAudio, url, durationAudio);
        this.urlAlbum= urlAlbum;
        this.cost= cost;
        this.amountOfSales= 0;

        switch(option){
            case 1:
            typeGenre= TypeGenre.HOUSE;
            
            
            case 2:
            typeGenre = TypeGenre.POP;
            

            case 3:
            typeGenre = TypeGenre.ROCK;
            

            case 4:
            typeGenre = TypeGenre.TRAP;
            

        }
    }

    public String getAlbum() {
        return urlAlbum;
    }


    public void setAlbum(String urlAlbum) {
        this.urlAlbum = urlAlbum;
    }


    public double getCost() {
        return cost;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }


    public int getAmountSales() {
        return amountOfSales;
    }


    public void setNumberSales(int amountOfSales) {
        this.amountOfSales = amountOfSales;
    }


    public TypeGenre getTypeGenre() {
        return typeGenre;
    }


    public void setTypeGenre(TypeGenre typeGenre) {
        this.typeGenre = typeGenre;
    }

    public int typeGenre(){
        switch (typeGenre) {
            case HOUSE:
                return 1;
            case POP:
                return 2;
            case ROCK:
                return 3;
            case TRAP:
                return 4;
            default:
             return 0;
        }
    }  
    
    public String typeStringSong(){
        String  msj = ""; 
        switch(typeGenre){
        case HOUSE:
            msj = "House";
            return msj;
        case POP:
            msj = "Pop";
            return msj;
        case ROCK:
             msj = "Rock";
            return msj;
        case TRAP:
            msj = "Trap"; 
            return msj;
        default:
            return null; 
        }
    }
}
