package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/14/2017.
 */
public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSongToAlbum(String songName, double duration){
        Song song = new Song(songName, duration);
        songs.add(song);
        System.out.println("Successfully added "+songName+" to "+this.name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
