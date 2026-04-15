
package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBERS_ORDERD = 20;
    private DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERD];
    private int qtyOrdered = 0;

    // them dvd vao gio hang
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    if(qtyOrdered == MAX_NUMBERS_ORDERD){
        System.out.println("The cart is full. Cannot add \"" + disc.getTitle() + "\".");
        return;  
    }
    
    // Thêm disc vào mảng
    itemsOrdered[qtyOrdered] = disc;
    qtyOrdered++;
    System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
    
    if(qtyOrdered == MAX_NUMBERS_ORDERD){
        System.out.println("The cart is full!");
    } else if(qtyOrdered >= MAX_NUMBERS_ORDERD - 2) {
        System.out.println("The cart is almost full!");
    }
}
    // them so luong dvd tuy y
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERD) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
            } else {
                System.out.println("The cart is full");
                break;
            }
        }
        System.out.println("Added discs to cart");
    }
    // them 2 dia dvd
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    // xoa phan tu duoc truyen vao qua tham so khoi danh sach
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        
        for(int i = 0; i < qtyOrdered; i ++) {
            if(itemsOrdered[i] == disc) {
                found = true;
                for(int j = i; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1]  = null;
                qtyOrdered--;
                System.out.println("the disc \"" + disc.getTitle() +"\" has been removed");
                break;
            }
        }
        if(!found){
                System.out.println("Disc \"" + disc.getTitle() + "\" not found in the cart.");
        }
    }
    // tinh tong chi phi
    public float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i ++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
     // hien thi gio hang
    public void displayCart() {
        if(qtyOrdered == 0) {
            System.out.println("Empty");
            return;
        }
        System.out.println(" CART (" + qtyOrdered + "/" + MAX_NUMBERS_ORDERD + " items)");
        for(int i = 0; i < qtyOrdered; i ++) {
            System.out.println((i+1) + " ." + itemsOrdered[i]);
        }
        System.out.printf("Total Cost: $%.2f%n", totalCost());
    }
    public int getQtyOrdered(){
        return qtyOrdered;
    }
}
