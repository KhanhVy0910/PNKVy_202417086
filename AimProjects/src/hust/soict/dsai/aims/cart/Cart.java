package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERD = 20;
    private ObservableList<Media> itemsOrdered =
            FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            throw new IllegalStateException("Media already exists in cart.");
        }
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERD) {
            throw new LimitExceededException("Cart is full.");
        }
        itemsOrdered.add(media);
        System.out.println("Added ! " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed ! " + media.getTitle());
            return;
        }
        throw new java.util.NoSuchElementException("Media not found in cart.");
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public Media searchMediaByTitle(String title) {
        String normalizedTitle = title.trim();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(normalizedTitle)) {
                return media;
            }
        }
        return null;
    }

    public int getNumberOfDVDs() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        System.out.println(" CART (" + itemsOrdered.size() + "/" + MAX_NUMBERS_ORDERD + " items)");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }
        System.out.printf("Total Cost: $%.2f%n", totalCost());
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found: " + itemsOrdered.get(i).toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search results for \"" + title + "\":");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No match found!");
        }
    }
}
