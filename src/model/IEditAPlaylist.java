package model;

public interface IEditAPlaylist {

    public String deleteAudio(Audio audio, String namePlaylist, String nameAudio);
    public String addAudioToPlaylist(String namePlaylist, int typeAudio, Audio audio, String nameAudio );
    
}
