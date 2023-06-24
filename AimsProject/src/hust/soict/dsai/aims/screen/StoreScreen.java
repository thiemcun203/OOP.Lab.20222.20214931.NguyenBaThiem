package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;
    
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book", ABORT));
        smUpdateStore.add(new JMenuItem("Add DVD", ABORT));
        smUpdateStore.add(new JMenuItem("Add CD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50 ));

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100,50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;

    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        ArrayList<Media> mediaInStore =  store.getItemsInStore();

        for(int i = 0; i< mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        return center;
    }

public StoreScreen(Store store,Cart cart){
    this.store = store;
    this.cart = cart;
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(createNorth(), BorderLayout.NORTH);
    cp.add(createCenter(), BorderLayout.CENTER);

    setVisible(true);
    setTitle("Store");
    setSize(1024,768);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public static void main(String[] args){
    Store store = new Store();
    Cart cart = new Cart();
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);
        
        Book b1 = new Book("Digital Marketing","Science",20.00f );
        store.addMedia(b1);
        
        CompactDisc cD1 = new CompactDisc("Spider Man into multiverse","Animation Fiction", "Thiem cun", 120, 10.00f);
        store.addMedia(cD1);
        
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 29.99f);
        store.addMedia(dvd4);
        
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 14.95f);
        store.addMedia(dvd5);
        
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 17.99f);
        store.addMedia(dvd6);
        
        Book b2 = new Book("The Great Gatsby", "Fiction", 12.99f);
        store.addMedia(b2);

         Book b3 = new Book("The Catcher in the Rye", "Fiction", 10.99f);
        store.addMedia(b3);
        
        CompactDisc cD2 = new CompactDisc("Taylor Swift - 1989", "Pop", "Taylor Swift", 60, 12.50f);
        store.addMedia(cD2);
        
        // CompactDisc cD3 = new CompactDisc("Queen - Greatest Hits", "Rock", "Queen", 90, 15.99f);
        // store.addMedia(cD3);


    new StoreScreen(store,cart);
}
}




