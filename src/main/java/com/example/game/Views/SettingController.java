package com.example.game.Views;

import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SettingController {

    @FXML
    private Button pause;
    @FXML
    private Button play;
    @FXML
    private Button back;

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newMainPage");
    }

    public void pauseMusic(ActionEvent actionEvent) {
        Main.stopMusic();
    }

    public void playMusic(ActionEvent actionEvent) {
        Main.playMusic();
    }
}
