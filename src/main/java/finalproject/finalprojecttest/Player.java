package finalproject.finalprojecttest;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

    Player(){
    }
    public void setImage(String name,ImageView v){
        Image a = new Image(name);
        v.setImage(a);
    }
}
