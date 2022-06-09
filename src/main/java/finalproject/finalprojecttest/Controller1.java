package finalproject.finalprojecttest;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
/**
 開始畫面
 */
public class Controller1 {

    @FXML
    Label label = new Label();
    @FXML
    Button btForOver = new Button();
    @FXML
    public void display(ActionEvent e) throws IOException {
        FP.F2Scene.getRoot().requestFocus();
        FP.currentStage.setScene(FP.F2Scene);
    }

    @FXML
    public void gameOver(ActionEvent e) throws IOException {
        FP.End3Scene.getRoot().requestFocus();
        FP.currentStage.setScene(FP.End3Scene);
    }

}
