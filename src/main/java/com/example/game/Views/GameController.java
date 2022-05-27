package com.example.game.Views;

import com.example.game.Controllers.BombAnimation;
import com.example.game.Controllers.MovingController;
import com.example.game.Controllers.ShootingBulletAnimation;
import com.example.game.Models.Bomb;
import com.example.game.Models.Bullet;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public AnchorPane pane;
    @FXML
    private ImageView plane;

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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.requestFocus();
            }
        });
        run();
//        Image image = new Image("/com/example/game/img/Plane/Plane/mugman_plane_idle_straight_0004.png");
//        ImageView view = new ImageView();
//        Main.move();
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(firstPlane);
//        translate.setDuration(Duration.millis(1000));
//        translate.setByX(250);
//        translate.play();
    }
}
