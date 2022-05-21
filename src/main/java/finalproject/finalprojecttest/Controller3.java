package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 遊戲畫面:
 1.地圖
 2.LABEL顯示狀態
 3.Dice
 */
public class Controller3 {
    DataHolder data = DataHolder.get();
    Dice dice = new Dice();
    int thePlayerBeSelect = 0;
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
     * 當擲骰被點擊時執行*/
    public void Click() {
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
        /*這裡會跟最大玩家數有關*/
        if(DataHolder.currentPlayer !=2) DataHolder.currentPlayer++;
        else DataHolder.currentPlayer = 1;
    }
    /**當玩家需要選擇其他玩家移動時會執行*/
    /**秉均加一些東西*/
    @FXML
    public void getPlayerChooseWhoButtonOnPressed(){
        for (int i = 0; i < 2; i++){ //讓選擇框隱藏
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
        switch (dice.diceValueForAction) {
            case 2 -> {
                label.setText(dice.playerName[thePlayerBeSelect-1]+"前進了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(thePlayerBeSelect, dice.diceValueForSteps);
                if(thePlayerBeSelect == 1){advancePlayer1(dice.diceValueForSteps);}
                else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 3 -> {
                label.setText(dice.playerName[thePlayerBeSelect-1]+"後退了"+dice.diceValueForSteps+"步");
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
        switch (dice.diceValueForAction) { // 要輸出誰移動、移動幾步，要顯示label、選擇
            case 0 -> { // 自己前進
                label.setText("你骰到 1 ，並前進了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(dice.currentPlayerInt, dice.diceValueForSteps);
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1) {advancePlayer1(dice.diceValueForSteps);}
                else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 1 -> { // 自己後退
                label.setText("你骰到 2 ，並後退了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(dice.currentPlayerInt, -dice.diceValueForSteps);
                checkButton.setVisible(true);
                if(DataHolder.currentPlayer == 1) {retreatPlayer1(dice.diceValueForSteps);}
                else{retreatPlayer2(dice.diceValueForSteps);}
            }
            case 2 -> { //別人前進
                //顯示選擇 和確認按鈕 確認按鈕按下後根據選擇設定移動玩家、玩家位置移動、移動幾步\
                label.setText("你骰到 3 ，請選擇要讓哪位玩家前進"+dice.diceValueForSteps+"步");
                for (int i = 0; i < 2; i++){
                    buttonList[i].setVisible(true);
                }
                getPlayerChooseWhoButton.setVisible(true);
                //if(thePlayerBeSelect == 0){advancePlayer1(dice.diceValueForSteps);}
                //else{advancePlayer2(dice.diceValueForSteps);}
            }
            case 3 -> { //別人後退
                label.setText("你骰到 4 ，請選擇要讓哪位玩家後退"+dice.diceValueForSteps+"步");
                for (int i = 0; i < 2; i++){
                    buttonList[i].setVisible(true);
                }
                getPlayerChooseWhoButton.setVisible(true);
                // if(thePlayerBeSelect == 0){retreatPlayer1(dice.diceValueForSteps);}
                //else{retreatPlayer2(dice.diceValueForSteps);}

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
    int columnPlayer1;
    int rowPlayer2;
    int columnPlayer2;


    void advancePlayer1(int steps)
    {
        columnPlayer1 += steps;
        if(columnPlayer1 > 9)
        {
            rowPlayer1++;
            columnPlayer1 -= 9;
        }
        GridPane.setRowIndex(player1, rowPlayer1);
        GridPane.setColumnIndex(player1, columnPlayer1);
    }
    void retreatPlayer1(int steps)
    {
        columnPlayer1 -= steps;

        if(rowPlayer1 == 0 && columnPlayer1 < 0)
        {
            columnPlayer1 = 0;
            GridPane.setColumnIndex(player1, 0);
        }
        else if(columnPlayer1 < 0)
        {
            rowPlayer1--;
            columnPlayer1 += 9;
        }
        if(rowPlayer1 < 0 )
        {
            rowPlayer1 = 0;
            columnPlayer1 = 0;
            GridPane.setRowIndex(player1, 0);
            GridPane.setColumnIndex(player1, 0);
        }
        else
        {
            GridPane.setRowIndex(player1, rowPlayer1);
            GridPane.setColumnIndex(player1, columnPlayer1);
        }
    }
    void advancePlayer2(int steps)
    {
        columnPlayer2 += steps;
        if(columnPlayer2 > 9)
        {
            rowPlayer2++;
            columnPlayer2 -= 9;
        }
        GridPane.setRowIndex(player2, rowPlayer2);
        GridPane.setColumnIndex(player2, columnPlayer2);
    }
    void retreatPlayer2(int steps)
    {
        columnPlayer2 -= steps;
        if(rowPlayer2 == 0 && columnPlayer2 < 0)
        {
            columnPlayer2 = 0;
            GridPane.setColumnIndex(player2, 0);
        }
        else if(columnPlayer2 < 0)
        {
            rowPlayer2--;
            columnPlayer2 += 9;
        }
        if(rowPlayer2 < 0 )
        {
            rowPlayer2 = 0;
            GridPane.setRowIndex(player2, 0);
            GridPane.setColumnIndex(player2, 0);
        }
        else
        {
            GridPane.setRowIndex(player2, rowPlayer2);
            GridPane.setColumnIndex(player2, columnPlayer2);
        }
    }
    
}
