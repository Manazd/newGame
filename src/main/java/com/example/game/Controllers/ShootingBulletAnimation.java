package com.example.game.Controllers;

import com.example.game.Models.Boss;
import com.example.game.Models.Bullet;
import com.example.game.Views.GameController;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ShootingBulletAnimation extends Transition {
    private Bullet bullet;
    private AnchorPane pane;

    public ShootingBulletAnimation(Bullet bullet, AnchorPane pane) {
        this.bullet = bullet;
        this.setCycleDuration(Duration.millis(1800));
        this.setCycleCount(-1);
        this.pane = pane;
    }

    @Override
    protected void interpolate(double v) {
        if (bullet.bulletHitBoss()) {
            Boss boss = Boss.getInstance(pane);
            boss.setLives(boss.getLives() - 1);
//            GameController.setBossLives(Integer.toString(boss.getLives()));
            this.stop();
            bullet.explode();
            bullet.removeBullet(bullet);
        }
        else {
            if (bullet.getImageView().getLayoutX() <= 700) {
                bullet.getImageView().setLayoutX(bullet.getImageView().getLayoutX() + 10);
                int frame = (int) Math.floor(v * 8);
                bullet.setBackground("/com/example/game/img/Plane/Plane/Mini/Bullet/" + frame + ".png");
            } else {
                pane.getChildren().remove(bullet.getImageView());
            }
        }
    }
}
