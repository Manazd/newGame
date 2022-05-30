package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import com.example.game.Models.GameLevel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;

import java.io.IOException;

public class SettingController {

    @FXML
    private Button easy;
    @FXML
    private Button hard;
    @FXML
    private Button medium;
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

    public void setMedium(ActionEvent actionEvent) {
        UserController.getLoggedInUser().setGameLevel(new GameLevel(2));
    }

    public void setHard(ActionEvent actionEvent) {
        UserController.getLoggedInUser().setGameLevel(new GameLevel(3));
    }

    public void setEasy(ActionEvent actionEvent) {
        UserController.getLoggedInUser().setGameLevel(new GameLevel(1));
    }

}
