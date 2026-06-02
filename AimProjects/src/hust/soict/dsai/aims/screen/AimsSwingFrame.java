package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;

public abstract class AimsSwingFrame extends JFrame {
    protected final Store store;
    protected final Cart cart;

    protected AimsSwingFrame(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setJMenuBar(createMenuBar());
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenu options = new JMenu("Options");
        JMenu updateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> openAddBookScreen());
        JMenuItem addCd = new JMenuItem("Add CD");
        addCd.addActionListener(e -> openAddCompactDiscScreen());
        JMenuItem addDvd = new JMenuItem("Add DVD");
        addDvd.addActionListener(e -> openAddDigitalVideoDiscScreen());

        updateStore.add(addBook);
        updateStore.add(addCd);
        updateStore.add(addDvd);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> openStoreScreen());
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(e -> openCartScreen());

        options.add(updateStore);
        options.add(viewStore);
        options.add(viewCart);

        menuBar.add(options);
        return menuBar;
    }

    protected void openStoreScreen() {
        dispose();
        new StoreScreen(store, cart);
    }

    protected void openCartScreen() {
        dispose();
        new CartScreen(store, cart);
    }

    protected void openAddBookScreen() {
        dispose();
        new AddBookToStoreScreen(store, cart);
    }

    protected void openAddCompactDiscScreen() {
        dispose();
        new AddCompactDiscToStoreScreen(store, cart);
    }

    protected void openAddDigitalVideoDiscScreen() {
        dispose();
        new AddDigitalVideoDiscToStoreScreen(store, cart);
    }
}
