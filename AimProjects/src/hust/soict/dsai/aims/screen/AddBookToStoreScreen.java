package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private final JTextField tfTitle = new JTextField();
    private final JTextField tfCategory = new JTextField();
    private final JTextField tfCost = new JTextField();
    private final JTextField tfAuthor = new JTextField();

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book To Store");
        add(createForm(), java.awt.BorderLayout.CENTER);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.add(new JLabel("Title"));
        panel.add(tfTitle);
        panel.add(new JLabel("Category"));
        panel.add(tfCategory);
        panel.add(new JLabel("Cost"));
        panel.add(tfCost);
        panel.add(new JLabel("Author"));
        panel.add(tfAuthor);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
                book.addAuthor(tfAuthor.getText());
                store.addMedia(book);
                openStoreScreen();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Add Book Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(new JLabel());
        panel.add(saveButton);
        return panel;
    }
}
