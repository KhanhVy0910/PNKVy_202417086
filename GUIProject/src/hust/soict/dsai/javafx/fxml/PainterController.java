package hust.soict.dsai.javafx.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML private RadioButton radioPen;
    @FXML private RadioButton radioEraser;

    @FXML
    private void initialize() {
        Rectangle clip = new Rectangle();
        clip.xProperty().set(0);
        clip.yProperty().set(0);
        clip.widthProperty().bind(drawingAreaPane.widthProperty());
        clip.heightProperty().bind(drawingAreaPane.heightProperty());
        drawingAreaPane.setClip(clip);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Nếu đang dùng tẩy → màu trắng, bán kính lớn hơn
        Color color = radioEraser.isSelected() ? Color.WHITE : Color.BLACK;
        double radius = radioEraser.isSelected() ? 10 : 4;

        Circle newCircle = new Circle(event.getX(), event.getY(), radius, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}
