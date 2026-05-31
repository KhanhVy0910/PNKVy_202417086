package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;

public class CartSortingTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        cart.addMedia(new Book("Clean Code", "Programming", 29.95f));
        cart.addMedia(new CompactDisc("Abbey Road", "Music", "George Martin", "The Beatles", 19.95f));
        cart.addMedia(new Book("Algorithms", "Programming", 59.95f));

        System.out.println("Sort by title then cost:");
        cart.sortByTitleCost();
        cart.displayCart();

        System.out.println("Sort by cost then title:");
        cart.sortByCostTitle();
        cart.displayCart();
    }
}
