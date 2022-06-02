package finalproject.finalprojecttest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    @FXML
    Pane leftRock;
    @FXML
    Pane leftScissors;
    @FXML
    Pane leftPaper;
    @FXML
    Pane rightRock;
    @FXML
    Pane rightScissors;
    @FXML
    Pane rightPaper;

    private Timeline animationLeft;
    private Timeline animationRight;
    private double rightSpeed = 1, leftSpeed = 1;

    @FXML
    public void startButtonOnPressed(){
        hintPane.setVisible(false);
        animationLeft = new Timeline(new KeyFrame(Duration.millis(20), e -> moveLeft()));
        animationLeft.setCycleCount(Timeline.INDEFINITE);
        animationLeft.play();
        animationRight = new Timeline(new KeyFrame(Duration.millis(20), e -> moveRight()));
        animationRight.setCycleCount(Timeline.INDEFINITE);
        animationRight.play();
        Controller3.game2Scene.getRoot().requestFocus();
    }
    private void moveLeft(){
        double acceleration = 1.1;
        Circle circle = circleLeft;
        double x = circle.getCenterX();
        if(x<720) {
            x += leftSpeed;
            leftSpeed += 0.1;
        }
        else{
            x = 720;
            animationLeft.pause();
        }
        circle.setCenterX(x);
    }
    private void moveRight(){
        double acceleration = 1.1;
        Circle circle = circleRight;
        double x = circle.getCenterX();
        if(x> 780) {
            x -= rightSpeed;
            rightSpeed+= 0.1;
        }
        else{
            x = 780;
            animationRight.pause();
        }
        circle.setCenterX(x);
    }




    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode e = keyEvent.getCode();
        System.out.println(e);
        switch (e) {
            case NUMPAD1 -> {
                rightScissors.setStyle("-fx-background-color: blue");
            }
        }
    }
}
