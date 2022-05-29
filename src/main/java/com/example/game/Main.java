package com.example.game;

import com.example.game.Controllers.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private static Stage mainStage;
    private static Scene scene;
    private static Media media;
    private static MediaPlayer player;
    private static MediaView mediaView;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        media = new Media(getClass().getResource("/com/example/game/Audio/menuMusic.mp3").toExternalForm());
        player = new MediaPlayer(media);
        mediaView = new MediaView(player);
        mainStage = stage;
        mainStage.setResizable(false);
        Parent root = loadFXML("newLoginPage");
        stage.setTitle("CupHead game");
        Scene scene = new Scene(root);
        UserController.loadUsers();
        stage.setScene(scene);
        stage.show();
        player.play();
    }

    public static void closeWindow() {
        mainStage.close();
    }

    public static void changeScene(String fxmlName) throws IOException {
        Parent root = loadFXML(fxmlName);
        mainStage.getScene().setRoot(root);
    }

    private static Parent loadFXML(String name){
        try {
            URL address = new URL(Main.class.getResource("/com/example/game/fxml/" + name + ".fxml").toExternalForm());
            return FXMLLoader.load(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void stopMusic() {
        player.stop();
    }

    public static void playMusic() {
        player.play();
    }
}

