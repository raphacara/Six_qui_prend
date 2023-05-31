package com.example.six_qui_prend;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private GameBoard board;

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        deck = new Deck();

        // Giving 10 cards to all the players
        for (Player player : players){
            player.addNewCard(deck.popCards(10));
        }
        board = new GameBoard(deck.popCards(4));


    }

    public void startGame() {
        deck.shuffle();
        dealInitialCards();

        boolean gameOver = false;
        while (!gameOver) {
            playRound();
            gameOver = checkGameEnd();
        }

        Player winner = determineWinner();
        System.out.println("Game over! The winner is: " + winner.getName());
    }

    private void dealInitialCards() {
        for (Player player : players) {
            List<Card> initialCards = deck.drawCards(10);
            player.setHand(initialCards);
        }
    }

    private void playRound() {
        for (Player player : players) {
            Card chosenCard = player.chooseCard();
            player.playCard(chosenCard);
            System.out.println(player.getName() + " played " + chosenCard);
        }
        System.out.println("-----");

    }

    private boolean checkGameEnd() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Player determineWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getPenaltyPoints() < winner.getPenaltyPoints()) {
                winner = player;
            }
        }
        return winner;
    }
}