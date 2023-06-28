package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddBookToStoreScreenController {
    private Store store;
    private Runnable windowCloser;
    private Cart cart;

    public AddBookToStoreScreenController(Store store, Cart cart, Runnable windowCloser){
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
    private Button addBookToStore;

    @FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextField title;

    @FXML
    private MenuItem viewCart;

    @FXML
    private MenuItem viewStore;

    @FXML
    private void initialize(){

        addBookToStore.setOnAction(e ->{
        String tTitle = title.getText();
        String tCategory = category.getText();
        Float tCost = Float.valueOf(cost.getText());
        Book book = new Book(tTitle, tCategory,  tCost);
        store.addMedia(book);
        title.clear();
        category.clear();
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

    addDVD.setOnAction(e -> {
        windowCloser.run();
        new AddDigitalVideoDiscToStoreScreen(store, cart);
    });

    addCD.setOnAction(e -> {
        windowCloser.run();
        new AddCompactDiscToStoreScreen(store, cart);
    });
    

    
    }
    

}
