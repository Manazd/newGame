package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import com.example.game.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;


public class LoginAndRegisterController {

    @FXML
    public Button guestButton;
    public Button chooseImage;
    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Text userPassError;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    private boolean hasError;



    public void loginUser() throws IOException {
        String name = username.getText();
        String pass = password.getText();
        User user = UserController.getUser(name, pass);
        checkUserInfo(name, pass);

        if (!hasError) {
            if (user == null) {
                userPassError.setText("Username and password don't match!");
            } else {
                user.setLoggedIn(true);
                UserController.setLoggedInUser(user);
                Main.changeScene("newMainPage");
            }
        }
        hasError = false;
    }

    private void checkUserInfo(String name, String pass) throws IOException {
        if (name.isEmpty()) {
            userPassError.setText("Please enter your username!");
            hasError = true;
        }
        else if (pass.isEmpty()) {
            userPassError.setText("Please enter your password!");
            hasError = true;
        }
    }

    public void registerUser(ActionEvent actionEvent) throws IOException {
        String name = username.getText();
        String pass = password.getText();
        checkUserInfo(name, pass);

        if (!hasError) {
            if (UserController.getUserByUsername(name) != null) {
                userPassError.setText("User with name \"" + name + "\" already exists!");
            } else {
                UserController.createUser(name, pass);
                UserController.setLoggedInUser(UserController.getUserByUsername(name));
                Main.changeScene("newMainPage");
            }
        }
        hasError = false;
    }

    public void playAsGuest(ActionEvent actionEvent) throws IOException {
        Main.stopMusic();
        Main.changeScene("game");
    }
}
