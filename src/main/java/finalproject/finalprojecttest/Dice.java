package finalproject.finalprojecttest;

public class Dice {

    public Dice(){
        /*
         可改為每次建構就RANDOM隨機數字
         */
        this.value =1;
    }
    int value;

    public int reDice(){
        this.value = 2;
        return value;
    }
}
