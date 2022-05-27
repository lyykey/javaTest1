package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
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
    Image a =new Image("力量人正常.png");
    @FXML
    Image b =new Image("傑哥正常.png");
    @FXML
    Image c =new Image("低能兒正常.png");
    @FXML
    Image ar =new Image("力量人大.png");
    @FXML
    Image br =new Image("傑哥大.png");
    @FXML
    Image cr =new Image("低能兒大.png");
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
        LABEL1.setText("玩家"+who+"選擇了 力量人");
        switch (who){
            case 1:
                player1 = a;
                break;
            case 2:
                player2 = a;
                break;
        }
        String sound = "力量人.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void b_choosed(){
        aimage.setImage(a);
        bimage.setImage(br);
        cimage.setImage(c);
        ac=0;bc=1;cc=0;
        wait=1;
        LABEL1.setText("玩家"+who+"選擇了 傑哥");
        switch (who){
            case 1:
                player1 = b;
                break;
            case 2:
                player2 = b;
                break;
        }
        String sound = "傑哥.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void c_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(cr);
        wait=1;
        ac=0;bc=0;cc=1;
        LABEL1.setText("玩家"+who+"選擇了 低能兒");
        switch (who){
            case 1:
                player1 = c;
                break;
            case 2:
                player2 = c;
                break;
        }
        String sound = "低能兒.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void check(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        who+=1;
        LABEL1.setText("玩家二請選擇角色");
        Confirm.setVisible(false);start.setVisible(true);

    }
    @FXML
    void Start() throws IOException {
        data.setimage(player1);
        data2.setimage(player2);

        Parent Game = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("f3.fxml")));
        Scene GameScene = new Scene(Game);
        GameScene.getRoot().requestFocus();
        FP.currentStage.setScene(GameScene);
    }
}
