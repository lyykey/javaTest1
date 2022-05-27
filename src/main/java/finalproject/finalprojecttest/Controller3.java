package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    int thePlayerBeSelect = 0, forwardEventSize, backwardEventSize;
    boolean initial = true;
    ArrayList<String> forwardEventArrayList = new ArrayList<>();
    ArrayList<String> backwardEventArrayList = new ArrayList<>();
    /**
     * 用來收集RadioButton
     * 可使用迴圈顯示或隱藏RadioButton*/
    RadioButton[] buttonList;
    /**讓玩家選擇要讓哪位玩家移動*/
    @FXML
    RadioButton button1;
    /**讓玩家選擇要讓哪位玩家移動*/
    @FXML
    RadioButton button2;
    /**讓RadioButton群只能一個被選中*/
    @FXML
    ToggleGroup toggleGroup;
    /**用來顯示玩家職骰時出現的文字*/
    @FXML
    Label label;
    /**點擊時獲取玩家選擇讓哪位玩家移動*/
    @FXML
    Button getPlayerChooseWhoButton;
    /**一位玩家擲骰完後換下位玩家時的確認鍵*/
    @FXML
    Button checkButton;
    /**擲骰時會出現的對話框*/
    @FXML
    Pane dicePane;
    /**擲骰按鈕*/
    @FXML
    Button clickButton;

    /**
     * 建構元
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
        buttonList = new RadioButton[]{button1, button2};
        clickButton.setVisible(false);
        button1.setVisible(false);
        button2.setVisible(false);
        dicePane.setVisible(true);
        dice.whoRolling(DataHolder.currentPlayer);
        diceOutput();
    }
    /**設定選擇玩家時顯示RadioButton的文字跟UserData*/
    public void setButtonName(){
        int CP = dice.currentPlayerInt;
        for(int i = 0, buttonListNumber = 0; buttonListNumber < 2; buttonListNumber++, i++){
            if (i == CP-1) i++;
            buttonList[buttonListNumber].setText(dice.playerName[i]);
            buttonList[buttonListNumber].setUserData(i+1);

        }
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
        if(DataHolder.currentPlayer !=2) DataHolder.currentPlayer++;
        else DataHolder.currentPlayer = 1;
    }
    /**當玩家需要選擇其他玩家移動時會執行*/
    /**秉均加一些東西*/
    @FXML
    public void getPlayerChooseWhoButtonOnPressed(){
        for (int i = 0; i < 1; i++){ //讓選擇框隱藏
            buttonList[i].setVisible(false);
        }
        getPlayerChooseWhoButton.setVisible(false);
        checkButton.setVisible(true);
        thePlayerBeSelect = 0;
        if (toggleGroup.getSelectedToggle() != null) {
            String temp = toggleGroup.getSelectedToggle().getUserData().toString();
            thePlayerBeSelect = Integer.parseInt(temp);
        }
        else label.setText("please select");
        String event;
        switch (dice.diceValueForAction) {
            case 2 -> {
                event = forwardEventArrayList.get((int) (Math.random()*forwardEventSize));
                label.setText(event + "。 所以" + dice.playerName[thePlayerBeSelect-1]+"前進了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(thePlayerBeSelect, dice.diceValueForSteps);
                if(thePlayerBeSelect == 1){advancePlayer1(dice.diceValueForSteps);}
                else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 3 -> {
                event = backwardEventArrayList.get((int) (Math.random()*backwardEventSize));
                label.setText(event + "。 所以" + dice.playerName[thePlayerBeSelect-1]+"後退了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(thePlayerBeSelect, -dice.diceValueForSteps);
                if(thePlayerBeSelect == 1){retreatPlayer1(dice.diceValueForSteps);}
                else{retreatPlayer2(dice.diceValueForSteps);}
            }
        }


    }
    /**
     * 擲骰時執行*/
    public void diceOutput(){ //呼叫此函式時，
        setButtonName();
        dice.rollDice();
        String event;
        switch (dice.diceValueForAction) { // 要輸出誰移動、移動幾步，要顯示label、選擇
            case 0 -> { // 自己前進
                event = forwardEventArrayList.get((int) (Math.random() * forwardEventSize));
                label.setText(event + "。 所以你前進了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(dice.currentPlayerInt, dice.diceValueForSteps);
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1) {advancePlayer1(dice.diceValueForSteps);}
                else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 1 -> { // 自己後退
                event = backwardEventArrayList.get((int) (Math.random()*backwardEventSize));
                label.setText(event + "。 所以你後退了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(dice.currentPlayerInt, -dice.diceValueForSteps);
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1) {retreatPlayer1(dice.diceValueForSteps);}
                else{retreatPlayer2(dice.diceValueForSteps);}
            }
            case 2 -> { //別人前進
                //顯示選擇 和確認按鈕 確認按鈕按下後根據選擇設定移動玩家、玩家位置移動、移動幾步\
                label.setText("看來幸運並不在你身上發生，但你有賦予的權利。請選擇要讓哪位玩家前進");
                for (int i = 0; i < 1; i++){
                    buttonList[i].setVisible(true);
                }
                getPlayerChooseWhoButton.setVisible(true);
                if(thePlayerBeSelect == 0){advancePlayer1(dice.diceValueForSteps);}
                else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 3 -> { //別人後退
                label.setText("看來悲劇並不在你身上發生，而且你有陷害的機會!請選擇要讓哪位玩家後退");
                for (int i = 0; i < 1; i++){
                    buttonList[i].setVisible(true);
                }
                getPlayerChooseWhoButton.setVisible(true);
                if(thePlayerBeSelect == 0){retreatPlayer1(dice.diceValueForSteps);}
                else{retreatPlayer2(dice.diceValueForSteps);}

            }
            default -> System.out.println("rollDice 骰出值超過了");

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
        GridPane.setColumnIndex(player1, data.getPosPlayer());
        GridPane.setColumnIndex(player2, data2.getPosPlayer2());
        columnPlayer1 = data.getPosPlayer();
        columnPlayer2 = data2.getPosPlayer2();
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
    
}
