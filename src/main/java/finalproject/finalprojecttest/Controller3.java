package finalproject.finalprojecttest;
/**
 遊戲畫面:
    1.地圖
    2.LABEL顯示狀態
    3.Dice
 */
public class Controller3 {
    DataHolder data = DataHolder.get();
    Dice dice = new Dice();
    int a;
    public String whoMove;
    public String currentPlayer="P2";

    public void ClickDice() {
        if(currentPlayer.equals("P1")){
            currentPlayer="P2";
        }
        else if(currentPlayer.equals("P2")){
            currentPlayer="P1";
        }
        if(dice.reDice()==1) {
            whoMove = currentPlayer;
            /*
            Dice步數
            */

        }
        else if(dice.reDice()==2) {

        }
        else if(dice.reDice()==3) {

        }
        else if(dice.reDice()==4) {

        }
        //            if() {
//
//            }
//
//            else if() {
//
//            }
    }

    public void Click() {
        if(!data.changePos(dice.reDice())) {
            System.out.print("pleaseReDice");
            /*
            讓玩家重骰
            */
        }
        else{
            System.out.print("Fine");
        /*
            用data.pos找到位置，然後在地圖改變位置
         */
        }
    }
}
