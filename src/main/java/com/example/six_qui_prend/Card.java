package com.example.six_qui_prend;

public class Card {
    private int number;
    private int bullHeads;
    private int value;
    private int penaltyPoints;
    private String imagePath;

    public Card(int number, int bullHeads, String imagePath) {
        this.number = number;
        this.bullHeads = bullHeads;
        this.imagePath = imagePath;
    }

    public int getNumber() {
        return number;
    }

    public int getBullHeads() {
        return bullHeads;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getValue() {
        return value;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    // Ajoutez les autres méthodes et fonctionnalités de la classe Card
}
