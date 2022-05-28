package com.example.game.Controllers;

import com.example.game.Models.Boss;
import com.example.game.Models.Bullet;
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
        int frame = (int) Math.floor(v * 6);
        ImagePattern dust = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Flap Feather Dust/" + frame + ".png").toExternalForm()));
        bullet.getImageView().setImage(dust.getImage());
    }
}




//public class BulletHitBossAnimation extends Transition {
//
//    private Bullet bullet;
//    private ImageView imageView;
//    private AnchorPane pane;
//
//    public BulletHitBossAnimation(Bullet bullet, AnchorPane pane) {
//        this.bullet = bullet;
//        this.pane = pane;
//        ImageView imageView = new ImageView();
//
//        imageView.setLayoutX(Boss.getInstance(pane).getLayoutX() + 20);
//        imageView.setLayoutY(Boss.getInstance(pane).getLayoutY() + 35);
//        this.imageView = imageView;
//        pane.getChildren().add(imageView);
//
//        setCycleDuration(Duration.millis(500));
//        this.setCycleCount(1);
//    }
//
//    @Override
//    protected void interpolate(double v) {
//        int frame = (int) Math.floor(v * 6);
//        ImagePattern dust = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Flap Feather Dust/" + frame + ".png").toExternalForm()));
//        imageView.setImage(dust.getImage());
//    }
//}
