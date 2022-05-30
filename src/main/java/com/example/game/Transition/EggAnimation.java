package com.example.game.Transition;

import com.example.game.Models.Egg;
import javafx.animation.Transition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class EggAnimation extends Transition {

    private Egg egg;
    private AnchorPane pane;

    public EggAnimation(AnchorPane pane, Egg egg) {
        this.egg = egg;
        this.pane = pane;
        this.setCycleDuration(Duration.millis(2000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        if (egg.hitSomething()) {
            System.out.println("sdf");
        }
        if (egg.getImageView().getLayoutX() >= 10) {
            egg.getImageView().setLayoutX(egg.getImageView().getLayoutX() - 5);
            int frame = (int) Math.floor(v * 23);
            egg.setBackground("/com/example/game/img/Egg/" + frame + ".png");
        }
        else {
            pane.getChildren().remove(egg.getImageView());
        }
    }
}
