package com.example.six_qui_prend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ImageView backgroundImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage.setPreserveRatio(true); // Définit preserveRatio sur true
        Scene scene = backgroundImage.getScene();
        if (scene != null) {
            backgroundImage.fitWidthProperty().bind(scene.widthProperty());
            backgroundImage.fitHeightProperty().bind(scene.heightProperty());
        } else {
            backgroundImage.sceneProperty().addListener((observable, oldScene, newScene) -> {
                backgroundImage.fitWidthProperty().bind(newScene.widthProperty());
                backgroundImage.fitHeightProperty().bind(newScene.heightProperty());
            });
        }
    }

    @FXML
    protected void onStartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-playing.fxml"));
        StackPane root = fxmlLoader.load();
        Stage stage = (Stage) backgroundImage.getScene().getWindow();
        boolean wasFullScreen = stage.isFullScreen(); // Save the current state of the full screen mode
        Scene introScene = new Scene(root);

        // Initialize the scene before accessing its properties
        stage.setScene(introScene);
        stage.setTitle("6 qui prend!");
        stage.setFullScreen(wasFullScreen); // Restore the full screen mode
        stage.show();

        // Pass the text to the next scene
        GameController introController = fxmlLoader.getController();
    }
}