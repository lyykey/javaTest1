package finalproject.finalprojecttest;

public class Dice {
    public DataHolder data = DataHolder.get();
    public int diceValueForAction=0; //骰出來的值
    public int diceValueForSteps = 0;
    public int currentPlayerInt = 1;
    public int balanceCheckPoint = 30; //between 0 ~ 99. The higher value, the higher the probability of moving backward.
    public int balanceOthersOrSelf = 10; //between 0 ~ 20 The higher value, the higher the probability of others.
    public String[] playerName = {"玩家一","玩家二","玩家三","玩家四"};


    public Dice(){
        /*
         可改為每次建構就RANDOM隨機數字
         */

        this.value =1;
    }
    int value;
    /**
     * 設定的玩家少於需要的玩家會出現錯誤
     * @param movePlayer 要移動的玩家
     * @param moveSteps 移動步數 往前為正整數 往後為負整數
     * @author 林盈利
     * */
    public void changePlayerPosition(int movePlayer, int moveSteps){
        data.setWhoMove(movePlayer);
        data.setMoveSteps(moveSteps);
        DataHolder movePlayerData ;
        try {
            switch (movePlayer) {
                case 1 -> movePlayerData = data.getDataHolder1();
                case 2 -> movePlayerData = data.getDataHolder2();
                default -> throw new Exception();
            }
        }catch (Exception ex) {
            System.out.println("movePlayerData未初始化 在Dice.java changePlayerPosition");
            movePlayerData = data.getDataHolder1();
            movePlayerData.pos -= moveSteps;
        }
        movePlayerData.pos += moveSteps;
    }
    /**
     * 用來擲動作 步數
     * */
    public void rollDice(){
        int action = (int)(Math.random()*100), steps = (int)(Math.random()*4);
        steps = (steps == 0)? 4 : steps;
        if(currentPlayerInt == 1){
            if(data.getDataHolder1().pos < 20) {
                balanceOthersOrSelf = 7;
                balanceCheckPoint = 10;
            }
            else {
                balanceOthersOrSelf = 10;
                balanceCheckPoint = 20;
            }
        }else {
            if(data.getDataHolder2().pos < 20) {
                balanceOthersOrSelf = 7;
                balanceCheckPoint = 10;
            }
            else {
                balanceOthersOrSelf = 10;
                balanceCheckPoint = 20;
            }
        }
        if(data.getPosPlayer() <= 5 || data.getPosPlayer2() <= 5) balanceCheckPoint = 0;
        if (action >= balanceCheckPoint) { //大於等於CheckPoint 則骰到前進相關動作
            if (Math.random()*20 >=balanceOthersOrSelf) { //這裡的balanceOtherOrSelf可以用來調整骰到別人或自己移動的機率
                action = 0;
            }else action = 2;
        }
        else { //小於CheckPoint 則骰到後退相關動作
            if(Math.random()*20 >=balanceOthersOrSelf) {
                action = 1;
            }else action = 3;
        }
        if (data.getDataHolder1().pos == 0 ||data.getDataHolder2().pos == 0) {
            if (action ==1 || action == 3) {
                action = 0;
            }
        }
        if(DataHolder.currentPlayer == 1){
            if((data.getPosPlayer2() - data.getPosPlayer()) > 5 ){
                action = 0;
            }

        }else{
            if((data.getPosPlayer() - data.getPosPlayer2()) > 5){
                action = 0;
            }
        }
        diceValueForAction=  action;// 骰作何種動作
        diceValueForSteps = steps; // 骰走幾步
    }
    /**
     * 用來設定現在是誰在骰*/
    public void whoRolling(int whichPlayer){ //用來設定現在是誰在骰骰子
        this.currentPlayerInt = whichPlayer;
    }


}
