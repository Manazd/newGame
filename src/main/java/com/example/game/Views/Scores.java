package com.example.game.Views;

import com.example.game.Controllers.UserController;
import com.example.game.Main;
import com.example.game.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class Scores implements Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, Integer> number;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, Integer> score;
    @FXML
    private Button back;

    public static void sortScores() {
        ArrayList<User> users = UserController.getUsers();
        for (int i = 0; i < users.size(); i++) {
            for (int j = i+1; j < users.size(); j++) {
                if (users.get(i).getScore() < users.get(j).getScore()) {
                    Collections.swap(UserController.getUsers(), i, j);
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sortScores();
        // TODO number of rows
//        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        tableView.setItems(getBestUsers());
    }

    private ObservableList<User> getBestUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();
        if (UserController.getUsers().size() >= 10) {
            for (int i = 0; i < 10; i++) {
                users.add(UserController.getUsers().get(i));
            }
        }
        else {
            users.addAll(UserController.getUsers());
        }
        return users;
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.changeScene("mainPage");
    }
}

