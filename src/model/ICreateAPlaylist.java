package model;

public interface ICreateAPlaylist {

    public Playlist findPlaylist(String namePlaylist);
    public boolean addPlaylist(String namePlaylist, int[][] matriz, String codePlaylist, int option);
    
}
