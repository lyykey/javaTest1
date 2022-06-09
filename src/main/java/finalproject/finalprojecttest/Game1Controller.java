package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Game1Controller implements Initializable {
    int currentPlay = 1;

    @FXML
    GridPane board;
    @FXML
    ImageView circle00;
    @FXML
    ImageView cross00;
    @FXML
    ImageView circle01;
    @FXML
    ImageView cross01;
    @FXML
    ImageView circle02;
    @FXML
    ImageView cross02;
    @FXML
    ImageView circle10;
    @FXML
    ImageView cross10;
    @FXML
    ImageView circle11;
    @FXML
    ImageView cross11;
    @FXML
    ImageView circle12;
    @FXML
    ImageView cross12;
    @FXML
    ImageView circle20;
    @FXML
    ImageView cross20;
    @FXML
    ImageView circle21;
    @FXML
    ImageView cross21;
    @FXML
    ImageView circle22;
    @FXML
    ImageView cross22;


    @FXML
    Button b00;
    @FXML
    Button b01;
    @FXML
    Button b02;
    @FXML
    Button b10;
    @FXML
    Button b11;
    @FXML
    Button b12;
    @FXML
    Button b20;
    @FXML
    Button b21;
    @FXML
    Button b22;

    @FXML
    Label turnLabel;
    @FXML
    Button returnBtn;

    int didDraw = 0;


    @FXML
    public void button00() throws IOException {
        if(currentPlay == 1)
        {
            circle00.setVisible(true);
            b00.setText("o");
            b00.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross00.setVisible(true);
            b00.setText("x");
            b00.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button01() throws IOException {
        if(currentPlay == 1)
        {
            circle01.setVisible(true);
            b01.setText("o");
            b01.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross01.setVisible(true);
            b01.setText("x");
            b01.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button02() throws IOException {
        if(currentPlay == 1)
        {
            circle02.setVisible(true);
            b02.setText("o");
            b02.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross02.setVisible(true);
            b02.setText("x");
            b02.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button10() throws IOException {
        if(currentPlay == 1)
        {
            circle10.setVisible(true);
            b10.setText("o");
            b10.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross10.setVisible(true);
            b10.setText("x");
            b10.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button11() throws IOException {
        if(currentPlay == 1)
        {
            circle11.setVisible(true);
            b11.setText("o");
            b11.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross11.setVisible(true);
            b11.setText("x");
            b11.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button12() throws IOException {
        if(currentPlay == 1)
        {
            circle12.setVisible(true);
            b12.setText("o");
            b12.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross12.setVisible(true);
            b12.setText("x");
            b12.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button20() throws IOException {
        if(currentPlay == 1)
        {
            circle20.setVisible(true);
            b20.setText("o");
            b20.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross20.setVisible(true);
            b20.setText("x");
            b20.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button21() throws IOException {
        if(currentPlay == 1)
        {
            circle21.setVisible(true);
            b21.setText("o");
            b21.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross21.setVisible(true);
            b21.setText("x");
            b21.setDisable(true);
            checkWin();
            currentPlay = 1;
        }
    }
    @FXML
    public void button22() throws IOException {
        if(currentPlay == 1)
        {
            circle22.setVisible(true);
            b22.setText("o");
            b22.setDisable(true);
            checkWin();
            currentPlay = 2;
        }
        else if(currentPlay == 2)
        {
            cross22.setVisible(true);
            b22.setText("x");
            b22.setDisable(true);
            checkWin();
            currentPlay = 1;
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
        if(currentPlay == 1)
        {
            turnLabel.setText("Player 1 turn!");
        }
        else if(currentPlay == 2)
        {
            turnLabel.setText("Player 2 turn!");
        }
    }

    public void checkWin() throws IOException {
        if(currentPlay == 1)
        {
            turnLabel.setText("Player 2 turn!");
        }
        else if(currentPlay == 2)
        {
            turnLabel.setText("Player 1 turn!");
        }
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> b00.getText() + b01.getText() + b02.getText();
                case 1 -> b10.getText() + b11.getText() + b12.getText();
                case 2 -> b20.getText() + b21.getText() + b22.getText();
                case 3 -> b00.getText() + b11.getText() + b22.getText();
                case 4 -> b02.getText() + b11.getText() + b20.getText();
                case 5 -> b00.getText() + b10.getText() + b20.getText();
                case 6 -> b01.getText() + b11.getText() + b21.getText();
                case 7 -> b02.getText() + b12.getText() + b22.getText();
                default -> null;
            };

            //X winner
            if (line.equals("xxx")) {
                Controller3.data.setWhoWin(2);
                turnLabel.setText("PLAYER 2 WINS");
                returnBtn.setVisible(true);
                return;
                //Start();
            }

            //O winner
            else if (line.equals("ooo")) {
                Controller3.data.setWhoWin(1);
                turnLabel.setText("PLAYER 1 WINS");
                returnBtn.setVisible(true);
                return;
                //Start();
            }
        }
        didDraw++;
        if(didDraw >= 9)
        {
            Controller3.data.setWhoWin(0);
            turnLabel.setText("DRAW");
            returnBtn.setVisible(true);
        }

        //ObservableList<Node> childrens; {assert false;childrens = board.getChildren();}



    }}

