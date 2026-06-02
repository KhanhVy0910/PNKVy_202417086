package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            return;
        }
        throw new NoSuchElementException("Author not found: " + authorName);
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - "
                + authors + ": " + getCost() + " $";
    }
}
