package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameController {

    int posPlayer1 = 0;
    int posPlayer2 = 0;
    boolean isPlayer1Turn = true;
    @FXML
    AnchorPane anchorPane;
    @FXML
    GridPane board1;
    @FXML
    GridPane board2;
    @FXML
    ImageView player1;
    @FXML
    ImageView player2;
    @FXML
    Label labelTurn;
    @FXML
    Label labelDiced;


    //Player player1 = new Player(im, posPlayer1, 0,board1);

    @FXML
    public void dice()
    {
        int steps = (int)Math.floor(Math.random() * 5);
        labelDiced.setText("You diced a " + steps);
        if (isPlayer1Turn)
        {

            advancePlayer1(steps);
            labelTurn.setText("Player 2's turn");
            if(posPlayer1 >= 10)
            {
                labelTurn.setText("Player 1 won");
            }
        }
        else
        {
            advancePlayer2(steps);
            labelTurn.setText("Player 1's turn");
            if(posPlayer2 >= 10)
            {
                labelTurn.setText("Player 2 won");
            }
        }
        isPlayer1Turn = ! isPlayer1Turn;
    }

    private void advancePlayer1(int steps)
    {
        posPlayer1 += steps;
        //player1.walk(4,0);
        GridPane.setRowIndex(player1, posPlayer1);
    }
    private void advancePlayer2(int steps)
    {
        posPlayer2 += steps;
        GridPane.setRowIndex(player2, posPlayer2);
    }

}
