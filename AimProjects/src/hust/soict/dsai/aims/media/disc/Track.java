package hust.soict.dsai.aims.media.disc;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() { return title; }
    public int getLength() { return length;}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            return Objects.equals(title, track.getTitle()) && length == track.getLength();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
