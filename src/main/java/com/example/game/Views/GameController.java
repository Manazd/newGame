package com.example.game.Views;

import com.example.game.Controllers.*;
import com.example.game.Models.Bomb;
import com.example.game.Models.Boss;
import com.example.game.Models.Bullet;
import com.example.game.Models.MiniBoss;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;
public class GameController implements Initializable {

    public AnchorPane pane;
    @FXML
    private Text bossLives;
    @FXML
    private ImageView plane;
    public static int second = 0;

//    public Timer timer = new Timer();
//    public TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            second++;
//            System.out.println(second);
////            if (second % 10 == 0)
////                createMiniBoss();
////            timer.cancel();
////            timer.purge();
//        }
//    };

    private void run() {
        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case LEFT:
                        MovingController.moveLeft(plane);
                        break;
                    case RIGHT:
                        MovingController.moveRight(plane);
                        break;
                    case UP:
                        MovingController.moveUp(plane);
                        break;
                    case DOWN:
                        MovingController.moveDown(plane);
                        break;
                    case SPACE:
                        shootBullet();
                        break;
                    case ENTER:
                        transformToBomb();
                        break;
                    case W:
                        bossShoot();
                        break;
                }
            }
        });
    }

    private void bossShoot() {
        pane.getChildren().remove(Boss.getInstance(pane).getImageView());
        BossShootAnimation animation = new BossShootAnimation(pane);
        animation.play();
//        pane.getChildren().add(Boss.getInstance(pane).getImageView());
    }

    private void transformToBomb() {
        pane.getChildren().remove(plane);
        Bomb bomb = new Bomb(plane, pane);
        BombAnimation bombAnimation = new BombAnimation(bomb, pane);
        bombAnimation.play();
    }

    private void shootBullet() {
        Bullet bullet = new Bullet(plane, pane);
        ShootingBulletAnimation shooting = new ShootingBulletAnimation(bullet, pane);
        shooting.play();
        AudioClip shoot = new AudioClip(this.getClass().getResource("/com/example/game/Audio/gunShoot.mp3").toExternalForm());
        shoot.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BossAnimation bossAnimation = new BossAnimation(Boss.getInstance(pane));
        bossAnimation.play();
        bossLives.setText("58");
//        timer.sc heduleAtFixedRate(task, 1000, 1000);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.requestFocus();
            }
        });
        createMiniBoss();
        run();
    }

    private void createMiniBoss() {
        for (int i = 0; i < 4; i++) {
            MiniBoss miniBoss = new MiniBoss(pane, i);
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(miniBoss);
            miniBossAnimation.play();
        }
    }

    public void setBossLives(String lives) {
        bossLives.setText(null);
        bossLives.setText(lives);
    }
}
