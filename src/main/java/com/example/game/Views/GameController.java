package com.example.game.Views;

import com.example.game.Controllers.*;
import com.example.game.Main;
import com.example.game.Models.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class GameController implements Initializable {

    public AnchorPane pane;
    @FXML
    private Button musicOff;
    @FXML
    private Button musicOn;
    @FXML
    private Text playerLives;
    @FXML
    private Text bossLives;
    @FXML
    private Button pause;
    @FXML
    private ImageView plane;

    private User player;
    private int levelOfGame;
    private ImageView boss;
    private static Media media;
    private static MediaPlayer mediaPlayer;
    private static MediaView mediaView;
    private static boolean musicStop;
    public static int second = 0;

    public static boolean isMusicStop() {
        return musicStop;
    }

    public static void setMusicStop(boolean musicStop) {
        GameController.musicStop = musicStop;
    }


//    public Timer timer = new Timer();
//    public TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            second++;
//            System.out.println(second);
//            if (second % 10 == 0)
//                createMiniBoss();
//            timer.cancel();
//            timer.purge();
//        }
//    };

    private void run() {
        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case LEFT:
                        MovingController.moveLeft(plane);
                        break;
                    case RIGHT:
                        MovingController.moveRight(plane);
                        break;
                    case UP:
                        MovingController.moveUp(plane);
                        break;
                    case DOWN:
                        MovingController.moveDown(plane);
                        break;
                    case SPACE:
                        shootBullet();
                        break;
                    case ENTER:
                        transformToBomb();
                        break;
                    case W:
                        bossShoot();
                        break;
                    case A:
                        makeEgg();
                        break;
                }
            }
        });
    }

    private void makeEgg() {
        Egg egg = new Egg(pane, 560, 140, plane);
        EggAnimation animation = new EggAnimation(pane, egg);
        animation.play();

    }

    private void bossShoot() {
        pane.getChildren().remove(Boss.getInstance(pane).getImageView());
        Boss.getInstance(pane).shoot(pane);
//        pane.getChildren().add(Boss.getInstance(pane).getImageView());
    }

    private void transformToBomb() {
        pane.getChildren().remove(plane);
        Bomb bomb = new Bomb(plane, pane);
        BombAnimation bombAnimation = new BombAnimation(bomb, pane);
        bombAnimation.play();
    }

    private void shootBullet() {
        Bullet bullet = new Bullet(plane, pane);
        ShootingBulletAnimation shooting = new ShootingBulletAnimation(bullet, pane, bossLives, playerLives);
        shooting.play();
        AudioClip shoot = new AudioClip(this.getClass().getResource("/com/example/game/Audio/gunShoot.mp3").toExternalForm());
        shoot.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Boss.getInstance(pane).getImageView().setVisible(true);
        handleLives();
        if (!musicStop) {
            handleMusic();
        }

//        timer.scheduleAtFixedRate(task, 1000, 1000);

        BossAnimation bossAnimation = new BossAnimation(Boss.getInstance(pane));
        bossAnimation.play();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.requestFocus();
                createMiniBoss();
            }
        });
//        createMiniBoss();
        run();
        this.levelOfGame = 2;
    }

    private void handleLives() {
        if (UserController.getLoggedInUser() != null) {
            this.player = UserController.getLoggedInUser();
            this.playerLives.setText(Integer.toString(player.getGameLevel().getPrimaryLives()));
        }
        else
            this.playerLives.setText("5");
        Boss.getInstance(pane).setLives(15);
        this.bossLives.setText("15");
    }

    private void handleMusic() {
        media = new Media(getClass().getResource("/com/example/game/Audio/gameMusic.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();
    }

    private void createMiniBoss() {
        for (int i = 0; i < 4; i++) {
            MiniBoss miniBoss = new MiniBoss(pane, i);
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(miniBoss);
            miniBossAnimation.play();
        }
    }

    public void setBossLives(String lives) {
        bossLives.setText(null);
        bossLives.setText(lives);
    }

    public void pauseGame(ActionEvent actionEvent) throws IOException {
        Main.changeScene("pauseMenu");
    }

    public static void stopMusic() {
        mediaPlayer.stop();
    }

    public static void playMusic() {
        mediaPlayer.play();
    }

    public void stopMusic(ActionEvent actionEvent) {
        mediaPlayer.stop();
    }

    public void playMusic(ActionEvent actionEvent) {
        mediaPlayer.play();
    }
}
