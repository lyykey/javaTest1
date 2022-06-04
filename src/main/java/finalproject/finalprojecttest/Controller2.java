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
    int who = 1;int wait = 0;int ac = 0;int bc = 0;int cc = 0;int dc=0;int ec = 0;int fc = 0;int gc = 0;int hc = 0;int ic=0;int jc = 0;
    DataHolder data = DataHolder.get();
    DataHolder data2 = DataHolder.get2();
    @FXML
    ImageView aimage;
    @FXML
    ImageView bimage;
    @FXML
    ImageView cimage;
    @FXML
    ImageView dimage;
    @FXML
    ImageView eimage;
    @FXML
    ImageView fimage;
    @FXML
    ImageView gimage;
    @FXML
    ImageView himage;
    @FXML
    ImageView iimage;
    @FXML
    ImageView jimage;
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
    Image d = new Image("妹子正常.png");
    @FXML
    Image e = new Image("真香.png");
    @FXML
    Image f = new Image("科P.png");
    @FXML
    Image g = new Image("施國琛正常.png");
    @FXML
    Image  h= new Image("世堅.png");
    @FXML
    Image i= new Image("國瑜.png");
    @FXML
    Image j = new Image("妹子正常.png");
    @FXML
    Image ar =new Image("力量人大.png");
    @FXML
    Image br =new Image("傑哥大.png");
    @FXML
    Image cr =new Image("低能兒大.png");
    @FXML
    Image dr = new Image("妹子大.png");
    @FXML
    Image er = new Image("真香大.png");
    @FXML
    Image fr = new Image("科P大.png");
    @FXML
    Image gr = new Image("施國琛大.png");
    @FXML
    Image hr = new Image("世堅大.png");
    @FXML
    Image ir = new Image("國瑜大.png");
    @FXML
    Image jr = new Image("妹子大.png");
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
    void d_enter(){
        if(dc==0)wait=0;
        dimage.setImage(dr);
    }
    @FXML
    void d_exit(){
        if(wait==0&&dc!=1)
            dimage.setImage(d);
    }
    @FXML
    void e_enter(){
        if(ec==0)wait=0;
        eimage.setImage(er);
    }
    @FXML
    void e_exit(){
        if(wait==0&&ec!=1)
            eimage.setImage(e);
    }
    @FXML
    void f_enter(){
        if(fc==0)wait=0;
        fimage.setImage(fr);
    }
    @FXML
    void f_exit(){
        if(wait==0&&fc!=1)
            fimage.setImage(f);
    }
    @FXML
    void g_enter(){
        if(gc==0)wait=0;
        gimage.setImage(gr);
    }
    @FXML
    void g_exit(){
        if(wait==0&&gc!=1)
            gimage.setImage(g);
    }
    @FXML
    void h_enter(){
        if(hc==0)wait=0;
        himage.setImage(hr);
    }
    @FXML
    void h_exit(){
        if(wait==0&&hc!=1)
            himage.setImage(h);
    }
    @FXML
    void i_enter(){
        if(ic==0)wait=0;
        iimage.setImage(ir);
    }
    @FXML
    void i_exit(){
        if(wait==0&&ic!=1)
            iimage.setImage(i);
    }
    @FXML
    void j_enter(){
        if(jc==0)wait=0;
        jimage.setImage(jr);
    }
    @FXML
    void j_exit(){
        if(wait==0&&jc!=1)
            jimage.setImage(j);
    }
    @FXML
    void a_choosed(){

        aimage.setImage(ar);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=1;bc=0;cc=0;dc=0;ec=0;fc=0;gc=0;hc=0;ic=0;jc=0;
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
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=1;cc=0;dc=0;ec=0;fc=0;gc=0;hc=0;ic=0;jc=0;
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
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=1;dc=0;ec=0;fc=0;gc=0;hc=0;ic=0;jc=0;
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
    void d_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(dr);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=0;dc=1;ec=0;fc=0;gc=0;hc=0;ic=0;jc=0;
        LABEL1.setText("玩家"+who+"選擇了 正妹");
        switch (who){
            case 1:
                player1 = d;
                break;
            case 2:
                player2 = d;
                break;
        }
        String sound = "赤鬼伯伯.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void e_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(er);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=0;dc=0;ec=1;fc=0;gc=0;hc=0;ic=0;jc=0;
        LABEL1.setText("玩家"+who+"選擇了 真香");
        switch (who){
            case 1:
                player1 = e;
                break;
            case 2:
                player2 = e;
                break;
        }
        String sound = "真香.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void f_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(fr);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=0;dc=0;ec=0;fc=1;gc=0;hc=0;ic=0;jc=0;
        LABEL1.setText("玩家"+who+"選擇了 科P");
        switch (who){
            case 1:
                player1 = f;
                break;
            case 2:
                player2 = f;
                break;
        }
        String sound = "柯P.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void g_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(gr);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=0;dc=0;ec=0;fc=0;gc=1;hc=0;ic=0;jc=0;
        LABEL1.setText("玩家"+who+"選擇了 施國琛");
        switch (who){
            case 1:
                player1 = g;
                break;
            case 2:
                player2 = g;
                break;
        }
        String sound = "力量人.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void h_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(hr);
        iimage.setImage(i);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=0;dc=0;ec=0;fc=0;gc=0;hc=1;ic=0;jc=0;
        LABEL1.setText("玩家"+who+"選擇了 世堅");
        switch (who){
            case 1:
                player1 = h;
                break;
            case 2:
                player2 = h;
                break;
        }
        String sound = "世堅.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void i_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(ir);
        jimage.setImage(j);
        wait=1;
        ac=0;bc=0;cc=0;dc=0;ec=0;fc=0;gc=0;hc=0;ic=1;jc=0;
        LABEL1.setText("玩家"+who+"選擇了 韓國瑜");
        switch (who){
            case 1:
                player1 = i;
                break;
            case 2:
                player2 = i;
                break;
        }
        String sound = "國瑜.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }
    @FXML
    void j_choosed(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(jr);
        wait=1;
        ac=0;bc=0;cc=0;dc=0;ec=0;fc=0;gc=0;hc=0;ic=0;jc=1;
        LABEL1.setText("玩家"+who+"選擇了 妹子");
        switch (who){
            case 1:
                player1 = j;
                break;
            case 2:
                player2 = j;
                break;
        }
        String sound = "力量人.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.play();
    }



    @FXML
    void check(){
        aimage.setImage(a);
        bimage.setImage(b);
        cimage.setImage(c);
        dimage.setImage(d);
        eimage.setImage(e);
        fimage.setImage(f);
        gimage.setImage(g);
        himage.setImage(h);
        iimage.setImage(i);
        jimage.setImage(j);
        who+=1;
        LABEL1.setText("玩家二請選擇角色");
        Confirm.setVisible(false);start.setVisible(true);

    }
    @FXML
    void Start() throws IOException {
        Controller3.data.setPosPlayer(0);
        Controller3.data2.setPosPlayer2(0);
        data.setimage(player1);
        data2.setimage(player2);
        String sound = "太陽.mp3";
        Media letterSound = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        FXMLLoader fxmlLoader3 = new FXMLLoader(FP.class.getResource("f3.fxml"));
        FP.F3Scene = new Scene(fxmlLoader3.load());
        FP.F3Scene.getRoot().requestFocus();
        FP.currentStage.setScene(FP.F3Scene);
    }
}
