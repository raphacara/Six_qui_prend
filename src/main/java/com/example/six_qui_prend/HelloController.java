package com.example.six_qui_prend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    public Label startingText;

    @FXML
    public StackPane root;

    @FXML
    private ImageView backgroundImage;

    public void initialize() {
        if (root != null && root.getScene() != null) {
            Stage stage = (Stage) root.getScene().getWindow();
            backgroundImage.fitWidthProperty().bind(stage.widthProperty());
            backgroundImage.fitHeightProperty().bind(stage.heightProperty());
        }
    }

    @FXML
    protected void onStartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-view.fxml"));
        StackPane root = fxmlLoader.load();
        Stage stage = (Stage) root.getScene().getWindow();
        boolean wasFullScreen = stage.isFullScreen(); // Save the current state of the full screen mode
        Scene introScene = new Scene(root);
        stage.setScene(introScene);
        stage.setTitle("6 qui prend !");
        stage.setFullScreen(wasFullScreen); // Restore the full screen mode
        stage.show();

        // Pass the text to the next scene
        GameController GameController = fxmlLoader.getController();
    }
}