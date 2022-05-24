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
        currentStage = primaryStage;


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f1.fxml")));
        String sound = "太陽.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
        F1Scene = new Scene(root);
        currentStage.setTitle("我一定要贏");
        currentStage.setScene(F1Scene);
        currentStage.show();
    }


}
