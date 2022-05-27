package com.example.game.Controllers;

import javafx.animation.Transition;
import javafx.util.Duration;

public class BossAnimation extends Transition {

    private Boss boss;

    public BossAnimation(Boss boss) {
        this.boss = boss;
        this.setCycleDuration(Duration.millis(900));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 5);
         boss.setBackground("/com/example/game/img/BossFly/" + frame + ".png");
    }
}
