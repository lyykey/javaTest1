package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Game2Controller implements Initializable {

    int answer = (int)(Math.random()*(-99 +1)+99);
    int p1Number = -1;
    int p2Number = -1;

    @FXML
    TextField myTextField;
    @FXML
    Label turnLabel;
    @FXML
    Button guessBtn;
    @FXML
    Button returnBtn;


    @FXML
    public void Guess()
    {
        if(DataHolder.currentPlayer == 1)
        {
            p1Number = Integer.parseInt(myTextField.getText());
            myTextField.setText("");
            DataHolder.currentPlayer = 2;
            turnLabel.setText("Player 2 turn!");
        }
        else if(DataHolder.currentPlayer == 2)
        {
            p2Number = Integer.parseInt(myTextField.getText());
            myTextField.setText("");
            DataHolder.currentPlayer = 1;
            turnLabel.setText("Player 1 turn!");
        }
        if(p1Number != -1 && p2Number != -1)
        {
            if(Math.abs(answer - p1Number) < Math.abs(answer - p2Number))
            {
                turnLabel.setText("玩家一獲勝!並且前進兩格 答案是" + answer);
                Controller3.data.setWhoWin(1);
                guessBtn.setVisible(false);
                returnBtn.setVisible(true);
            }
            else if(Math.abs(answer - p1Number) > Math.abs(answer - p2Number))
            {
                turnLabel.setText("玩家二獲勝!並且前進兩格 答案是" + answer);
                Controller3.data.setWhoWin(2);
                guessBtn.setVisible(false);
                returnBtn.setVisible(true);
            }
        }
    }


    @FXML
    void Start() throws IOException {

        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f3.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }
    @Override
    public void initialize(URL u, ResourceBundle rb)
    {
        if(DataHolder.currentPlayer == 1){turnLabel.setText("Player 1 turn!");}
        else if(DataHolder.currentPlayer == 2){turnLabel.setText("Player 2 turn!");}

    }
}

