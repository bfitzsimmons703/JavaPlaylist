package com.brian;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static Collection collection = new Collection();
    public static Playlist playlist = new Playlist("BeatlesRock");

    public static void main(String[] args) {
	    collection.addAlbum("Let It Be");

        collection.addSongToAlbum("Let It Be", "Hey Jude", 4.00);
        collection.addSongToAlbum("Let It Be", "Let It Be", 4.00);
        collection.addSongToAlbum("Let It Be", "Roxanne", 4.00);
        collection.addSongToAlbum("Let It Be", "Sunday Morning", 4.00);
        collection.addSongToAlbum("Let It Be", "Hey Ya", 4.00);

        playlist.addSongToPlaylist("Let It Be");
        playlist.addSongToPlaylist("Hey Jude");
        playlist.addSongToPlaylist("Roxanne");
        playlist.addSongToPlaylist("Sunday Morning");
        playlist.addSongToPlaylist("Hey Ya");

        start();
    }

    public static void printOptions(){
        System.out.println("----------------------------");
        System.out.println("0 - quit");
        System.out.println("1 - next song");
        System.out.println("2 - previous song");
        System.out.println("3 - replay song");
        System.out.println("4 - remove song from playlist");
        System.out.println("5 - list songs in playlist");
    }

    public static void start(){
        Scanner scanner = new Scanner(System.in);
        LinkedList<Song> songs = playlist.getPlaylistSongs();
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> songListIterator = songs.listIterator();

        if(songs.isEmpty()){
            System.out.println("No songs in your playlist!");
            return;
        } else {
            System.out.println("Now playing "+songListIterator.next().getName());
            printOptions();
        }

        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Now exiting...");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(songListIterator.hasNext()){
                            songListIterator.next();
                        }
                        forward = true;
                    }
                    if(songListIterator.hasNext()){
                        System.out.println("Now playing "+songListIterator.next().getName());
                        printOptions();
                    } else {
                        System.out.println("All done!");
                        printOptions();
                    }
                    break;
                case 2:
                    if(forward){
                        if(songListIterator.hasPrevious()){
                            songListIterator.previous();
                        }
                        forward = false;
                    }
                    if(songListIterator.hasPrevious()){
                        System.out.println("Now playing "+songListIterator.previous().getName());
                        printOptions();
                    } else {
                        System.out.println("You're at the beginning!");
                        printOptions();
                    }
                    break;
                case 3:
                    if(forward){
                        if(songListIterator.hasPrevious()){
                            System.out.println("Replaying "+songListIterator.previous().getName());
                            forward = false;
                        } else {
                            System.out.println("We're at the start of the list");
                        }
                    } else {
                        if(songListIterator.hasNext()){
                            System.out.println("Replaying "+songListIterator.next().getName());
                            forward = true;
                        } else {
                            System.out.println("We're at the end of the playlist!");
                        }
                    }
                    printOptions();
                    break;
                case 4:
                    System.out.println("Removing song...");
                    songListIterator.remove();
                    if(songListIterator.hasNext()){
                        System.out.println("Now playing "+songListIterator.next().getName());
                    } else if(songListIterator.hasPrevious()){
                        System.out.println("Now playing "+songListIterator.previous().getName());
                    }
                    printOptions();
                    break;
                case 5:
                    printSongs();
                    printOptions();
            }
        }
    }

    public static void printSongs(){
        System.out.println("------------------------");
        Iterator<Song> iterator = playlist.getPlaylistSongs().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }
}
