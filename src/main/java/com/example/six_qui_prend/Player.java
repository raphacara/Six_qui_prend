package com.example.six_qui_prend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private List<Card> hand;
    private int penaltyPoints;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.penaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public void setHand(List<Card> hand) {
        this.hand = new ArrayList<>(hand);
    }

    public Card chooseCard() {
        if (!hand.isEmpty()) {
            return hand.get(0);
        }
        return null; // Retourne null si la main est vide
        // Logique pour que le joueur choisisse une carte
        // Retourne la carte choisie
    }

    public void addNewCard(List<Card> cardsToAdd){
        hand.addAll(cardsToAdd);
    }

    public void playCard(Card card) {
        removeFromHand(card);
        // Logique pour jouer la carte, par exemple, mettre à jour l'état du jeu en fonction de la carte jouée par le joueur
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void addPenaltyPoints(Integer points) {
        penaltyPoints += points;
    }

    public Card playRandomCard() {
        if (!hand.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(hand.size());
            return hand.remove(randomIndex);
        }
        return null;
    }
}
