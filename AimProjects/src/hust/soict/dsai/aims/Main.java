package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.disc.Track;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Store store = createSampleStore();
        Cart cart = new Cart();
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }

    private static Store createSampleStore() {
        Store store = new Store();

        store.addMediaSilently(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMediaSilently(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMediaSilently(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        Book book = new Book("Effective Java", "Programming", 45.50f);
        book.addAuthor("Joshua Bloch");
        store.addMediaSilently(book);

        CompactDisc cd = new CompactDisc("Thriller", "Music", "Quincy Jones", "Michael Jackson", 29.95f);
        cd.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd.addTrack(new Track("Thriller", 358));
        store.addMediaSilently(cd);

        return store;
    }
}
