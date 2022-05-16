package finalproject.finalprojecttest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class FP extends Application {
    public static Stage currentStage;
    public static Scene F1Scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f1.fxml")));
        F1Scene = new Scene(root);
        currentStage.setTitle("我一定要贏");
        currentStage.setScene(F1Scene);
        currentStage.show();
    }


}
