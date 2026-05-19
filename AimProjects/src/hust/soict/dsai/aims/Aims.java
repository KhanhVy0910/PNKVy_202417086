package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.disc.Playable;
import hust.soict.dsai.aims.media.disc.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        initializeStore();

        int choice;
        do {
            showMenu();
            choice = readInt();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void initializeStore() {
        store.addMediaSilently(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMediaSilently(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMediaSilently(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        Book book = new Book("Effective Java", "Programming", 45.50f);
        book.addAuthor("Joshua Bloch");
        store.addMediaSilently(book);

        CompactDisc cd = new CompactDisc("Thriller", "Music", "Quincy Jones", "Michael Jackson", 29.95f);
        cd.addTrack(new Track("Wanna Be Startin' Somethin'", 363));
        cd.addTrack(new Track("Thriller", 358));
        store.addMediaSilently(cd);
    }

    private static void viewStore() {
        int choice;
        do {
            store.displayStore();
            storeMenu();
            choice = readInt();
            switch (choice) {
                case 1:
                    showMediaDetails();
                    break;
                case 2:
                    addStoreMediaToCart();
                    break;
                case 3:
                    playStoreMedia();
                    break;
                case 4:
                    viewCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    private static void showMediaDetails() {
        Media media = askStoreMediaByTitle();
        if (media == null) {
            return;
        }

        System.out.println(media);
        int choice;
        do {
            mediaDetailsMenu();
            choice = readInt();
            switch (choice) {
                case 1:
                    addToCart(media);
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    private static void addStoreMediaToCart() {
        Media media = askStoreMediaByTitle();
        if (media != null) {
            addToCart(media);
        }
    }

    private static void playStoreMedia() {
        Media media = askStoreMediaByTitle();
        if (media != null) {
            playMedia(media);
        }
    }

    private static void updateStore() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        int choice = readInt();

        switch (choice) {
            case 1:
                store.addMedia(createMediaFromInput());
                break;
            case 2:
                Media media = askStoreMediaByTitle();
                if (media != null) {
                    store.removeMedia(media);
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void viewCart() {
        int choice;
        do {
            cart.displayCart();
            cartMenu();
            choice = readInt();
            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playCartMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    private static void filterCart() {
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        int choice = readInt();
        if (choice == 1) {
            System.out.print("Enter id: ");
            cart.searchById(readInt());
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            cart.searchByTitle(scanner.nextLine());
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void sortCart() {
        System.out.println("1. Sort by title then cost");
        System.out.println("2. Sort by cost then title");
        int choice = readInt();
        if (choice == 1) {
            cart.sortByTitleCost();
            cart.displayCart();
        } else if (choice == 2) {
            cart.sortByCostTitle();
            cart.displayCart();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void removeMediaFromCart() {
        Media media = askCartMediaByTitle();
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    private static void playCartMedia() {
        Media media = askCartMediaByTitle();
        if (media != null) {
            playMedia(media);
        }
    }

    private static void placeOrder() {
        System.out.println("An order is created.");
        cart.clear();
    }

    private static Media askStoreMediaByTitle() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("No media found with title: " + title);
        }
        return media;
    }

    private static Media askCartMediaByTitle() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        Media media = cart.searchMediaByTitle(title);
        if (media == null) {
            System.out.println("No media found in cart with title: " + title);
        }
        return media;
    }

    private static void addToCart(Media media) {
        cart.addMedia(media);
        if (media instanceof DigitalVideoDisc) {
            System.out.println("Number of DVDs in current cart: " + cart.getNumberOfDVDs());
        }
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static Media createMediaFromInput() {
        System.out.println("Choose media type:");
        System.out.println("1. DVD");
        System.out.println("2. CD");
        System.out.println("3. Book");
        int type = readInt();

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = readFloat();

        if (type == 1) {
            System.out.print("Director: ");
            String director = scanner.nextLine();
            System.out.print("Length: ");
            int length = readInt();
            return new DigitalVideoDisc(title, category, director, length, cost);
        }

        if (type == 2) {
            System.out.print("Director: ");
            String director = scanner.nextLine();
            System.out.print("Artist: ");
            String artist = scanner.nextLine();
            return new CompactDisc(title, category, director, artist, cost);
        }

        Book book = new Book(title, category, cost);
        System.out.print("Author: ");
        book.addAuthor(scanner.nextLine());
        return book;
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static float readFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Please enter a valid cost.");
            scanner.nextLine();
        }
        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
    }
}
