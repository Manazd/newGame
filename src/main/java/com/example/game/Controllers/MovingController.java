package com.example.game.Controllers;

import javafx.scene.image.ImageView;

public class MovingController {

    public static void moveLeft(ImageView image) {
        if (!hitLeftWall(image))
            image.setLayoutX(image.getLayoutX() - 10);
    }

    public static void moveRight(ImageView image) {
        if (!hitRightWall(image))
            image.setLayoutX(image.getLayoutX() + 10);
    }

    public static void moveUp(ImageView image) {
        if (!hitUpWall(image))
            image.setLayoutY(image.getLayoutY() - 10);
    }

    public static void moveDown(ImageView image) {
        if (!hitDownWall(image))
            image.setLayoutY(image.getLayoutY() + 10);
    }

    private static boolean hitRightWall(ImageView image) {
        return image.getLayoutX() >= 695;
    }

    private static boolean hitLeftWall(ImageView image) {
        return image.getLayoutX() <= -10;
    }

    private static boolean hitUpWall(ImageView image) {
        return image.getLayoutY() <= 0;
    }

    private static boolean hitDownWall(ImageView image) {
        return image.getLayoutY() >= 390;
    }
}
