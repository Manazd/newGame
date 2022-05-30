package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ChooseAvatarPageController {
    @FXML
    private Button back;
    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView three;
    @FXML
    private ImageView four;
    @FXML
    private ImageView five;
    @FXML
    private ImageView six;

    public void setOne(MouseEvent mouseEvent) {
        UserController.getLoggedInUser().setAvatarNumber(1);
    }

    public void setTwo(MouseEvent mouseEvent) {
        UserController.getLoggedInUser().setAvatarNumber(2);
    }

    public void setThree(MouseEvent mouseEvent) {
        UserController.getLoggedInUser().setAvatarNumber(4);
    }

    public void setFour(MouseEvent mouseEvent) {
        UserController.getLoggedInUser().setAvatarNumber(9);
    }

    public void setFive(MouseEvent mouseEvent) {
        UserController.getLoggedInUser().setAvatarNumber(5);
    }

    public void setSix(MouseEvent mouseEvent) {
        UserController.getLoggedInUser().setAvatarNumber(7);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newProfilePage");
    }
}
