package finalproject.finalprojecttest;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DataHolder {
//    ImageView ve = new ImageView();
    private static DataHolder dataHolder = new DataHolder();
    private static DataHolder dataHolder2 = new DataHolder();

    private DataHolder(){}

    public static DataHolder get(){
        return dataHolder;
    }

    public int pre_pos;
    public int pos;



    public Image getImage(ImageView v){
        Image c = v.getImage();
        return c;
    }
    /*
    林盈利
    */
    public boolean changePos(int value){
        if(pos + value > 100 || pos +value < 0)
            return false;

        pos+=value;
        return true;
    }
    /*

    */
    public void setImage(String name,ImageView v){
        Image a = new Image(name);
        v.setImage(a);
    }

}

