
package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id; // ID riêng của từng DVD
    
    // CLASS MEMBER (thuộc lớp, chung cho tất cả)
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++; // Tăng bộ đếm
        this.id = nbDigitalVideoDiscs; // Gán ID
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++; // Tăng bộ đếm
        this.id = nbDigitalVideoDiscs; // Gán ID
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++; // Tăng bộ đếm
        this.id = nbDigitalVideoDiscs; // Gán ID
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++; // Tăng bộ đếm
        this.id = nbDigitalVideoDiscs; // Gán ID
    }
    // Getter cho ID
    public int getId() {
        return id;
    }
    
    // Getter cho số lượng DVD (static method)
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
   
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }
    
      @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + 
               " - " + length + ": " + cost + " $";
    }
    
}