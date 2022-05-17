package finalproject.finalprojecttest;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DataHolder {

    private static DataHolder dataHolder = new DataHolder();
    private static DataHolder dataHolder2 = new DataHolder();

    private DataHolder(){}

    public static DataHolder get(){
        return dataHolder;
    }
    public static DataHolder get2(){
        return dataHolder2;
    }
    Image pl;
    public void setImage(Image v){
        pl = v;
    }

    public int pre_pos;
    public int pos;




    /*
    林盈利
    */
    public boolean changePos(int value){
        if(pos + value > 100 || pos +value < 0)
            return false;

        pos+=value;
        return true;
    }


}

