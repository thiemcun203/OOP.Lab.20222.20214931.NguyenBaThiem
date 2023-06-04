package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class TestPolymophism {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        Book b1 = new Book("Digital Marketing","Science",20.00f );

        CompactDisc cD1 = new CompactDisc( "Spider Man into multiverse","Animation Fiction", "Thiem cun", 120, 10.00f);

        // Create Arraylist of Media to use polymorphism
        ArrayList<Media> mediae = new ArrayList<Media>();
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(dvd3);
        mediae.add(b1);
        mediae.add(cD1);
        
        for (Media m: mediae){
            System.out.println(m.toString());
        }
    }
}
