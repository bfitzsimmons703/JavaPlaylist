package com.brian;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Brian on 6/14/2017.
 */
public class Playlist {
    private String name;
    private LinkedList<Song> playlistSongs;


    public Playlist(String name) {
        this.name = name;
        this.playlistSongs = new LinkedList<>();
    }

    public void addSongToPlaylist(String songName){
        Song song = findSong(songName);
        if(song == null){
            System.out.println("That song does not exist. Please add it to an album first");
        } else {
            if(playlistSongs.contains(song)){
                System.out.println("This playlist already has that song");
            } else {
                playlistSongs.add(song);
                System.out.println(songName+" added to playlist "+this.name);
            }
        }
    }




    private Song findSong(String songName){
        ArrayList<Album> albums = Collection.albums;
        for (int i = 0; i < albums.size(); i++) {
            for (int j = 0; j < albums.get(i).getSongs().size(); j++) {
                Song song = albums.get(i).getSongs().get(j);
                if(song.getName().equalsIgnoreCase(songName)){
                    return song;
                }
            }
        }
        return null;
    }


    public LinkedList<Song> getPlaylistSongs() {
        return playlistSongs;
    }


}
