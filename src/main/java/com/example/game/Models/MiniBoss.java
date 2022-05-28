package com.example.game.Models;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MiniBoss {

    private static ArrayList<MiniBoss> miniBosses = new ArrayList<>();
    private static AnchorPane pane;
    private ImageView imageView;
    private boolean isPink;

    public MiniBoss(AnchorPane anchorPane, int counter) {
        pane = anchorPane;
        this.imageView = createImageView(counter);
        miniBosses.add(this);
    }

    private ImageView createImageView(int counter){
        ImageView imageView = new ImageView();
        if (counter == 0) {
            ImagePattern miniBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/MiniBossFly/pink/0.png").toExternalForm()));
            imageView.setImage(miniBoss.getImage());
            imageView.setLayoutX(695);
            isPink = true;
        }
        else if (counter == 1) {
            ImagePattern miniBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/MiniBossFly/pink/0.png").toExternalForm()));
            imageView.setImage(miniBoss.getImage());
            imageView.setLayoutX(630);
            isPink = true;
        }
        else if (counter == 2) {
            ImagePattern miniBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/MiniBossFly/yellow/0.png").toExternalForm()));
            imageView.setImage(miniBoss.getImage());
            imageView.setLayoutX(565);
        }
        else if (counter == 3) {
            ImagePattern miniBoss = new ImagePattern(new Image(getClass().getResource("/com/example/game/img/MiniBossFly/yellow/0.png").toExternalForm()));
            imageView.setImage(miniBoss.getImage());
            imageView.setLayoutX(500);
        }


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

    public boolean isPink() {
        return isPink;
    }
}
