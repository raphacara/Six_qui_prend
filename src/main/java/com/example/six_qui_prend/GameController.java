package com.example.six_qui_prend;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import com.example.six_qui_prend.Deck;
import com.example.six_qui_prend.Card;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private ImageView backgroundImage2;
    @FXML
    private GridPane gridView;
    @FXML
    private VBox playerHand;

    @FXML
    protected void onRestartButtonClick() {
        // Code pour gérer l'action du bouton Restart
    }


    private Deck deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundImage2.setPreserveRatio(true);

        createGridView(); // create the grid
        addGridToTheGrid(); // add the grid to the fxml grid

        deck = new Deck();
        deck.initialize();

        displayCards(); // display the cards in the grid
        displayPlayerHand(); // display the player's hand
    }

    private void displayPlayerHand() {
        List<Card> playerCards = deck.drawCards(10);

        for (int i = 0; i < playerCards.size(); i++) {
            Card card = playerCards.get(i);
            Button cardButton = new Button();
            cardButton.setStyle("-fx-background-image: url('" + card.getImagePath() + "'); " +
                    "-fx-background-size: cover; " +
                    "-fx-display: inline-block;"); // Afficher en ligne
            cardButton.setOnAction(event -> handleCardClick(card));

            playerHand.getChildren().add(cardButton);
        }
    }



    private void createGridView() {
        for (int col = 0; col < 6; col++) {
            for (int row = 0; row < 4; row++) {
                Button button = new Button();
                button.setStyle("-fx-font-size: 2em;" +
                        " -fx-background-color: white;" +
                        " -fx-border-color: transparent;" +
                        " -fx-border-width: 1px;" +
                        " -fx-border-radius: 5%;");

                gridView.add(button, col, row);
            }
        }
    }

    private void addGridToTheGrid() {
        StackPane gridContainer = new StackPane(gridView);
        gridContainer.setMaxSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);

        playerHand.getChildren().add(gridContainer);
    }

    private void displayCards() {
        List<Card> cards = deck.drawCards(4);

        for (int row = 0; row < 4; row++) {
            Card card = cards.get(row);
            Button button = (Button) gridView.getChildren().get(row);
            button.setStyle("-fx-background-image: url('" + card.getImagePath() + "'); " +
                    "-fx-background-size: cover;");
            button.setOnAction(event -> handleCardClick(card));
        }
    }

    private void handleCardClick(Card card) {
        // Handle button click action

    }
}
