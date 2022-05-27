module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;

    opens com.example.game.Models to com.google.gson, javafx.base;
    opens com.example.game to javafx.fxml;
    opens com.example.game.Views to javafx.fxml;
//    opens com.example.game.Models to javafx.base;
    exports com.example.game;
}