package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        // Enforce store uniqueness and capacity before adding.
        if (itemsInStore.contains(media)) {
            throw new IllegalStateException("Media already exists in store.");
        }
        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            throw new LimitExceededException("The store is full.");
        }
        itemsInStore.add(media);
        System.out.println("Added to store: " + media.getTitle());
    }

    public void addMediaSilently(Media media) {
        if (!itemsInStore.contains(media) && itemsInStore.size() < MAX_ITEMS_IN_STORE) {
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media) {
        // Remove only if the media is currently in the store.
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed from store: " + media.getTitle());
            return;
        }
        throw new java.util.NoSuchElementException("Media not found in store.");
    }

    public void displayStore() {
        System.out.println("*** STORE INVENTORY ***");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***********************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media searchByTitle(String title) {
        String normalizedTitle = title.trim();
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(normalizedTitle)) {
                return media;
            }
        }
        return null;
    }
}
