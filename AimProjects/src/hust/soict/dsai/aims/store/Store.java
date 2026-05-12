package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;


public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int itemCount = 0;
    
    public void addDVD(DigitalVideoDisc dvd) {
        if (itemCount < MAX_ITEMS_IN_STORE) {
            itemsInStore[itemCount] = dvd;
            itemCount++;
            System.out.println("Added to store: " + dvd.getTitle());
        } 
        else {
            System.out.println("Store is full!");
        }
    }
    
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i].equals(dvd)) {
                // Shift elements
                for (int j = i; j < itemCount - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[itemCount - 1] = null;
                itemCount--;
                found = true;
                System.out.println("Removed from store: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in store!");
        }
    }
    
    public void displayStore() {
        System.out.println("*** STORE INVENTORY ***");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***********************");
    }
}
