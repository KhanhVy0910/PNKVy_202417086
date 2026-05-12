package hust.soict.dsai.aims.media.disc;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        setTitle(title);
        assignId();
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        setCategory(category);
        setTitle(title);
        setCost(cost);
        assignId();
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        setDirector(director);
        setCategory(category);
        setTitle(title);
        setCost(cost);
        assignId();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
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
}
