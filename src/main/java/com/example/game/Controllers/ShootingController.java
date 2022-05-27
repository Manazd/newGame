package com.example.game.Controllers;

import javafx.animation.Transition;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShootingController extends Transition {

    public static void run(ImageView plane) {
        ImageView imageView = new ImageView();
        Image bullet = new Image("/com/example/game/")
        imageView.setX(plane.getX() + 10);
        imageView.setY(plane.getY());
    }
    @Override
    protected void interpolate(double v) {

    }
}
