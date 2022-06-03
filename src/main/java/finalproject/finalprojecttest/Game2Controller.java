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
    private Timeline animationCheck;
    private double rightSpeed = 1, leftSpeed = 1;
    private Image imageNum0 = new Image("數字零.png");
    private Image imageNum1 = new Image("數字一.png");
    private Image imageNum2 = new Image("數字二.png");
    private Image imageNum3 = new Image("數字三.png");


    @FXML
    public void startButtonOnPressed(){
        hintPane.setVisible(false);
        Controller3.game2Scene.getRoot().requestFocus();
        startGame();

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
        timeImage.setImage(imageNum3);
        timeImage.setVisible(true);
        RPFirstType = true;
        LPFirsType = true;
        firstType = true;
        ballArrive = false;
        leftPlayerChoice = 0;
        rightPlayerChoice = 0;
    }
    private void startGame(){
        System.out.println("startGame function");
        initialBall();
        animationLeft = new Timeline(new KeyFrame(Duration.millis(20), e -> moveLeft()));
        animationLeft.setCycleCount(Timeline.INDEFINITE);
        animationRight = new Timeline(new KeyFrame(Duration.millis(20), e -> moveRight()));
        animationRight.setCycleCount(Timeline.INDEFINITE);
        animationCheck = new Timeline(new KeyFrame(Duration.millis(20), e -> checkWhoWin()));
        animationCheck.setCycleCount(Timeline.INDEFINITE);

        showCountdownPane();
        animationCheck.play();


    }
    private int whoWin = 0, round = 0;
    private void tie(){
        if(round < 3){
            round++;
            startGame();
        }else whoWin = (int)(Math.random()*2);
    }
    private void checkWhoWin(){
        if(ballArrive) {
            if(RPFirstType && !LPFirsType) whoWin = 2;
            if(!RPFirstType && LPFirsType) whoWin = 1;
            if(RPFirstType && LPFirsType) {
                tie();
            }
        }else {
            if(!RPFirstType && !LPFirsType) {
                switch (rightPlayerChoice) {
                    case 1 -> {
                        switch (leftPlayerChoice) {
                            case 1 -> tie();
                            case 2 -> whoWin = 1;
                            case 3 -> whoWin = 2;
                        }
                    }
                    case 2 -> {
                        switch (leftPlayerChoice) {
                            case 1 -> whoWin = 2;
                            case 2 -> tie();
                            case 3 -> whoWin = 1;
                        }
                    }
                    case 3 -> {
                        switch (leftPlayerChoice) {
                            case 1 -> whoWin = 1;
                            case 2 -> whoWin = 2;
                            case 3 -> tie();
                        }
                    }
                }
            }
        }
        if(whoWin != 0) {
            animationCheck.pause();
            System.out.println(whoWin);
        }
    }
    private void showCountdownPane(){
        animationTime = new Timeline(new KeyFrame(Duration.millis(20), e -> moveTime()));
        animationTime.setCycleCount(Timeline.INDEFINITE);
        animationTime.play();
    }
    private  void moveTime(){
        timeCounter.setProgress(timeCounter.getProgress()+0.005);
        if(timeCounter.getProgress() >= 0.33) timeImage.setImage(imageNum2);
        if(timeCounter.getProgress() >= 0.66) timeImage.setImage(imageNum1);
        if(timeCounter.getProgress() >= 0.99) {
            timeImage.setImage(imageNum0);
            animationTime.stop();
            timeImage.setVisible(false);
            animationLeft.play();
            animationRight.play();
        }

    }
    boolean RPFirstType = true, LPFirsType = true, firstType = true, ballArrive = false;
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
            ballArrive = true;
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
            ballArrive = true;
        }
        circle.setCenterX(x);
    }


    private int leftPlayerChoice = 0, rightPlayerChoice = 0;

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode e = keyEvent.getCode();
        System.out.println(e);
        if(!ballArrive){
            if(e == KeyCode.NUMPAD1 || e == KeyCode.NUMPAD2 || e == KeyCode.NUMPAD3) {
                if(RPFirstType) {
                    switch (e) {
                        case NUMPAD1 -> rightPlayerChoice = 1;
                        case NUMPAD2 -> rightPlayerChoice = 2;
                        case NUMPAD3 -> rightPlayerChoice = 3;
                    }
                    animationRight.pause();
                    RPFirstType = false;
                    switch (rightPlayerChoice) {
                        case 1 -> rightScissors.setStyle("-fx-background-color: blue");
                        case 2 -> rightRock.setStyle("-fx-background-color: blue");
                        case 3 -> rightPaper.setStyle("-fx-background-color: blue");
                    }
                    if(firstType) {
                        firstType = false;
                        switch (rightPlayerChoice) {
                            case 1 -> leftRock.setStyle("-fx-background-color: red");
                            case 2 -> leftPaper.setStyle("-fx-background-color: red");
                            case 3 -> leftScissors.setStyle("-fx-background-color: red");
                        }
                    }

                }
            }
            else if(e == KeyCode.J || e == KeyCode.K || e == KeyCode.L) {
                if(LPFirsType) {
                    animationLeft.pause();
                    LPFirsType = false;
                    switch (e) {
                        case J -> {
                            leftPlayerChoice = 1;
                            leftScissors.setStyle("-fx-background-color: blue");
                        }
                        case K -> {
                            leftPlayerChoice = 2;
                            leftRock.setStyle("-fx-background-color: blue");
                        }
                        case L -> {
                            leftPlayerChoice = 3;
                            leftPaper.setStyle("-fx-background-color: blue");
                        }
                    }
                    if(firstType) {
                        firstType = false;
                        switch (leftPlayerChoice) {
                            case 1 -> rightRock.setStyle("-fx-background-color: red");
                            case 2 -> rightPaper.setStyle("-fx-background-color: red");
                            case 3 -> rightScissors.setStyle("-fx-background-color: red");
                        }
                    }
                }
            }
        }

//        switch (e) {
//            case NUMPAD1 -> {
//                rightScissors.setStyle("-fx-background-color: blue");
//
//            }
//            case NUMPAD2 -> {
//                System.out.println(rightScissors.getBackground());
//                if(!String.valueOf(rightScissors.getBackground()).equals("null")){
//                    System.out.println("有東西");
//                }else System.out.println("沒東西");
//            }
//        }
    }
}
