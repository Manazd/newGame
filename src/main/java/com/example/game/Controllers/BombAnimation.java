package com.example.game.Controllers;

import com.example.game.Models.Bomb;
import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class BombAnimation extends Transition {

    private Bomb bomb;
    private int speed = 3;

    public BombAnimation(Bomb bomb) {
        this.bomb = bomb;
        this.setCycleDuration(Duration.millis(2000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        if (bomb.getImageView().getLayoutX() <= 700) {
            bomb.getImageView().setLayoutX(bomb.getImageView().getLayoutX() + 5);
            int frame = (int) Math.floor(v * 23);
            bomb.setBackground("/com/example/game/img/Plane/Plane/Mini/Super/bomb/" + frame + ".png");
        }
        else {
            Bomb.removeBomb(bomb);
        }
    }
}
