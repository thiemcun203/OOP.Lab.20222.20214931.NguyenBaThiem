package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddDigitalVideoDiscToStoreScreenController {
    private Store store;
    private Runnable windowCloser;
    private Cart cart;

    public AddDigitalVideoDiscToStoreScreenController(Store store, Cart cart, Runnable windowCloser){
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
    private Button addDVDToStore;

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

    addDVDToStore.setOnAction(e ->{
    String tTitle = title.getText();
    String tCategory = category.getText();
    String tDirector = director.getText();

    Integer tLength = Integer.valueOf(length.getText());
    Float tCost = Float.valueOf(cost.getText());
    if (tLength > 0 && tCost >0){
    
    DigitalVideoDisc dvd = new DigitalVideoDisc(tTitle, tCategory, tDirector, tLength, tCost);
    store.addMedia(dvd);
    title.clear();
    category.clear();
    director.clear();
    length.clear();
    cost.clear();
    }
    if (tLength <= 0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Illegal DVD Length");
        alert.setHeaderText(null);
        alert.setContentText("ERROR: DVD Length is non-positive");
        alert.showAndWait();
    }
    if (tCost <= 0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Illegal DVD Cost");
        alert.setHeaderText(null);
        alert.setContentText("ERROR: DVD Cost is non-positive real number");
        alert.showAndWait();
    }
        
        
    });

    viewStore.setOnAction(e -> {
        windowCloser.run();
        new StoreScreen(store, cart);

    });

    viewCart.setOnAction(e -> {
        windowCloser.run();
        new CartScreen(cart,store);
    });
    addCD.setOnAction(e -> {
        windowCloser.run();
        new AddCompactDiscToStoreScreen(store, cart);
    });
    addBook.setOnAction(e -> {
        windowCloser.run();
        new AddBookToStoreScreen(store, cart);
    });
    

    
    }
    

}
