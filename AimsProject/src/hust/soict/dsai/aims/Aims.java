package hust.soict.dsai.aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class Aims {
    public static void main(String[] args) {
        // create new cart
        Cart anOrder = new Cart();
        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);
        
        Book b1 = new Book("Digital Marketing","Science",20.00f );
        anOrder.addMedia(b1);
        
        CompactDisc cD1 = new CompactDisc( "Spider Man into multiverse","Animation Fiction", "Thiem cun", 120, 10.00f);
        anOrder.addMedia(cD1);
        System.out.print( dvd3.getLength()+"\n");
        // Print total cost of the items in the cart
        System.out.print("Total cost is: " );
        System.out.print( anOrder.totalCost()+"\n");
        
        // Create Arraylist of Media to use polymorphism
        ArrayList<Media> mediae = new ArrayList<Media>();
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(dvd3);
        mediae.add(b1);
        mediae.add(cD1);
        
        for (Media m: mediae){
            System.out.println(m.getId()+ ". " + m.getTitle()+ " " + m.getCategory() + " " + m.getCost());
        }
        // anOrder.print();

        
    }
}

