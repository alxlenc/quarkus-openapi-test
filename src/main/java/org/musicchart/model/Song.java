package org.musicchart.model;

public class Song {

    private final Integer position;
    private final String title;
    private final String artist;

    public Song(Integer position, String title, String artist) {
        this.position = position;
        this.title = title;
        this.artist = artist;
    }

    public Integer getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
