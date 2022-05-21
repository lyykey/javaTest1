package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class Controller2 {
    int who = 1;int wait = 0;int ac = 0;int bc = 0;int cc = 0;
    DataHolder data = DataHolder.get();
    DataHolder data2 = DataHolder.get2();
    @FXML
    ImageView aimage;
    @FXML
    ImageView bimage;
    @FXML
    ImageView cimage;
    @FXML
    Button Confirm = new Button();
    @FXML
    Button start = new Button();
    @FXML
    Image player1;
    @FXML
    Image player2;
    @FXML
    Label LABEL1;
    @FXML
    Image a =new Image("a.png");
    @FXML
    Image b =new Image("b.png");
    @FXML
    Image c =new Image("c.png");
    @FXML
    Image ar =new Image("ared.png");
    @FXML
    Image br =new Image("bred.png");
    @FXML
    Image cr =new Image("cred.png");
    @FXML
    void a_enter(){
        if(ac==0)wait=0;
        aimage.setImage(ar);
    }
    @FXML
    void a_exit(){
        if(wait==0&&ac!=1)
            aimage.setImage(a);
    }
    @FXML
    void b_enter(){
        if(bc==0)wait=0;
        bimage.setImage(br);
    }
    @FXML
    void b_exit(){
        if(wait==0&&bc!=1)
            bimage.setImage(b);
    }
    @FXML
    void c_enter(){
        if(cc==0)wait=0;
        cimage.setImage(cr);
    }
    @FXML
    void c_exit(){
        if(wait==0&&cc!=1)
            cimage.setImage(c);
    }
    @FXML
    void a_choosed(){
        aimage.setImage(ar);
        bimage.setImage(b);
        cimage.setImage(c);
        wait=1;
        ac=1;bc=0;cc=0;
        LABEL1.setText("Player "+who+" choosed a");
        switch (who){
            case 1:
                player1 = a;
                break;
            case 2:
                player2 = a;
                break;
        }
    }
    @FXML
    void b_choosed(){
        aimage.setImage(a);
        bimage.setImage(br);
        cimage.setImage(c);
        ac=0;bc=1;cc=0;
        wait=1;
        LABEL1.setText("Player "+who+" choosed b");
        switch (who){
            case 1:
                player1 = b;
                break;
            case 2:
                player2 = b;
                break;
        }
    }
    @FXML
    void c_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(cr);
        wait=1;
        ac=0;bc=0;cc=1;
        LABEL1.setText("Player "+who+" choosed c");
        switch (who){
            case 1:
                player1 = c;
                break;
            case 2:
                player2 = b;
                break;
        }
    }
    @FXML
    void check(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        who+=1;
        LABEL1.setText("Player 2 choose your charastic");
        Confirm.setVisible(false);start.setVisible(true);

    }
    @FXML
    void Start() throws IOException {
        data.setImage(player1);
        data2.setImage(player2);

        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f3.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }
    void test(){}
}
