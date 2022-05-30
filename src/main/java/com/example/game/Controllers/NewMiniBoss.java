package com.example.game.Controllers;

import com.example.game.Models.MiniBoss;
import com.example.game.Views.GameController;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

public class NewMiniBoss extends Thread{

    private AnchorPane pane;

    public NewMiniBoss(AnchorPane pane) {
        this.pane = pane;
    }

    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    MiniBoss miniBoss = new MiniBoss(pane, i);
                    MiniBossAnimation miniBossAnimation = new MiniBossAnimation(miniBoss);
                    miniBossAnimation.play();
                }
            }
        });
    }
}
