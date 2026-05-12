package hust.soict.dsai.aims.media.disc;

public class Track {
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
            return title.equals(track.getTitle()) && length == track.getLength();
        }
        return false;
    }
}

