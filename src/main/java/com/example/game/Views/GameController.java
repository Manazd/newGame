package com.example.game.Views;

import com.example.game.Controllers.BombAnimation;
import com.example.game.Controllers.MiniBossAnimation;
import com.example.game.Controllers.MovingController;
import com.example.game.Controllers.ShootingBulletAnimation;
import com.example.game.Models.Bomb;
import com.example.game.Models.Bullet;
import com.example.game.Models.MiniBoss;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class GameController implements Initializable {

    public AnchorPane pane;
    @FXML
    private ImageView plane;
    public static int second = 0;

    public Timer timer = new Timer();
    public TimerTask task = new TimerTask() {
        @Override
        public void run() {
            second++;
            System.out.println(second);
//            timer.cancel();
//            timer.purge();
        }
    };

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
                }
            }
        });
    }

    private void transformToBomb() {
        pane.getChildren().remove(plane);
        Bomb bomb = new Bomb(plane, pane);
        BombAnimation bombAnimation = new BombAnimation(bomb);
        bombAnimation.play();
    }

    private void shootBullet() {
        Bullet bullet = new Bullet(plane, pane);
        ShootingBulletAnimation shooting = new ShootingBulletAnimation(bullet);
        shooting.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.scheduleAtFixedRate(task, 1000, 1000);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.requestFocus();
            }
        });
        checkTime();
        run();
    }

    private void checkTime() {
        if (second % 2 == 0) {
            MiniBoss miniBoss = new MiniBoss(pane);
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(miniBoss);
            miniBossAnimation.play();
        }
    }
}
