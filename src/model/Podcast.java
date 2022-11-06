package model;

public class Podcast extends Audio {


    public String description;
    public TypePodcast typePodcast;

    public Podcast(String nameAudio, String url,int durationAudio,String description, int option){
        super(nameAudio,url,durationAudio);
        this.description = description;

        switch(option){
            case 1:
            typePodcast = TypePodcast.ENTERTAINMENT;
            break;

            case 2:
            typePodcast = TypePodcast.FASHION;
            break;

            case 3: 
            typePodcast = TypePodcast.POLITICS;
            break;

            case 4:
            typePodcast = TypePodcast.VIDEOGAMES;
        }
        
    }

    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public TypePodcast getTypePodcast(){
        return typePodcast;
    }

    public void setTypePodcast(TypePodcast typePodcast){
        this.typePodcast= typePodcast;
    }

    
}
