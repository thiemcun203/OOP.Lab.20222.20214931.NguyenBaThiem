package hust.soict.dsai.aims.screen;

import javax.swing.event.ChangeListener;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(null);

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    public CartScreenController(Cart cart){
        super();
        this.cart = cart;
    }
    @FXML
    private void initialize(){
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title");
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

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>(){

            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                if (newValue != null){
                    updateButtonBar(newValue);
                }
            }
            }
        );

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




}
