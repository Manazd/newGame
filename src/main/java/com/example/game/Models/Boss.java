package com.example.game.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;

public class Boss {

    private static Boss bossInstance;
    private ImageView imageView;
    private static AnchorPane pane;
    private double X;
    private double Y;
    private int lives = 50;

    public static Boss getInstance(AnchorPane pane) {
        if (bossInstance == null) {
            bossInstance = new Boss(pane);
            return bossInstance;
        }
        return bossInstance;
    }

    private Boss(AnchorPane pane) {
        ImageView imageView = new ImageView();
        ImagePattern boss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/BossFly/0.png").toExternalForm()));
        imageView.setImage(boss.getImage());

        imageView.setLayoutX(600);
        imageView.setLayoutY(130);
        this.X = imageView.getLayoutX();
        this.Y = imageView.getLayoutY();

        pane.getChildren().add(imageView);
        imageView.setVisible(true);

        this.imageView = imageView;
    }

    public void setBackground(String url) {
        imageView.setImage(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())).getImage());
    }

    public double getLayoutX() {
        return X;
    }

    public double getLayoutY() {
        return Y;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public ImageView getImageView() {
        return this.imageView;
    }
}
