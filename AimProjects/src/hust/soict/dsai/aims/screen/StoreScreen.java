package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

public class StoreScreen extends AimsSwingFrame {
    public StoreScreen(Store store, Cart cart) {
        super(store, cart, "AIMS - Store");

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(createNorth(), BorderLayout.NORTH);
        contentPane.add(createCenter(), BorderLayout.CENTER);
        setContentPane(contentPane);

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(getJMenuBar());
        north.add(createHeader());
        return north;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton viewCartButton = new JButton("View cart");
        viewCartButton.setPreferredSize(new Dimension(100, 50));
        viewCartButton.setMaximumSize(new Dimension(100, 50));
        viewCartButton.addActionListener(e -> openCartScreen());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(viewCartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < Math.min(mediaInStore.size(), 9); i++) {
            center.add(new MediaStore(mediaInStore.get(i), cart));
        }
        return center;
    }
}
