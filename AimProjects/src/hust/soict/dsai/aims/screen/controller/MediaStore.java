package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.Playable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class MediaStore extends JPanel {
    private final Media media;
    private final Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(e -> {
            try {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null,
                        media.getTitle() + " has been added to the cart!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Add To Cart Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        container.add(addToCartBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(e -> {
                JDialog dialog = new JDialog();
                dialog.setTitle("Playing: " + media.getTitle());
                dialog.setSize(300, 150);
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel("Now playing: " + media.getTitle()));
                dialog.setVisible(true);

                try {
                    ((Playable) media).play();
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Play Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
