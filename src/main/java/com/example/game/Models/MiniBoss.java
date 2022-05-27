package com.example.game.Models;

import com.example.game.Controllers.BombAnimation;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MiniBoss {

    private static ArrayList<MiniBoss> miniBosses = new ArrayList<>();
    private static AnchorPane pane;
    private ImageView imageView;

    public MiniBoss(AnchorPane anchorPane) {
        pane = anchorPane;
        this.imageView = createImageView();
        miniBosses.add(this);
    }

    private ImageView createImageView(){
        ImageView imageView = new ImageView();
        ImagePattern miniBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/MiniBossFly/0.png").toExternalForm()));
        imageView.setImage(miniBoss.getImage());

        imageView.setLayoutX(695);
        imageView.setLayoutY(300);

        pane.getChildren().add(imageView);
        imageView.setVisible(true);

        return imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setBackground(String url) {
        imageView.setImage(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())).getImage());
    }

    public void removeMiniBoss(MiniBoss miniBoss) {
        pane.getChildren().remove(miniBoss.getImageView());
        miniBosses.remove(miniBoss);
    }
}
