package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.Playable;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.SwingUtilities;

public class CartScreenController {
    private Store store;
    private Cart cart;
    private FilteredList<Media> filteredMedia;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    public CartScreenController() {
    }

    public CartScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    public CartScreenController(Cart cart) {
        this(null, cart);
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        if (tblMedia != null) {
            bindTableToCart();
        }
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        if (cart != null) {
            bindTableToCart();
            refreshTotalCost();
        }

        tblMedia.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        } else {
                            btnPlay.setVisible(false);
                            btnRemove.setVisible(false);
                        }
                    }
                });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());

        if (cart != null) {
            cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
                refreshTotalCost();
                showFilteredMedia();
            });
        }
    }

    @FXML
    private void playSelectedMedia() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
            } catch (PlayerException ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null && cart != null) {
            try {
                cart.removeMedia(selectedMedia);
                tblMedia.getSelectionModel().clearSelection();
            } catch (RuntimeException ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
            }
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        playSelectedMedia();
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart == null) {
            return;
        }
        try {
            cart.clear();
            tblMedia.getSelectionModel().clearSelection();
            refreshTotalCost();
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            new Alert(Alert.AlertType.INFORMATION, "An order is created.").showAndWait();
        } catch (RuntimeException ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
        }
    }

    @FXML
    void viewStorePressed(ActionEvent event) {
        if (store == null || cart == null) {
            return;
        }
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }

    @FXML
    void viewCartPressed(ActionEvent event) {
        if (store == null || cart == null) {
            return;
        }
        SwingUtilities.invokeLater(() -> new CartScreen(store, cart));
    }

    private void bindTableToCart() {
        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredMedia);
        showFilteredMedia();
        refreshTotalCost();
    }

    private void showFilteredMedia() {
        if (filteredMedia == null) {
            return;
        }

        String filterText = tfFilter.getText();
        if (filterText == null || filterText.isBlank()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }

        if (radioBtnFilterId.isSelected()) {
            try {
                int id = Integer.parseInt(filterText.trim());
                filteredMedia.setPredicate(media -> media.getId() == id);
            } catch (NumberFormatException e) {
                filteredMedia.setPredicate(media -> false);
            }
        } else if (radioBtnFilterTitle.isSelected()) {
            String normalized = filterText.trim().toLowerCase();
            filteredMedia.setPredicate(media -> media.getTitle() != null
                    && media.getTitle().toLowerCase().contains(normalized));
        } else {
            filteredMedia.setPredicate(media -> true);
        }
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        boolean canPlay = media instanceof Playable;
        btnPlay.setVisible(canPlay);
    }

    private void refreshTotalCost() {
        if (lblTotalCost != null && cart != null) {
            lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
        }
    }
}
