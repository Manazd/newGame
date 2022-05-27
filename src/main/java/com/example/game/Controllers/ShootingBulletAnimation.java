package com.example.game.Controllers;

import com.example.game.Models.Bullet;
import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ShootingBulletAnimation extends Transition {
    private Bullet bullet;
    private int speed = 3;

    public ShootingBulletAnimation(Bullet bullet) {
        this.bullet = bullet;
        this.setCycleDuration(Duration.millis(1500));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        bullet.getImageView().setLayoutX(bullet.getImageView().getLayoutX() + 10);
        int frame = (int) Math.floor(v * 8);
        bullet.setBackground("/com/example/game/img/Plane/Plane/Mini/Bullet/" + frame +".png");
        bullet.getImageView().setLayoutY(bullet.getLayoutY());
    }
}
