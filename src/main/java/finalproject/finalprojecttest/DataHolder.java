package finalproject.finalprojecttest;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DataHolder {
    ImageView ve = new ImageView();
    private static DataHolder dataHolder = new DataHolder();
    private static DataHolder dataHolder2 = new DataHolder();
    private DataHolder(){}

    public static DataHolder get(){
        return dataHolder;
    }

    public int pos;
    public int selectIndex;
    /**
     * 當前是哪位玩家在擲骰子
     * 1為玩家一 2為玩家二 以此類推
     * */
    public static int currentPlayer = 1;
    /**
     * 當前是哪位玩家發生移動 1為玩家一 2為玩家二 以此類推*/
    private static int whoMove = 0;
    /**
     * 公用值static 整數 移動玩家所移動的步數*/
    private static int moveSteps = 0;
    /**
     * 用來設定 whoMove 的方法*/
    public void setWhoMove(int who) { whoMove = who; }
    /**
     * 用來設定 moveSteps 的方法*/
    public void setMoveSteps(int steps) { moveSteps = steps; }
    /**
     * @return moveSteps*/
    public int getMoveSteps() { return moveSteps; }
    /**
     * @return whoMove*/
    public int getWhoMove() { return whoMove; }



    public Image getImage(ImageView v){
        Image c = v.getImage();
        return c;
    }
    /**
     * getDataHolder1 是用來獲取dataHolder
     * @author 林盈利
     * */
    public DataHolder getDataHolder1(){
        return dataHolder;
    }
    /**
     * getDataHolder2 是用來獲取dataHolder2
     * @author 林盈利
     * */
    public DataHolder getDataHolder2(){
        return dataHolder2;
    }
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

