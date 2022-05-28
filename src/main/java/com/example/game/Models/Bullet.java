package com.example.game.Models;

import com.example.game.Controllers.BulletHitBossAnimation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private static AnchorPane pane;

    public Bullet(ImageView plane, AnchorPane pane) {
        ImageView bulletImage = createImageView(plane, pane);
        this.X = bulletImage.getLayoutX();
        this.Y = bulletImage.getLayoutY();
        imageView = bulletImage;
        bullets.add(this);
        setPane(pane);
    }

    public static AnchorPane getPane() {
        return pane;
    }

    public void setPane(AnchorPane pane) {
        Bullet.pane = pane;
    }

    private ImageView createImageView(ImageView plane, AnchorPane pane) {
        ImageView imageView = new ImageView();
        ImagePattern bullet = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Plane/Plane/Mini/Bullet/0.png").toExternalForm()));
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
        imageView.setImage(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())).getImage());
    }

    public void removeBullet(Bullet bullet) {
        pane.getChildren().remove(bullet.getImageView());
        bullets.remove(bullet);
    }

    public boolean bulletHitBoss() {
        return this.getImageView().getLayoutX() >= Boss.getInstance(pane).getLayoutX() - 40
                && this.getImageView().getLayoutY() >= Boss.getInstance(pane).getLayoutY()
                && this.getImageView().getLayoutY() <= Boss.getInstance(pane).getLayoutY() + 140;
    }

    public void explode() {
        BulletHitBossAnimation animation = new BulletHitBossAnimation(this, pane);
        animation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(Bullet.this.getImageView());
            }
        });
        animation.play();
    }
}

