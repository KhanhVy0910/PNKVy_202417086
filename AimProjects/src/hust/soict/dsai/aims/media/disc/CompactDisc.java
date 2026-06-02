package hust.soict.dsai.aims.media.disc;

import java.util.NoSuchElementException;
import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, cost);
        setDirector(director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track da ton tai trong CD!");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        // Fail fast when the track is not present.
        if (!tracks.contains(track)) {
            throw new NoSuchElementException("Track not found in CD!");
        }
        tracks.remove(track);
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    @Override
    public void play() throws PlayerException {
        // Play the CD first, then delegate playback to each track.
        if (getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw e;
            }
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector()
                + " - " + artist + " - " + getLength() + ": " + getCost() + " $";
    }
}
