package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/14/2017.
 */
public class Collection {
    public static ArrayList<Album> albums;
    private ArrayList<Playlist> playlists;

    public Collection() {
        this.albums = new ArrayList<Album>();
        this.playlists = new ArrayList<Playlist>();
    }

    public void addAlbum(String albumName){
        Album album = findAlbum(albumName);
        if(album == null){
            Album newAlbum = new Album(albumName);
            albums.add(newAlbum);
            System.out.println(albumName+" added to album collection");
        } else {
            System.out.println("That album already exists");
        }
    }

    public void addSongToAlbum(String albumName, String songName, double duration){
        Album album = findAlbum(albumName);
        if(album == null){
            System.out.println("That album does not exist");
        } else {
            Song song = findSongInAlbum(album, songName);
            if(song == null){
                album.addSongToAlbum(songName, duration);
            } else {
                System.out.println("That song already exists in "+albumName);
            }
        }
    }

    public void addPlaylist(String playlistName){
        Playlist playlist = new Playlist(playlistName);
        playlists.add(playlist);
        System.out.println(playlistName+" added to playlist collection");
    }

    private Album findAlbum(String albumName){
        for (int i = 0; i < albums.size(); i++) {
            if(albums.get(i).getName().equalsIgnoreCase(albumName)){
                return albums.get(i);
            }
        }
        return null;
    }

    private Song findSongInAlbum(Album album, String songName){
        for (int i = 0; i < album.getSongs().size(); i++) {
            if(album.getSongs().get(i).getName().equalsIgnoreCase(songName)){
                return album.getSongs().get(i);
            }
        }
        return null;
    }
}
