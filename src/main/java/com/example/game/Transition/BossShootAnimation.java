package com.example.game.Transition;

import com.example.game.Models.Boss;
import com.example.game.Models.Egg;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;


public class BossShootAnimation extends Transition {

    private AnchorPane pane;
    private ImageView imageView;

    public BossShootAnimation(AnchorPane pane) {
        this.pane = pane;
        this.imageView = new ImageView();
        ImagePattern shootBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/BossShoot/0.png").toExternalForm()));
        imageView.setImage(shootBoss.getImage());
        imageView.setLayoutX(560);
        imageView.setLayoutY(140);
        pane.getChildren().add(imageView);
        this.setCycleDuration(Duration.millis(1600));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 11);
        ImagePattern shootBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/BossShoot/" + frame + ".png").toExternalForm()));
        imageView.setImage(shootBoss.getImage());
    }

    public ImageView getImageView() {
        return this.imageView;
    }
}
