package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class Game1Controller {
    @FXML
    void Start() throws IOException {

        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f3.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }
}
