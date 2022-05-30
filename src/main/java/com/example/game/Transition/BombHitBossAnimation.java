package com.example.game.Transition;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import com.example.game.Models.Bomb;
import com.example.game.Models.Boss;
import com.example.game.Views.GameController;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.io.IOException;

public class BombHitBossAnimation extends Transition {
    private Bomb bomb;
    private AnchorPane pane;
    private ImageView imageView;
    private Text bossLives;
    private Text playerScores;

    public BombHitBossAnimation(Bomb bomb, AnchorPane pane, Text bossLives, Text playerScores) {
        this.bomb = bomb;
        this.pane = pane;
        this.bossLives = bossLives;
        this.playerScores = playerScores;
        ImageView imageView = new ImageView();
        imageView.setLayoutX(bomb.getLayoutX() + 50);
        imageView.setLayoutY(bomb.getLayoutY());
        this.imageView = imageView;

        pane.getChildren().add(imageView);
        setCycleDuration(Duration.millis(500));
    }
    @Override
    protected void interpolate(double v) {
        handleScores();
        int frame = (int) Math.floor(v * 11);
        ImagePattern dust = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/Hit Dust/" + frame + ".png").toExternalForm()));
        bomb.getImageView().setImage(dust.getImage());
    }

    public void handleScores() {
        int bossLives;
        Boss boss = Boss.getInstance(pane);
        if (UserController.getLoggedInUser() != null) {
            int score = UserController.getLoggedInUser().getGameLevel().getPower() * 4;
            boss.setLives(boss.getLives() - score);
            UserController.getLoggedInUser().setScore(score);
            if ((bossLives = boss.getLives()) <= 0) {
                try {
                    GameController.stopMusic();
                    GameController.setGameOff(true);
                    Main.changeScene("losePage");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                this.bossLives.setText(Integer.toString(bossLives));
                this.playerScores.setText(Integer.toString(UserController.getLoggedInUser().getScore()));
            }
        }
        else {
            GameController.setGuestPlayerScore(GameController.getGuestPlayerScore() + 4);
            boss.setLives(boss.getLives() - 2);
            if ((bossLives = boss.getLives()) <= 0) {
                try {
                    GameController.stopMusic();
                    GameController.setGameOff(true);
                    Main.changeScene("losePage");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                this.bossLives.setText(Integer.toString(boss.getLives()));
                this.playerScores.setText(Integer.toString(GameController.getGuestPlayerScore()));
            }
        }
    }
}
