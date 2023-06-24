package hust.soict.dsai.aims.screen;
import javax.swing.*;
// import javax.swing.border.Border;
import hust.soict.dsai.aims.media.*;

import java.awt.*;
import java.awt.event.*;


public class MediaStore extends JPanel{
    private Media media;

    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle(), null, 0);
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel cost = new JLabel(""+ media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(new JButton("Add to cart"));
        if (media instanceof Playable){
            ButtonListener btnPlayListener = new ButtonListener();
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(btnPlayListener);
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

            JOptionPane.showMessageDialog(MediaStore.this, "Playing " + media.getTitle());

        }

    }

   
}
