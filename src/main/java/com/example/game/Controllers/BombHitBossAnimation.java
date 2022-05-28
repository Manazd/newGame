package com.example.game.Controllers;

import com.example.game.Models.Bomb;
import com.example.game.Models.Bullet;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class BombHitBossAnimation extends Transition {
    private Bomb bomb;
    private AnchorPane pane;
    private ImageView imageView;

    public BombHitBossAnimation(Bomb bomb, AnchorPane pane) {
        this.bomb = bomb;
        this.pane = pane;

        ImageView imageView = new ImageView();
        imageView.setLayoutX(bomb.getLayoutX() + 50);
        imageView.setLayoutY(bomb.getLayoutY());
        this.imageView = imageView;

        pane.getChildren().add(imageView);
        setCycleDuration(Duration.millis(500));
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 11);
        ImagePattern dust = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Hit Dust/" + frame + ".png").toExternalForm()));
        bomb.getImageView().setImage(dust.getImage());

    }
}
