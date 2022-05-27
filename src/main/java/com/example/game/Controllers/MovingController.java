package com.example.game.Controllers;

import javafx.scene.image.ImageView;

public class MovingController {

    public static void moveLeft(ImageView image) {
        if (!hitLeftWall(image))
            image.setX(image.getX() - 10);
    }

    public static void moveRight(ImageView image) {
        if (!hitRightWall(image))
            image.setX(image.getX() + 10);
    }

    public static void moveUp(ImageView image) {
        if (!hitUpWall(image))
            image.setY(image.getY() - 10);
    }

    public static void moveDown(ImageView image) {
        if (!hitDownWall(image))
            image.setY(image.getY() + 10);
    }

    private static boolean hitRightWall(ImageView image) {
        return image.getX() >= 670;
    }

    private static boolean hitLeftWall(ImageView image) {
        return image.getX() <= -40;
    }

    private static boolean hitUpWall(ImageView image) {
        return image.getY() <= -155;
    }

    private static boolean hitDownWall(ImageView image) {
        return image.getY() >= 195;
    }
}
