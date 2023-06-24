package hust.soict.dsai.aims.screen;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
// import javax.swing.border.Border;
import hust.soict.dsai.aims.media.*;

import java.awt.*;
import java.awt.event.*;


public class MediaStore extends JPanel{
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart){
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle(), null, 0);
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel cost = new JLabel(""+ media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        ButtonListener btnListener = new ButtonListener();


        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);
        btnAddToCart.addActionListener(btnListener);
        
        if (media instanceof Playable){
            
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(btnListener);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        
        

    }


    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            String button = e.getActionCommand();
            if (button.equals("Play")){
                JOptionPane.showMessageDialog(MediaStore.this, "Playing " + media.getTitle() + "\n" + media.getCategory() + "\n" +media.getCost()+" $" );

            }
            else if (button.equals("Add to cart")){
                JOptionPane pane = new JOptionPane("Add to cart successffuly", JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = pane.createDialog(null, "Notification");

                // Set time exits
                Timer timer = new Timer(800, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
                });

                // //RUN
                timer.start();
                dialog.setVisible(true);
            }
        }
    }





}




   

