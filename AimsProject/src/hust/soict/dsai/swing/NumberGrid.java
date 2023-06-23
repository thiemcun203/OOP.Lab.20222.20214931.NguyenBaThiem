package hust.soict.dsai.swing;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Create desired class extend Jframe, then design, label, textfield, position,... then add listener implements ActionListener. 

public class NumberGrid extends JFrame{

    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid(){
        tfDisplay = new JTextField(30);
        tfDisplay.setComponentOrientation(
            ComponentOrientation.RIGHT_TO_LEFT
        );
        JPanel panelButtons = new JPanel(new GridLayout(4,3)); // inner layout
        addButtons(panelButtons);

        Container cp = getContentPane(); // main layout
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200,200);
        setVisible(true);
    }

    public static void main(String[] args){
        new NumberGrid();
    }

    void addButtons(JPanel panelButtons){
        ButtonListener btnListener = new ButtonListener();
        for (int i = 1; i<=9; i++){
            btnNumbers[i] = new JButton(""+i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }
        
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9'){
                tfDisplay.setText(tfDisplay.getText() + button);

            }
            else if (button.equals("DEL")){
                String lastString = tfDisplay.getText();
                String modifiedString = lastString.substring(0, lastString.length() - 1);
                tfDisplay.setText(modifiedString);


            }
            else{
                String modifiedString = "";
                tfDisplay.setText(modifiedString);
            }

        }

    }
}

