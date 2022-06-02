package finalproject.finalprojecttest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

class BallPane extends Pane {
    private final int radius = 20;
    private double x = 100, y = 50;
    private double dx = 1, dy = -1;
    private final Circle circle = new Circle(x, y, radius);
    private Timeline animation;
    BallPane(){
        circle.setFill(Color.BLACK);
        getChildren().add(circle);
        animation = new Timeline(new KeyFrame(Duration.millis(20), e -> move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    private void move(){
        if ( x < radius || x > getWidth() - radius )
            dx *= -1;
        if ( y < radius || y > getHeight() - radius )
            dy *= -1;
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}
public class Game2Controller implements EventHandler<KeyEvent> {

    @FXML
    BallPane ballPane = new BallPane();

    @Override
    public void handle(KeyEvent keyEvent) {

    }
}
