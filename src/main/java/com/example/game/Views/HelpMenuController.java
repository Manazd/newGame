package com.example.game.Views;

import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelpMenuController {
    @FXML
    private Button back;

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("pauseMenu");
    }
}
