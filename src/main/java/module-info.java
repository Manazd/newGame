module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;
    requires javafx.media;
//    requires javafx.graphics;
//    requires java.base;
//    requires java.xml;
//    requires org.controlsfx.controls;

    opens com.example.game.Models to com.google.gson, javafx.base;
    opens com.example.game to javafx.fxml;
    opens com.example.game.Views to javafx.fxml, javafx.media;
//    opens com.example.game.Controllers to javafx.graphics, javafx.media;
    exports com.example.game;
}