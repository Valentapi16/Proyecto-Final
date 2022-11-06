package model;

public abstract class Audio {

    private String nameAudio;
    private String url;
    private int durationAudio;
    private int amountOfViews;

    public Audio(String nameAudio, String url, int durationAudio){
        this.nameAudio=nameAudio;
        this.url = url;
        this.durationAudio= durationAudio;
        amountOfViews= 0;
    }

    
    public String getName() {
        return nameAudio;
    }


    public void setName(String nameAudio) {
        this.nameAudio = nameAudio;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public int getDuration() {
        return durationAudio;
    }


    public void setDuration(int durationAudio) {
        this.durationAudio = durationAudio;
    }


    public int getView() {
        return amountOfViews;
    }


    public void setView(int amountOfViews) {
        this.amountOfViews = amountOfViews;
    }

    



    
    
}
