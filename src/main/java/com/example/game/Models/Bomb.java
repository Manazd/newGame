package com.example.game.Models;

import com.example.game.Controllers.BombHitBossAnimation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        ImagePattern bomb = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Plane/Plane/Mini/Super/bomb/0.png").toExternalForm()));
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

    public double getLayoutY() {
        return Y;
    }

    public double getLayoutX() {
        return X;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setBackground(String url) {
        imageView.setImage(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())).getImage());
    }

    public static void removeBomb(Bomb bomb) {
        bombs.remove(bomb);
    }

    public boolean bombHitBoss() {
        return this.getImageView().getLayoutX() >= Boss.getInstance(pane).getLayoutX() - 40
                && this.getImageView().getLayoutY() >= Boss.getInstance(pane).getLayoutY()
                && this.getImageView().getLayoutY() <= Boss.getInstance(pane).getLayoutY() + 140;
    }

    public void explode() {
        BombHitBossAnimation animation = new BombHitBossAnimation(this, pane);
        animation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(Bomb.this.getImageView());
            }
        });
        animation.play();
    }
}
