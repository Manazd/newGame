package com.example.game.Models;

import com.example.game.Controllers.BombAnimation;
import com.example.game.Controllers.ShootingBulletAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;

public class Bomb {

    private static ArrayList<Bomb> bombs = new ArrayList<>();
    private double X;
    private double Y;
    private ImageView imageView;
    private static AnchorPane pane;

    public Bomb(ImageView plane, AnchorPane pane){
        ImageView bombImage = createImageView(pane, plane);
        this.X = bombImage.getLayoutX();
        this.Y = bombImage.getLayoutY();
        imageView = bombImage;
        bombs.add(this);
        setPane(pane);
    }

    private void setPane(AnchorPane pane) {
        Bomb.pane = pane;
    }

    private ImageView createImageView(AnchorPane pane, ImageView plane) {
        ImageView imageView = new ImageView();
        ImagePattern bomb = new ImagePattern(new Image(ShootingBulletAnimation.class.getResource("/com/example/game/img/Plane/Plane/Mini/Super/bomb/0.png").toExternalForm()));
        imageView.setImage(bomb.getImage());

        imageView.setLayoutX(plane.getLayoutX() + 50);
        imageView.setLayoutY(plane.getLayoutY() + 35);

        pane.getChildren().add(imageView);
        imageView.setVisible(true);

        return imageView;
    }

    public static ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getLayoutY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setBackground(String url) {
        imageView.setImage(new ImagePattern(new Image(BombAnimation.class.getResource(url).toExternalForm())).getImage());
    }

    public static void removeBomb(Bomb bomb) {
        pane.getChildren().remove(bomb.getImageView());
        bombs.remove(bomb);
    }
}
