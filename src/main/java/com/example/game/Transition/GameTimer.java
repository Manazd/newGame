package com.example.game.Transition;

import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class GameTimer extends Transition {
    private Text time;
    private long first;

    public GameTimer(Text time) {
        this.time = time;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
        this.first = System.currentTimeMillis();
    }

    @Override
    protected void interpolate(double v) {
        long minute = (System.currentTimeMillis() - first) / 1000;
        minute /= 60;
        long seconds = (System.currentTimeMillis() - first) / 1000;
        seconds %= 60;
        DecimalFormat decimalFormat = new DecimalFormat("00");
        time.setText(decimalFormat.format(minute) + ":" + decimalFormat.format(seconds));
    }
}
