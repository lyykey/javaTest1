package finalproject.finalprojecttest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

import java.io.IOException;
import java.util.Objects;


public class Game3Controller implements EventHandler<KeyEvent> {
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
    @FXML
    Pane whoWinPane;
    @FXML
    Label whoWinLabel;
    @FXML
    Label roundLabel;
    @FXML
    Button winCheckButton;


    private Timeline animationLeft;
    private Timeline animationRight;
    private Timeline animationTime;
    private Timeline animationCheck;
    private Timeline animationCountDown;
    private final ProgressIndicator progressIndicatorForCountDownAfterSbWin = new ProgressIndicator();
    private double rightSpeed = 1, leftSpeed = 1;
    private final Image imageNum0 = new Image("數字零.png");
    private final Image imageNum1 = new Image("數字一.png");
    private final Image imageNum2 = new Image("數字二.png");
    private final Image imageNum3 = new Image("數字三.png");
    private int whoWin = 0, round = 0;
    boolean RPFirstType = true, LPFirsType = true, firstType = true, ballArrive = false;
    private int leftPlayerChoice = 0, rightPlayerChoice = 0;
    private boolean tieBoolean = false;
    @FXML
    public void startButtonOnPressed(){
        hintPane.setVisible(false);
        Controller3.game3Scene.getRoot().requestFocus();
        animationCountDown = new Timeline(new KeyFrame(Duration.millis(1500), e -> {
            //加了 try, catch IOException ex
            try {
                moveProgressIndicatorProgress();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
        animationCountDown.setCycleCount(Timeline.INDEFINITE);
        animationLeft = new Timeline(new KeyFrame(Duration.millis(20), e -> moveLeft()));
        animationLeft.setCycleCount(Timeline.INDEFINITE);
        animationRight = new Timeline(new KeyFrame(Duration.millis(20), e -> moveRight()));
        animationRight.setCycleCount(Timeline.INDEFINITE);
        animationCheck = new Timeline(new KeyFrame(Duration.millis(20), e -> checkWhoWin()));
        animationCheck.setCycleCount(Timeline.INDEFINITE);
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
        progressIndicatorForCountDownAfterSbWin.setProgress(0);
    }
    private void startGame(){
        initialBall();
        showCountdownPane();
    }
    //加了 throws IOException
    private void moveProgressIndicatorProgress() throws IOException {
        progressIndicatorForCountDownAfterSbWin.setProgress(progressIndicatorForCountDownAfterSbWin.getProgress()+0.5);
        System.out.println(progressIndicatorForCountDownAfterSbWin.getProgress());
        if(progressIndicatorForCountDownAfterSbWin.getProgress() >= 1){
            roundLabel.setText("Round " + (round+1));
            animationCountDown.stop();
            whoWinPane.setVisible(false);
            if(whoWin == 0) startGame();
            else {
                backButtonOnPressed();
            }
        }
    }
    private void tie(){
        animationCheck.pause();
        if(round < 2){
            round++;
            whoWinLabel.setText("平手，進入下一回合。");
        }else {
            tieBoolean = true;
            whoWin = (int)(Math.random()*2)+1;
            whoWinLabel.setText("你們大戰三百回合後還是無法分出勝負，最後因為對方媽媽叫他回家了。\n所以最後由玩家"+whoWin+"獲勝!");
        }
        whoWinPane.setVisible(true);
        animationCountDown.play();
    }
    private void checkWhoWin(){
        if(ballArrive) {
            if(RPFirstType && !LPFirsType) whoWin = 1;
            if(!RPFirstType && LPFirsType) whoWin = 2;
            if(RPFirstType && LPFirsType) {
                tie();
            }
        }else {
            if(!RPFirstType && LPFirsType) animationRight.pause();
            if(RPFirstType && !LPFirsType) animationLeft.pause();
            if(!RPFirstType && !LPFirsType) {
                animationLeft.pause();
                animationRight.pause();
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
        if(whoWin != 0){
            animationCheck.pause();
            if(!tieBoolean){
                whoWinLabel.setText("玩家"+whoWin+"獲勝了!");
            }
            whoWinPane.setVisible(true);
            animationCountDown.play();
            DataHolder.whoWin = whoWin;
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
            animationCheck.play();
            if(whoWin == 0){
                animationLeft.play();
                animationRight.play();
            }
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
    //加了 throws IOException
    @FXML
    public void backButtonOnPressed() throws IOException {
        /* 盈利之前的程式**/
        //FP.currentStage.setScene(FP.F3Scene);
        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f3.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }



    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode e = keyEvent.getCode();
        if(!ballArrive){
            if(e == KeyCode.NUMPAD1 || e == KeyCode.NUMPAD2 || e == KeyCode.NUMPAD3 || e == KeyCode.DIGIT1 || e == KeyCode.DIGIT2 || e == KeyCode.DIGIT3) {
                if(RPFirstType) {
                    switch (e) {
                        case NUMPAD1, DIGIT1 -> rightPlayerChoice = 1;
                        case NUMPAD2, DIGIT2 -> rightPlayerChoice = 2;
                        case NUMPAD3, DIGIT3 -> rightPlayerChoice = 3;
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
    }
}
