package hust.soict.dsai.aims.media;

import java.util.Objects;
import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        // Validate constructor input before creating the object.
        validateTitle(title);
        validateCost(cost);
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        validateCost(cost);
        this.cost = cost;
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty.");
        }
    }

    private void validateCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost must be non-negative.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        // Media objects are equal when their titles match.
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media media = (Media) obj;
        return Objects.equals(title, media.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
