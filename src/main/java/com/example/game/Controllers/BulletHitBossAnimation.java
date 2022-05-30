package com.example.game.Controllers;

import com.example.game.Models.Boss;
import com.example.game.Models.Bullet;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

public class BulletHitBossAnimation extends Transition {
    private Bullet bullet;
    private AnchorPane pane;
    private ImageView imageView;

    public BulletHitBossAnimation(Bullet bullet, AnchorPane pane) {
        this.bullet = bullet;
        this.pane = pane;

        ImageView imageView = new ImageView();
        imageView.setLayoutX(bullet.getLayoutX() + 50);
        imageView.setLayoutY(bullet.getLayoutY());
        this.imageView = imageView;

        pane.getChildren().add(imageView);
        setCycleDuration(Duration.millis(500));
    }

    @Override protected void interpolate(double v) {
        makeFade();
        int frame = (int) Math.floor(v * 6);
        ImagePattern dust = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Flap Feather Dust/" + frame + ".png").toExternalForm()));
        bullet.getImageView().setImage(dust.getImage());
    }

    private void makeFade() {
        FadeTransition fade = new FadeTransition(Duration.millis(1000), Boss.getInstance(pane).getImageView());
        fade.setFromValue(1.0);
        fade.setToValue(0.1);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);
        fade.play();
    }
}
