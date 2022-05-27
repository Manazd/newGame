package com.example.game.Views;

import com.example.game.Controllers.MovingController;
import com.example.game.Controllers.ShootingBulletAnimation;
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
                String keyName = keyEvent.getCode().getName();
                switch (keyName) {
                    case "Left":
                        MovingController.moveLeft(plane);
                        break;
                    case "Right":
                        MovingController.moveRight(plane);
                        break;
                    case "Up":
                        MovingController.moveUp(plane);
                        break;
                    case "Down":
                        MovingController.moveDown(plane);
                        break;
                    case "Space":
                        shoot();
                        break;
                }
            }
        });
    }

    private void shoot() {
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
