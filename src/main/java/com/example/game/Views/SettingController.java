package com.example.game.Views;

import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class SettingController {

    @FXML
    private Button back;

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newMainPage");
    }
}
