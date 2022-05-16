package finalproject.finalprojecttest;

public class Dice {
    public DataHolder data = DataHolder.get();
    public int diceValueForAction=0; //骰出來的值
    public int diceValueForSteps = 0;
    public int currentPlayerInt = 1;
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
        diceValueForAction= (int)(Math.random()*4); // 骰作何種動作
        diceValueForSteps = (int)(Math.random()*4); // 骰走幾步
    }
    /**
     * 用來設定現在是誰在骰*/
    public void whoRolling(int whichPlayer){
        this.currentPlayerInt = whichPlayer;
        switch (whichPlayer) { //用來設定現在是誰在骰骰子
            case 1 -> currentPlayerInt = 1;
            case 2 -> currentPlayerInt = 2;
        }
    }


}
