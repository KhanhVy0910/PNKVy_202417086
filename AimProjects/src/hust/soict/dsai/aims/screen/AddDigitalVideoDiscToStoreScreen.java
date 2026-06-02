package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private final JTextField tfTitle = new JTextField();
    private final JTextField tfCategory = new JTextField();
    private final JTextField tfCost = new JTextField();
    private final JTextField tfDirector = new JTextField();
    private final JTextField tfLength = new JTextField();

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD To Store");
        add(createForm(), java.awt.BorderLayout.CENTER);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createForm() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.add(new JLabel("Title"));
        panel.add(tfTitle);
        panel.add(new JLabel("Category"));
        panel.add(tfCategory);
        panel.add(new JLabel("Cost"));
        panel.add(tfCost);
        panel.add(new JLabel("Director"));
        panel.add(tfDirector);
        panel.add(new JLabel("Length"));
        panel.add(tfLength);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                DigitalVideoDisc dvd = new DigitalVideoDisc(
                        tfTitle.getText(),
                        tfCategory.getText(),
                        tfDirector.getText(),
                        Integer.parseInt(tfLength.getText()),
                        Float.parseFloat(tfCost.getText()));
                store.addMedia(dvd);
                openStoreScreen();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Add DVD Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(new JLabel());
        panel.add(saveButton);
        return panel;
    }
}
