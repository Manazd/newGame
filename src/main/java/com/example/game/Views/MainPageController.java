package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;

public class MainPageController {
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
        Main.changeScene("newGame");
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
        Main.changeScene("settingPage");
    }

    public static boolean windowIsClosed() {
        return windowIsClosed;
    }
}
