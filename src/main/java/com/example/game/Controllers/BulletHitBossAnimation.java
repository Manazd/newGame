package com.example.game.Controllers;

import com.example.game.Models.Bullet;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

public class BulletHitBossAnimation extends Transition {

    private Bullet bullet;

    public BulletHitBossAnimation(Bullet bullet) {
        this.bullet = bullet;
        setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        ImageView imageView = new ImageView();

        imageView.setLayoutX(bullet.getLayoutX());
        imageView.setLayoutY(bullet.getLayoutY());
        bullet.removeBullet(bullet);

        int frame = (int) Math.floor(v * 11);
        ImagePattern dust = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Hit Dust/" + frame + ".png").toExternalForm()));
        imageView.setImage(dust.getImage());
    }
}
