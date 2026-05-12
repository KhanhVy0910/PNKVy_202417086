
package hust.soict.dsai.aims;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        //Create a new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger allers",87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        //print total cost of the items in the cart
        System.out.println("Total cost is:");
        System.out.println(anOrder.totalCost());
        // display cart
        anOrder.displayCart();
        // remove dvd1
        anOrder.removeDigitalVideoDisc(dvd1);
        // display cart
        anOrder.displayCart();
        // remove dvd1, dvd2, dvd3
        anOrder.removeDigitalVideoDisc(dvd1);
        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.removeDigitalVideoDisc(dvd3);
        //display
        anOrder.displayCart();


    }
}
