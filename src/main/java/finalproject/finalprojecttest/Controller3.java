package finalproject.finalprojecttest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 遊戲畫面:
 1.地圖
 2.LABEL顯示狀態
 3.Dice
 */
public class Controller3 implements Initializable {
    static DataHolder data = DataHolder.get();
    static DataHolder data2 = DataHolder.get2();
    Dice dice = new Dice();
    static int thePlayerBeSelect = 0;
    int forwardEventSize, backwardEventSize;
    boolean initial = true;
    ArrayList<String> forwardEventArrayList = new ArrayList<>();
    ArrayList<String> backwardEventArrayList = new ArrayList<>();
    /**用來顯示玩家職骰時出現的文字*/
    @FXML
    Label label;
    /**一位玩家擲骰完後換下位玩家時的確認鍵*/
    @FXML
    Button checkButton;
    /**擲骰時會出現的對話框*/
    @FXML
    Pane dicePane;
    /**擲骰按鈕*/
    @FXML
    Button clickButton;
    @FXML
    Label showCurrentPlayer;

    public static Scene game3Scene;

    /**
     * 類似建構元功用
     * 用來初始化前進/後退事件的ArrayList
     * @author 林盈利
     */
    public void setEventList(){
        try {
            FileReader fileReaderForward = new FileReader("前進事件.txt");
            FileReader fileReaderBackward = new FileReader("後退事件.txt");
            BufferedReader BRForward = new BufferedReader(fileReaderForward);
            BufferedReader BRBackward = new BufferedReader(fileReaderBackward);
            String line;
            while ((line = BRForward.readLine()) != null) {
                forwardEventArrayList.add(line);
            }
            while ((line = BRBackward.readLine()) != null) {
                backwardEventArrayList.add(line);
            }
            forwardEventSize = forwardEventArrayList.size();
            backwardEventSize = backwardEventArrayList.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 當擲骰被點擊時執行*/
    public void Click() {
        if (initial) {
            setEventList();
            initial = false;
        }
        clickButton.setVisible(false);
        dicePane.setVisible(true);
        dice.whoRolling(DataHolder.currentPlayer);
        diceOutput();
        checkOnGame();
    }
    @FXML
    public void checkButtonOnPressed(){
        checkButton.setVisible(false);
        dicePane.setVisible(false);
        clickButton.setVisible(true);
        /**if(pos==遊戲格){
         * 就轉到game1、2、3
         *         Parent f4 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game1.fxml")));
         *         Scene F4Scene = new Scene(f4);
         *         F4Scene.getRoot().requestFocus();
         *         FP.currentStage.setScene(F4Scene);
         * }
         * */
        /*這裡會跟最大玩家數有關*/
        if(DataHolder.currentPlayer !=2) {
            DataHolder.currentPlayer=2;
            showCurrentPlayer.setText("現在輪到玩家二擲骰");
        }
        else {
            DataHolder.currentPlayer = 1;
            showCurrentPlayer.setText("現在輪到玩家一擲骰");
        }
        if(data.getPosPlayer()>=30) {
            FP.EndScene.getRoot().requestFocus();
            FP.currentStage.setScene(FP.EndScene);
        }
        if(data.getPosPlayer2()>=30){
            FP.End2Scene.getRoot().requestFocus();
            FP.currentStage.setScene(FP.End2Scene);
        }
    }

    /**
     * 擲骰時執行*/
    public void diceOutput(){ //呼叫此函式時，
        dice.rollDice();
        String event;
        String player = "玩家一";
        switch (dice.diceValueForAction) { // 要輸出誰移動、移動幾步，要顯示label、選擇
            case 0 -> { // 自己前進
                event = forwardEventArrayList.get((int) (Math.random() * forwardEventSize));
                label.setText(event + "。 所以你前進了"+dice.diceValueForSteps+"步");
                String sound = "Right.mp3";
                Media letterSound = new Media(new File(sound).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
                mediaPlayer.play();
                dice.changePlayerPosition(dice.currentPlayerInt, dice.diceValueForSteps);
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1) {advancePlayer1(dice.diceValueForSteps);}
                else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 1 -> { // 自己後退
                event = backwardEventArrayList.get((int) (Math.random()*backwardEventSize));
                label.setText(event + "。 所以你後退了"+dice.diceValueForSteps+"步");
                String sound = "pupu.mp3";
                Media letterSound = new Media(new File(sound).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
                mediaPlayer.play();
                dice.changePlayerPosition(dice.currentPlayerInt, -dice.diceValueForSteps);
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1) {retreatPlayer1(dice.diceValueForSteps);}
                else{retreatPlayer2(dice.diceValueForSteps);}
            }
            case 2 -> { //別人前進
                //顯示選擇 和確認按鈕 確認按鈕按下後根據選擇設定移動玩家、玩家位置移動、移動幾步\
                if(DataHolder.currentPlayer == 1) player = "玩家二";
                label.setText("看來幸運並不在你身上發生，而是在"+player+"身上!");
                String sound = "pupu.mp3";
                Media letterSound = new Media(new File(sound).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
                mediaPlayer.play();
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1){advancePlayer2(dice.diceValueForSteps);}
                else{advancePlayer1(dice.diceValueForSteps);}
            }
            case 3 -> { //別人後退
                if(DataHolder.currentPlayer == 1) player = "玩家二";
                label.setText("今天悲劇並不在你身上發生，而是在"+player+"身上!");
                String sound = "Right.mp3";
                Media letterSound = new Media(new File(sound).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
                mediaPlayer.play();
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1){retreatPlayer2(dice.diceValueForSteps);}
                else{retreatPlayer1(dice.diceValueForSteps);}
            }
            default -> System.out.println("rollDice 骰出值超過了");
        }
    }
    /**
     * 開始遊戲三
     * @author 林盈利*/
    @FXML
    public void game3Button() throws IOException {
        
        data.setPosPlayer(columnPlayer1);
        data2.setPosPlayer2(columnPlayer2);

        FXMLLoader game3FxmlLoader = new FXMLLoader(Controller3.class.getResource("Game3.fxml"));
        game3Scene = new Scene(game3FxmlLoader.load());
        FP.currentStage.setScene(game3Scene);
        FP.currentStage.show();
    }
    // 0604
    private final ProgressIndicator progressIndicator = new ProgressIndicator();
    private Timeline animationTime;
    private static final ArrayList<Integer> gameList = new ArrayList<>();
    /**
     * 用來決定要執行的遊戲
     * @author 林盈利*/
    public int gameChooser(){
        int listIndex, gameNum;
        if(gameList.size() == 0) {
            for (int i = 0; i < 3; i++) {
                gameList.add(i + 1);
            }
        }
        listIndex = (int)(Math.random()*gameList.size());
        gameNum = gameList.get(listIndex);
        gameList.remove(listIndex);
        return gameNum;
    }
    //0604
    /**
     * TimeLine animationTime 的動作函數
     * @param gameNum 執行的遊戲
     * @author 林盈利*/
    public void countDown(int gameNum){
        animationTime = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            try {
                time(gameNum);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
        animationTime.setCycleCount(Timeline.INDEFINITE);
        animationTime.play();
    }

    //0604
    /**
     * 在短暫倒數後切到對應遊戲場景
     * @param gameNum 執行的遊戲
     * @author 林盈利*/
    public void time(int gameNum) throws IOException {
        progressIndicator.setProgress(progressIndicator.getProgress()+0.5);
        if(progressIndicator.getProgress() == 1){
            animationTime.stop();
            progressIndicator.setProgress(0);
            //switch to the game;
            switch (gameNum) {
                case 1 -> Start();
                case 2 -> Start2();
                default -> game3Button();
            }
            label.setText("");
            checkButtonOnPressed();
        }
    }
    /**
     * 用來檢查是否踩到遊戲格
     * @author 林盈利*/
    public void checkOnGame(){
        //0604
        int position1 = data.getPosPlayer(), position2 = data.getPosPlayer2();
        boolean overPosition, onGameGrid, lessGameGrid;
        onGameGrid = (position1 % 5) == 0 || (position2 % 5) == 0;
        overPosition = (position1 <= 26) && (position2 <= 26);
        lessGameGrid = (position1 >= 4) && (position2 >= 4);
        if (onGameGrid && overPosition && lessGameGrid) {
            label.setText("有人踩到了遊戲格，稍後會自動轉到小遊戲畫面。");
            checkButton.setVisible(false);
            countDown(gameChooser());
        }
    }



    /** @author 鍾秉均 */
    @FXML
    ImageView player1;
    @FXML
    ImageView player2;
    @FXML
    GridPane board1;
    @FXML
    GridPane board2;

    int rowPlayer1;
    int columnPlayer1 = data.getPosPlayer();
    int rowPlayer2;
    int columnPlayer2 = data2.getPosPlayer2();


    void advancePlayer1(int steps)
    {
        columnPlayer1 += steps;
        GridPane.setColumnIndex(player1, columnPlayer1);
        data.setPosPlayer(columnPlayer1);
    }
    void retreatPlayer1(int steps)
    {
        columnPlayer1 -= steps;
        GridPane.setColumnIndex(player1, columnPlayer1);
        data.setPosPlayer(columnPlayer1);
    }
    void advancePlayer2(int steps)
    {
        columnPlayer2 += steps;
        GridPane.setColumnIndex(player2, columnPlayer2);
        data2.setPosPlayer2(columnPlayer2);
    }
    void retreatPlayer2(int steps)
    {
        columnPlayer2 -= steps;
        GridPane.setColumnIndex(player2, columnPlayer2);
        data2.setPosPlayer2(columnPlayer2);
    }
    @Override
    public void initialize(URL x, ResourceBundle rb)
    {
        player1.setImage(data.pl);
        player2.setImage(data2.pl);
        if(data.getWhoWin() == 1) {data.setPosPlayer(data.getPosPlayer() + 2);}
        else if(data.getWhoWin() == 2){data2.setPosPlayer2(data2.getPosPlayer2() + 2);}
        data.setWhoWin(0);
        GridPane.setColumnIndex(player1, data.getPosPlayer());
        GridPane.setColumnIndex(player2, data2.getPosPlayer2());
        columnPlayer1 = data.getPosPlayer();
        columnPlayer2 = data2.getPosPlayer2();
        String a="";
        if(DataHolder.currentPlayer==1) a ="一";
        if(DataHolder.currentPlayer==2) a = "二";
        showCurrentPlayer.setText("現在輪到玩家"+ a +"擲骰");
    }

    @FXML
    void Start() throws IOException {
        data.setPosPlayer(columnPlayer1);
        data2.setPosPlayer2(columnPlayer2);
        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game1.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }
    @FXML
    void Start2() throws IOException {
        data.setPosPlayer(columnPlayer1);
        data2.setPosPlayer2(columnPlayer2);
        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game2.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }
    
}
