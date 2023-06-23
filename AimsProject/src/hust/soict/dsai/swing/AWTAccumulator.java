package hust.soict.dsai.swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Frame;


public class AWTAccumulator extends Frame{
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Accumulated sum, init to 0

    //Constructor to setup the GUI components and event handlers
    public AWTAccumulator() {

        // Add layout
        setLayout(new GridLayout(2,2));
        // Add and des label, add from left to right, top to down
        add(new Label("Enter an Integer: "));
        
        // setup and design textfield 
        tfInput = new TextField(10);
        // add to frame
        add(tfInput);

        // add listener
        tfInput.addActionListener(new TFInputListener());
        add(new Label("The Accumulated Sum is "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);
    
        //set layout remain
        setTitle("AWT Accumulator");
        setSize(350,120);
        setVisible(true);

    }
    public static void main(String[] args){
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum+=numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
