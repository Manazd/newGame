package com.example.game.Models;

import com.example.game.Controllers.ShootingBulletAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;

public class Bullet {

    private static ArrayList<Bullet> bullets = new ArrayList<>();
    private double X;
    private double Y;
    private ImageView imageView;

    public Bullet(ImageView plane, AnchorPane pane) {
        ImageView bulletImage = createImageView(plane, pane);
        this.X = bulletImage.getLayoutX();
        this.Y = bulletImage.getLayoutY();
        imageView = bulletImage;
        bullets.add(this);
    }

    private ImageView createImageView(ImageView plane, AnchorPane pane) {
        ImageView imageView = new ImageView();
        ImagePattern bullet = new ImagePattern(new Image(ShootingBulletAnimation.class.getResource("/com/example/game/img/Plane/Plane/Mini/Bullet/0.png").toExternalForm()));
        imageView.setImage(bullet.getImage());

        imageView.setLayoutX(plane.getLayoutX() + 50);
        imageView.setLayoutY(plane.getLayoutY() + 45);

        pane.getChildren().add(imageView);
        imageView.setVisible(true);

        return imageView;
    }

    public static ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public double getLayoutX() {
        return X;
    }

    public void setLayoutX(double x) {
        X = x;
    }

    public double getLayoutY() {
        return Y;
    }

    public void setLayoutY(double y) {
        Y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setBackground(String url) {
        imageView.setImage(new ImagePattern(new Image(ShootingBulletAnimation.class.getResource(url).toExternalForm())).getImage());
    }
}

