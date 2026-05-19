package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.disc.Track;

import java.util.ArrayList;

public class PolymorphismTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Effective Java", "Programming", 45.50f);
        book.addAuthor("Joshua Bloch");

        CompactDisc cd = new CompactDisc(
                "Thriller", "Music", "Quincy Jones", "Michael Jackson", 29.95f);
        cd.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd.addTrack(new Track("Thriller", 358));

        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
