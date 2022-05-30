package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LosePageController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private Text score;
    @FXML
    private Text seconds;

    public void goBack(ActionEvent actionEvent) throws IOException {
        if (UserController.getLoggedInUser() == null)
            Main.changeScene("newLoginPage");
        else
            Main.changeScene("newMainPage");
        Main.playMusic();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.seconds.setText(null);
        if (UserController.getLoggedInUser() != null)
            this.score.setText(Integer.toString(UserController.getLoggedInUser().getScore()));
        else
            this.score.setText(Integer.toString(GameController.getGuestPlayerScore()));
        this.seconds.setText(Integer.toString(GameController.getSecond()));
    }
}
