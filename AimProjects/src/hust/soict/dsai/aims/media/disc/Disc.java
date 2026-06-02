package hust.soict.dsai.aims.media.disc;

import hust.soict.dsai.aims.media.Media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, int length) {
        super(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        setLength(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative.");
        }
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director == null || director.isBlank()) {
            throw new IllegalArgumentException("Director must not be empty.");
        }
        this.director = director;
    }
}
