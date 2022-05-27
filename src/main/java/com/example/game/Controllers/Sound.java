package com.example.game.Controllers;

import javafx.scene.media.AudioClip;

public class Sound {

    public static void shootBullet() {
        AudioClip shoot = new AudioClip(Sound.class.getResource("/com/example/game/Audio/gunShoot.mp3").toExternalForm());
        shoot.play();
    }
}
