package finalproject.finalprojecttest;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FP extends Application {
    public static Stage currentStage;
    public static Scene F1Scene;
    public static Scene F2Scene;
    public static Scene F3Scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader3 = new FXMLLoader(FP.class.getResource("f3.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f1.fxml")));

        currentStage = primaryStage;
        F3Scene = new Scene(fxmlLoader3.load());
        F1Scene = new Scene(root);
        currentStage.setTitle("我一定要贏");
        currentStage.setScene(F1Scene);
        currentStage.show();
    }


}
