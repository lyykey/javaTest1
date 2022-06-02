package finalproject.finalprojecttest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Game2Controller implements EventHandler<KeyEvent> {
    @FXML
    AnchorPane mainPane;
    @FXML
    Pane hintPane;
    @FXML
    Label hintLabel;
    @FXML
    Button startButton;
    @FXML
    Circle circleLeft;
    @FXML
    Circle circleRight;


    private double x = 100, y = 50;
    private double dx = 1, dy = -1;

    @FXML
    public void startButtonOnPressed(){
        hintPane.setVisible(false);
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(20), e -> move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    private void move(){
        double radius = 30;
        if ( x < radius || x > mainPane.getWidth() - radius)
            dx *= -1;
        if ( y < radius || y > mainPane.getHeight() - radius)
            dy *= -1;
        x += dx;
        y += dy;
        circleRight.setCenterX(x);
        circleRight.setCenterY(y);
        circleLeft.setCenterX(x);
        circleLeft.setCenterY(y);
    }

    @Override
    public void handle(KeyEvent keyEvent) {

    }
}
