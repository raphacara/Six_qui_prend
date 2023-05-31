package com.example.six_qui_prend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards; // Liste des cartes dans le jeu

    public Deck() {
        cards = new ArrayList<>();
    }

    public void initialize() {
        // Ajouter les cartes au jeu
        for (int number = 1; number <= 104; number++) {
            int bullHeads = calculateBullHeads(number);
            String imagePath = "/cards/" + number + ".png"; // Chemin de l'image de la carte
            Card card = new Card(number, bullHeads, imagePath);
            cards.add(card);
        }

        // Mélanger les cartes
        shuffle();
    }

    public List<Card> popCards(Integer numberToGet){
        List<Card> cardToGive = null;
        for (Integer i = 0; i < numberToGet; i++){
            cardToGive.add(cards.remove(0));
        }
        return cardToGive;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null; // Le jeu de cartes est vide
        }

        return cards.remove(0); // Retirer la première carte du jeu
    }

    public int getSize() {
        return cards.size();
    }

    // Méthode utilitaire pour calculer le nombre de têtes de buffle en fonction du nombre de la carte
    private int calculateBullHeads(int number) {
        if (number % 5 == 0) {
            return 2;
        } else if (number % 10 == 0) {
            return 3;
        } else if (number % 11 == 0) {
            return 5;
        } else {
            return 1;
        }
    }

    public List<Card> drawCards(int numCards) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            if (!cards.isEmpty()) {
                Card card = cards.remove(0); // Retirer la première carte du deck
                drawnCards.add(card);
            }
        }
        return drawnCards;

    }
}
