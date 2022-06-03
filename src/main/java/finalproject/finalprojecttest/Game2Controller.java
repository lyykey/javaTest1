package finalproject.finalprojecttest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    ProgressIndicator timeCounter;
    @FXML
    ImageView timeImage;

    private Timeline animationLeft;
    private Timeline animationRight;
    private Timeline animationTime;
    private double rightSpeed = 1, leftSpeed = 1;
    private Image imageNum0 = new Image("數字零.png");
    private Image imageNum1 = new Image("數字一.png");
    private Image imageNum2 = new Image("數字二.png");
    private Image imageNum3 = new Image("數字三.png");


    @FXML
    public void startButtonOnPressed(){
        hintPane.setVisible(false);
        initialBall();
        animationLeft = new Timeline(new KeyFrame(Duration.millis(20), e -> moveLeft()));
        animationLeft.setCycleCount(Timeline.INDEFINITE);
        animationLeft.play();
        animationRight = new Timeline(new KeyFrame(Duration.millis(20), e -> moveRight()));
        animationRight.setCycleCount(Timeline.INDEFINITE);
        animationRight.play();
        Controller3.game2Scene.getRoot().requestFocus();
        showCountdownPane();
    }
    private void initialBall(){
        rightSpeed = 1;
        leftSpeed = 1;
        circleLeft.setCenterX(30);
        circleRight.setCenterX(1470);
        rightRock.setStyle(null);
        rightScissors.setStyle(null);
        rightPaper.setStyle(null);
        leftPaper.setStyle(null);
        leftRock.setStyle(null);
        leftScissors.setStyle(null);
        timeCounter.setProgress(0);
        timeImage.setImage(imageNum0);
    }
    private  void showCountdownPane(){
        animationTime = new Timeline(new KeyFrame(Duration.millis(20), e -> moveTime()));
        animationTime.play();
    }
    private  void moveTime(){
        timeCounter.setProgress(timeCounter.getProgress()+0.01);
        if(timeCounter.getProgress() == 0.33) timeImage.setImage(imageNum2);
        if(timeCounter.getProgress() == 0.66) timeImage.setImage(imageNum1);
        if(timeCounter.getProgress() == 1) {
            timeImage.setImage(imageNum0);
            animationTime.stop();
        }
    }
    private void moveLeft(){
        Circle circle = circleLeft;
        double x = circle.getCenterX();
        if(x<720) {
            x += leftSpeed;
            leftSpeed += 0.2;
        }
        else{
            x = 720;
            animationLeft.pause();
        }
        circle.setCenterX(x);
    }
    private void moveRight(){
        Circle circle = circleRight;
        double x = circle.getCenterX();
        if(x> 780) {
            x -= rightSpeed;
            rightSpeed+= 0.2;
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
            case NUMPAD2 -> {
                System.out.println(rightScissors.getBackground());
                if(!String.valueOf(rightScissors.getBackground()).equals("null")){
                    System.out.println("有東西");
                }else System.out.println("沒東西");
            }
        }
    }
}
