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

public class CartScreen extends JFrame{
    private Cart cart;
    private Store store;
    Runnable windowCloser = () -> SwingUtilities.invokeLater(
                () -> this.setVisible(false)
        );
    
    public CartScreen(Cart cart, Store store){
        super();
        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(new Dimension(1024,768));
        Platform.runLater(new Runnable(){
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("cart.fxml"));

                    CartScreenController controller = new CartScreenController(cart,store, windowCloser);
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
