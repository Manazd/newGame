package com.example.game.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;

public class Egg {

    private AnchorPane pane;
    private ImageView imageView;
    private ImageView plane;

    public Egg(AnchorPane pane, double x, double y, ImageView plane) {
        this.pane = pane;
        this.plane = plane;
        ImageView imageView = new ImageView();
        ImagePattern egg = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Egg/0.png").toExternalForm()));
        imageView.setImage(egg.getImage());
        imageView.setLayoutX(x - 10);
        imageView.setLayoutY(y);
        pane.getChildren().add(imageView);
        this.imageView = imageView;
        imageView.setVisible(true);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setBackground(String url) {
        imageView.setImage(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())).getImage());
    }

    public boolean hitSomething() {
        return this.getImageView().getLayoutX() == plane.getLayoutX() + 1
                && this.getImageView().getLayoutY() == plane.getLayoutY() - 40;
    }
}
