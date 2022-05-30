package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import com.example.game.Models.User;
//import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {

    @FXML
    public Button changeImage;
    @FXML
    private Text name;
    @FXML
    private Button delete;
    @FXML
    private Button changeName;
    @FXML
    private Button changePass;
    @FXML
    private Button logout;
    @FXML
    private Text successful;
    @FXML
    private TextField newUsername;
    @FXML
    private TextField newPassword;
    @FXML
    private Text error;
    @FXML
    private Button back;
    @FXML
    private Button gameAvatars;
    @FXML
    public ImageView imageView;
    private FileChooser fileChooser;
    private File filePath;

    public void chooseImage(ActionEvent actionEvent) {
        // choose image
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("choose image");

        this.filePath = fileChooser.showOpenDialog(stage);

        try {
            BufferedImage bufferedImage = ImageIO.read(filePath);
//            ImagePattern Boss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/avatars/" + UserController.getLoggedInUser().getAvatarNumber() + ".png").toExternalForm()));
//            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
//            this.imageView.setImage(image);
//            UserController.getLoggedInUser().setAvatar(image);
//            UserController.getLoggedInUser().setAvatarURL();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void logoutUser(ActionEvent actionEvent) throws IOException {
        User currentUser = UserController.getLoggedInUser();
        currentUser.setLoggedIn(false);
        UserController.setLoggedInUser(null);
        Main.changeScene("newLoginPage");
    }

    public void changeUsername(ActionEvent actionEvent) {
        String newName = newUsername.getText();

        setNull();
        if (newName.isEmpty()) {
            error.setText("Please enter your new username!");
        } else if (UserController.getUserByUsername(newName) != null) {
            error.setText("User with name " + newName + " already exists!");
        } else {
            User user = UserController.getLoggedInUser();
            user.setUsername(newName);
            name.setText(null);
            name.setText(UserController.getLoggedInUser().getUsername());
            successful.setText("Username changed successfully!");
        }
    }

    public void changePassword(ActionEvent actionEvent) {
        String newPass = newPassword.getText();
        setNull();
        if (newPass.isEmpty()) {
            error.setText("Please enter your new password!");
        } else {
            User user = UserController.getLoggedInUser();
            user.setPassword(newPass);
            successful.setText("Password changed successfully!");
        }
    }

    private void setNull() {
        error.setText(null);
        successful.setText(null);
    }

    public void deleteUser(ActionEvent actionEvent) throws IOException {
        User user = UserController.getLoggedInUser();
        UserController.removeUser(user);
        UserController.setLoggedInUser(null);
        Main.changeScene("newLoginPage");
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("newMainPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setText(UserController.getLoggedInUser().getUsername());
        ImagePattern Boss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/avatars/" + UserController.getLoggedInUser().getAvatarNumber() + ".png").toExternalForm()));
        this.imageView.setImage(Boss.getImage());
    }

    public void showAvatars(ActionEvent actionEvent) throws IOException {
        Main.changeScene("chooseAvatar");
    }
}

