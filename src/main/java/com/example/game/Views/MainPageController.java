package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainPageController {

    @FXML
    private Button back;
    @FXML
    private Button newGame;
    @FXML
    private Button scores;
    @FXML
    private Button exit;
    @FXML
    private Button profile;
    @FXML
    private Button setting;
    public static boolean windowIsClosed = false;

    public void showProfile(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newProfilePage");
    }

    public void newGame(ActionEvent actionEvent) throws IOException {
        Main.stopMusic();
        Main.changeScene("game");
    }

    public void showScores(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newScoresPage");
    }

    public void exit(ActionEvent actionEvent) {
        UserController.saveUsers();
        windowIsClosed = true;
        Main.closeWindow();
    }

    public void showSetting(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newSettingPage");
    }

    public static boolean windowIsClosed() {
        return windowIsClosed;
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newLoginPage");
    }
}
