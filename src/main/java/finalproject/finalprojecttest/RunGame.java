package finalproject.finalprojecttest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RunGame extends Application{
    public static Stage currentStage;
    public static Scene myGameScene;


    @Override
    public void start(Stage stage) throws IOException
    {
        currentStage = stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game.fxml")));
        myGameScene = new Scene(root);
        currentStage.setScene(myGameScene);
        currentStage.show();
    }

    public static void main(String[] args){launch(args);}
}
