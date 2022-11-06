package model;

public class Song extends Audio {
    
    public String urlAlbum;
    public int amountOfSales;
    public double cost;
    public TypeGenre typeGenre;

    public Song(String nameAudio, String url, int durationAudio, String urlAlbum, double cost, int option){
        super(nameAudio, urlAlbum, durationAudio);
        this.urlAlbum= urlAlbum;
        this.cost= cost;
        this.amountOfSales= 0;

        switch(option){
            case 1:
            typeGenre= TypeGenre.HOUSE;
            break;
            
            case 2:
            typeGenre = TypeGenre.POP;
            break;

            case 3:
            typeGenre = TypeGenre.ROCK;
            break;

            case 4:
            typeGenre = TypeGenre.TRAP;
            break;

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


    public void setPrice(double cost) {
        this.cost = cost;
    }


    public int getAmountSales() {
        return amountOfSales;
    }


    public void setNumberSales(int amountOfSales) {
        this.amountOfSales = amountOfSales;
    }


    public TypeGenre getTypeSong() {
        return typeGenre;
    }


    public void setTypeSong(TypeGenre typeGenre) {
        this.typeGenre = typeGenre;
    }
    



}
