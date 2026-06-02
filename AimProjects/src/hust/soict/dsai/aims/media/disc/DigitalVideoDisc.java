package hust.soict.dsai.aims.media.disc;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        assignId();
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        assignId();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        setDirector(director);
        assignId();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        assignId();
    }

    private void assignId() {
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector()
                + " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }
    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
