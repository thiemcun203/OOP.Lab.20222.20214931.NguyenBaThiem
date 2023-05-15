package AimsProject.src;


public class Aims {
    public static void main(String[] args) {
        // create new cart
        Cart anOrder = new Cart();
        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        // anOrder.removeDigitalVideoDisc(dvd2);
        // System.out.println(anOrder.qtyOrdered);
        
        // Print total cost of the items in the cart
        System.out.print("Total cost is: " );
        System.out.print( anOrder.totalCost());
    }
}
