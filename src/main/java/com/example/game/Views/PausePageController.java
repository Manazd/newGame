package com.example.game.Views;

import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PausePageController implements Initializable {

    public Text saveGame;
    @FXML
    private Button help;
    @FXML
    private Button stopMusic;
    @FXML
    private Button playMusic;
    @FXML
    private Button save;
    @FXML
    private Button exit;
    @FXML
    private Button restart;

    private boolean hasText;

    public void save(ActionEvent actionEvent) {
        hasText = true;
        saveGame.setText("Game saved!");
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        setNull();
        GameController.setMusicStop(false);
        GameController.stopMusic();
        Main.playMusic();
        Main.changeScene("newMainPage");
    }

    public void restart(ActionEvent actionEvent) throws IOException {
        setNull();
        Main.changeScene("game");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNull();
    }

    private void setNull() {
        if (hasText)
            saveGame.setText(null);
    }

    public void stopMusic(ActionEvent actionEvent) {
        setNull();
        GameController.setMusicStop(true);
        GameController.stopMusic();
    }

    public void playMusic(ActionEvent actionEvent) {
        setNull();
        GameController.setMusicStop(false);
        GameController.playMusic();
    }

    public void showHelpMenu(ActionEvent actionEvent) throws IOException {
        Main.changeScene("helpMenu");
    }
}
