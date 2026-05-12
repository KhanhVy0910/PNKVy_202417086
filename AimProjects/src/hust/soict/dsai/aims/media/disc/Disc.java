package hust.soict.dsai.aims.media.disc;

import hust.soict.dsai.aims.media.Media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
    }

    public Disc(String title, String category, String director, int length) {
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
