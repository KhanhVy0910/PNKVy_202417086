package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.controller.CartScreenController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.IOException;

public class CartScreen extends JFrame {
    private final Store store;
    private final Cart cart;
    private final JFXPanel fxPanel;

    public CartScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        this.fxPanel = new JFXPanel();

        setTitle("AIMS - Cart");
        setLayout(new BorderLayout());
        add(fxPanel, BorderLayout.CENTER);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Platform.runLater(this::loadFxContent);
    }

    private void loadFxContent() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/hust/soict/dsai/aims/screen/fxml/cart-screen.fxml"));
            loader.setControllerFactory(type -> {
                if (type == CartScreenController.class) {
                    return new CartScreenController(store, cart);
                }
                try {
                    return type.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            Parent root = loader.load();
            fxPanel.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException("Cannot load cart-screen.fxml", e);
        }
    }
}
