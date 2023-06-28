package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddCompactDiscToStoreScreenController {
    private Store store;
    private Runnable windowCloser;
    private Cart cart;

    public AddCompactDiscToStoreScreenController(Store store, Cart cart, Runnable windowCloser){
        super();
        this.store = store;
        this.cart = cart;
        this.windowCloser = windowCloser;
    }

    @FXML
    private MenuItem addBook;

    @FXML
    private MenuItem addCD;

    @FXML
    private MenuItem addDVD;

    @FXML
    private Button addCDToStore;

    @FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextField director;

    @FXML
    private TextField length;

    @FXML
    private TextField title;

    @FXML
    private MenuItem viewCart;

    @FXML
    private MenuItem viewStore;

    @FXML
    private void initialize(){

    addCDToStore.setOnAction(e ->{
    String tTitle = title.getText();
    String tCategory = category.getText();
    String tDirector = director.getText();
    Integer tLength = Integer.valueOf(length.getText());
    Float tCost = Float.valueOf(cost.getText());
    CompactDisc dvd = new CompactDisc(tTitle, tCategory, tDirector, tLength, tCost);
    store.addMedia(dvd);
    title.clear();
    category.clear();
    director.clear();
    length.clear();
    cost.clear();
    
    });
    viewStore.setOnAction(e -> {
        windowCloser.run();
        new StoreScreen(store, cart);

    });

    viewCart.setOnAction(e -> {
        windowCloser.run();
        new CartScreen(cart,store);
    });

    addBook.setOnAction(e -> {
        windowCloser.run();
        new AddBookToStoreScreen(store, cart);
    });

    addDVD.setOnAction(e -> {
        windowCloser.run();
        new AddDigitalVideoDiscToStoreScreen(store, cart);
    });
    
    

    
    }
    

}
