package hust.soict.dsai.javafx;

import javafx.fxml.FXML;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event){
        //
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event){
        Circle newCircle = new Circle(event.getX(),event.getY(),4,Color.BLACK);
        drawingAreaPan.getChildren().add(newCircle);
    }
    @FXML
    void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }


}
