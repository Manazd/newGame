package com.example.game.Controllers;

import com.example.game.Models.MiniBoss;
import javafx.animation.Transition;
import javafx.util.Duration;

public class MiniBossAnimation extends Transition {
    private MiniBoss miniBoss;

    public MiniBossAnimation(MiniBoss miniBoss) {
        this.miniBoss = miniBoss;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }
    @Override
    protected void interpolate(double v) {
        if (miniBoss.getImageView().getLayoutX() >= 0) {
            miniBoss.getImageView().setLayoutX(miniBoss.getImageView().getLayoutX() - 5);
            int frame = (int) Math.floor(v * 3);
            if (miniBoss.isPink())
                miniBoss.setBackground("/com/example/game/img/MiniBossFly/pink/" + frame + ".png");
            else
                miniBoss.setBackground("/com/example/game/img/MiniBossFly/yellow/" + frame + ".png");
        }
        else {
            miniBoss.removeMiniBoss(miniBoss);
        }
    }
}
