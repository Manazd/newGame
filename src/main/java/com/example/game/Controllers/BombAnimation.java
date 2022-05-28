package com.example.game.Controllers;

import com.example.game.Models.Bomb;
import com.example.game.Models.Boss;
import com.example.game.Views.GameController;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.text.PlainDocument;
import javax.swing.text.html.ImageView;

public class BombAnimation extends Transition {

    private Bomb bomb;
    private AnchorPane pane;

    public BombAnimation(Bomb bomb, AnchorPane pane) {
        this.bomb = bomb;
        this.pane = pane;
        this.setCycleDuration(Duration.millis(2000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        if (bomb.bombHitBoss()) {
            Boss boss = Boss.getInstance(pane);
            boss.setLives(boss.getLives() - 4);
//            GameController.setBossLives(Integer.toString(boss.getLives()));
            this.stop();
            bomb.explode();
            Bomb.removeBomb(bomb);
        }
        if (bomb.getImageView().getLayoutX() <= 700) {
            bomb.getImageView().setLayoutX(bomb.getImageView().getLayoutX() + 5);
            int frame = (int) Math.floor(v * 23);
            bomb.setBackground("/com/example/game/img/Plane/Plane/Mini/Super/bomb/" + frame + ".png");
        }
        else {
            pane.getChildren().remove(bomb.getImageView());
            Bomb.removeBomb(bomb);
        }
    }

    private void live() {

    }
}
