package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDigitalVideoDiscToStoreScreen extends JFrame{
    private Cart cart;
    private Store store;
    Runnable windowCloser = () -> SwingUtilities.invokeLater(
                () -> this.setVisible(false)
        );
    
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart){
        super();
        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Add DigitalVideoDisc To Store");
        this.setVisible(true);
        this.setSize(new Dimension(1024,768));
        Platform.runLater(new Runnable(){
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("AddDigitalVideoDiscToStoreScreen.fxml"));

                    AddDigitalVideoDiscToStoreScreenController controller = new AddDigitalVideoDiscToStoreScreenController(store,cart, windowCloser);
                    loader.setController(controller);
                    
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
