package com.example.six_qui_prend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public ImageView backgroundImage2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage2.setPreserveRatio(true); // Définit preserveRatio sur true
        Scene scene = backgroundImage2.getScene();
        if (scene != null) {
            backgroundImage2.fitWidthProperty().bind(scene.widthProperty());
            backgroundImage2.fitHeightProperty().bind(scene.heightProperty());
        } else {
            backgroundImage2.sceneProperty().addListener((observable, oldScene, newScene) -> {
                backgroundImage2.fitWidthProperty().bind(newScene.widthProperty());
                backgroundImage2.fitHeightProperty().bind(newScene.heightProperty());
            });
        }
    }

    @FXML
    private void onGoBackButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        Scene scene = button.getScene();
        Stage stage = (Stage) scene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root;
        try {
            root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
