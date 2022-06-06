package finalproject.finalprojecttest;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;
/**
 開始畫面
 */
public class Controller1 {
    DataHolder data = DataHolder.get();

    @FXML
    Label label = new Label();
    @FXML
    Button bt1 = new Button();
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
