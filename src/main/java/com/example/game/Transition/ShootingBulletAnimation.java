package com.example.game.Transition;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import com.example.game.Models.Boss;
import com.example.game.Models.Bullet;
import com.example.game.Views.GameController;
import javafx.animation.Transition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

public class ShootingBulletAnimation extends Transition {
    private Bullet bullet;
    private AnchorPane pane;
    private Text bossLives;
    private Text playerLives;
    private Text playerScores;

    public ShootingBulletAnimation(Bullet bullet, AnchorPane pane, Text bossLives, Text playerLives, Text playerScores) {
        this.bullet = bullet;
        this.bossLives = bossLives;
        this.playerLives = playerLives;
        this.playerScores = playerScores;
        this.setCycleDuration(Duration.millis(1800));
        this.setCycleCount(-1);
        this.pane = pane;
    }

    @Override
    protected void interpolate(double v) {
        if (bullet.bulletHitBoss()) {
            handleScores();
            this.stop();
            bullet.explode();
            bullet.removeBullet(bullet);
        }
        else {
            if (bullet.getImageView().getLayoutX() <= 700) {
                bullet.getImageView().setLayoutX(bullet.getImageView().getLayoutX() + 10);
                int frame = (int) Math.floor(v * 8);
                bullet.setBackground("/com/example/game/img/Plane/Plane/Mini/Bullet/" + frame + ".png");
            } else {
                pane.getChildren().remove(bullet.getImageView());
            }
        }
    }

    public void handleScores() {
        int bossLives;
        Boss boss = Boss.getInstance(pane);
        if (UserController.getLoggedInUser() != null) {
            int score = UserController.getLoggedInUser().getGameLevel().getPower();
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
            GameController.setGuestPlayerScore(GameController.getGuestPlayerScore() + 2);
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
