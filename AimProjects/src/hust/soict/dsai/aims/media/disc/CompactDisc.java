package hust.soict.dsai.aims.media.disc;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Chỉ tạo getter cho artist
    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track đã tồn tại trong CD!");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track không tồn tại trong CD!");
        } else {
            tracks.remove(track);
        }
    }

    // Độ dài CD = tổng độ dài tất cả các track
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        // phat tung track
        for (Track track : tracks) {
            track.play();
        }
    }
}
