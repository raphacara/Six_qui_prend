package com.example.six_qui_prend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    public Label startingText;

    @FXML
    public StackPane stackPaneRoot;

    @FXML
    private ImageView backgroundImage;

    public void initialize() {
        if (stackPaneRoot != null && stackPaneRoot.getScene() != null) {
            Stage stage = (Stage) stackPaneRoot.getScene().getWindow();
            backgroundImage.fitWidthProperty().bind(stage.widthProperty());
            backgroundImage.fitHeightProperty().bind(stage.heightProperty());
        }
    }

    @FXML
    private Button playButton;

    @FXML
    private void onStartButtonClick(ActionEvent event) {
        try {
            // Charger le fichier FXML de la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("start-playing.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle à partir du bouton "Play"
            Scene currentScene = playButton.getScene();

            // Obtenir la fenêtre principale à partir de la scène actuelle
            Stage primaryStage = (Stage) currentScene.getWindow();

            // Modifier la scène pour afficher la nouvelle page
            primaryStage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

