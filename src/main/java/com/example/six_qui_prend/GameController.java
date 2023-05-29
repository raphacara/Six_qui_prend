package com.example.six_qui_prend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    public HBox theGrid;
    @FXML
    private ImageView backgroundImage2;
    @FXML
    private GridPane gridView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage2.setPreserveRatio(true);
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

        createGridView(); //create the grid

        StackPane gridContainer = new StackPane(gridView);
        gridContainer.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        gridContainer.setAlignment(Pos.CENTER);

        addGridToTheGrid(); //add the grid to the fxml grid
    }

    private void createGridView() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 6; col++) {
                Button button = new Button();
                button.setStyle("-fx-font-size: 2em;" +
                        " -fx-background-color: transparent;" +
                        " -fx-border-color: black;" +
                        " -fx-border-width: 1px;" +
                        " -fx-border-radius: 5%;");

                // Lier la largeur et la hauteur du bouton à la taille de l'image
                button.prefWidthProperty().bind(backgroundImage2.fitWidthProperty().divide(6));
                button.prefHeightProperty().bind(backgroundImage2.fitHeightProperty().divide(4));

                gridView.add(button, col, row);
            }
        }
    }

    private void addGridToTheGrid() {
        theGrid.getChildren().add(gridView);
    }


    @FXML
    private void onRestartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-playing.fxml"));
        StackPane root = fxmlLoader.load();
        Stage stage = (Stage) backgroundImage2.getScene().getWindow();
        boolean wasFullScreen = stage.isFullScreen(); // Save the current state of the full screen mode
        Scene introScene = new Scene(root);

        // Initialize the scene before accessing its properties
        stage.setScene(introScene);
        stage.setTitle("6 qui prend!");
        stage.setFullScreen(wasFullScreen); // Restore the full screen mode
        stage.show();
    }
}