package hust.soict.dsai.aims.screen;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
    private Cart cart;
    public CartScreen(Cart cart){
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable(){
            @override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/screen/fxml/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
