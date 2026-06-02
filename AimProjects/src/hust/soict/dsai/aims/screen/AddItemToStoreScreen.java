package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public abstract class AddItemToStoreScreen extends AimsSwingFrame {
    protected AddItemToStoreScreen(Store store, Cart cart, String title) {
        super(store, cart, title);
        setLayout(new BorderLayout());
    }
}
