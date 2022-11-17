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

    public int typePodcast(){
        switch (typePodcast) {
            case ENTERTAINMENT:
                return 1;
            case FASHION:
                return 2;
            case POLITICS:
                return 3;
            case VIDEOGAMES:
                return 4;
            default:
             return 0;
     }  

    }

    public String typeStringPodcast(){
        String msj = ""; 
        switch(typePodcast){
        case ENTERTAINMENT:
             msj = "Entertainment";
            return msj;
        case FASHION:
             msj = "Fashion";
            return msj;
        case POLITICS:
             msj = "Politics";
            return msj;
        case VIDEOGAMES:
             msj = "Videogames";
            return msj;
        default:
            return null;  

        }
    }

    
}
