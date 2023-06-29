package hust.soict.dsai.aims.screen;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController {
    private Cart cart;
    private Store store;
    private Runnable windowCloser;
    public CartScreenController(Cart cart, Store store, Runnable windowCloser){
        super();
        this.cart = cart;
        this.store = store;
        this.windowCloser = windowCloser;
    }

    
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label totalCost;

    @FXML
    private MenuItem addBook;

    @FXML
    private MenuItem addCD;

    @FXML
    private MenuItem addDVD;


    @FXML
    private MenuItem viewCart;

    @FXML
    private MenuItem viewStore;

    @FXML
    private void initialize(){
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title")
        );
        colMediacategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost")
        );
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // add listner to each row if change from this row to other row it will updateButtonbar
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>(){
                    
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                if (newValue != null){
                    updateButtonBar(newValue); //in other cases, it can update total cost, color, ,...
                }
            }
            }
        );

        btnRemove.setOnAction(e -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            cart.removeMedia(media);
            updateTotalCost();

        });

        btnPlay.setOnAction(e -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playback");
            alert.setHeaderText(null);
            alert.setContentText("Playing" + media.getTitle() + "\n" + media.getCategory() + "\n" +media.getCost()+" $");
            alert.showAndWait();
        });
        updateTotalCost();

        btnPlaceOrder.setOnAction(e -> {
            // we need click to table first then place order
            for (int i = tblMedia.getItems().size()-1  ;i>-1;i--){
                        cart.removeMedia(tblMedia.getSelectionModel().getSelectedItem());
                    }

            updateTotalCost();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Your Order is being processed");
            alert.showAndWait();
        });

        viewStore.setOnAction(e ->{
            
            new StoreScreen(store, cart);
            
        });

        addDVD.setOnAction(e -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            windowCloser.run();
        });
        addCD.setOnAction(e -> {
            new AddCompactDiscToStoreScreen(store, cart);
            windowCloser.run();
        });
        addBook.setOnAction(e -> {
            new AddBookToStoreScreen(store, cart);
            windowCloser.run();
        });


        
        //if other text included empty changed, we can show filter media, given selecting radio
        // it means we have to select radio at first
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                showFilteredMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(false);
        }
    }
    void updateTotalCost(){
        float tCost = cart.totalCost();
        totalCost.setText(String.format("%.2f $", tCost));
    }
    
    void showFilteredMedia(String newValue) {
    if (radioBtnFilterId.isSelected()) {
        Predicate<Media> filterPredicate = item -> item.getId() == Integer.parseInt(tfFilter.getText()); //condition to filter
        ObservableList<Media> filteredItems = cart.getItemsOrdered() 
            .stream()
            .filter(filterPredicate)
            .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tblMedia.setItems(filteredItems);
    }

    if (radioBtnFilterTitle.isSelected()) {
        String text = tfFilter.getText();
        Predicate<Media> filterPredicate = item -> item.getTitle().equalsIgnoreCase(text); //condition to filter
        ObservableList<Media> filteredItems = cart.getItemsOrdered() 
            .stream()
            .filter(filterPredicate)
            .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tblMedia.setItems(filteredItems);
    }
    
    viewCart.setOnAction(e -> {
        windowCloser.run();
        new CartScreen(cart,store);
    });
    
    
}

    

}


// for other way to set action Remove in javafx

    // @FXML
    // void btnRemovePressed(ActionEvent event){
    //     Media media = tblMedia.getSelectionModel().getSelectedItem();
    //     cart.removeMedia(media);
    // }