package com.example.six_qui_prend;



import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<Card> row1;
    private List<Card> row2;
    private List<Card> row3;
    private List<Card> row4;

    public GameBoard(List<Card> firstCards) {
        if (firstCards.size() != 4) {
            throw new RuntimeException("Incorrect number of input cards in gameBoard");
        }
        this.row1 = new ArrayList<>();
        this.row2 = new ArrayList<>();
        this.row3 = new ArrayList<>();
        this.row4 = new ArrayList<>();
        this.row1.add(firstCards.get(0));
        this.row2.add(firstCards.get(1));
        this.row3.add(firstCards.get(2));
        this.row4.add(firstCards.get(3));
    }

    public void addNewCard(int rowNumber, Card cardToAdd) {
        List<Card> targetRow = getRow(rowNumber);
        if (targetRow != null) {
            targetRow.add(cardToAdd);
        } else {
            System.out.println("Incorrect row number, using default row");
            this.row1.add(cardToAdd);
        }
    }

    private List<Card> getRow(int rowNumber) {
        switch (rowNumber) {
            case 1:
                return this.row1;
            case 2:
                return this.row2;
            case 3:
                return this.row3;
            case 4:
                return this.row4;
            default:
                return null;
        }
    }

    public int getNextEmptyRow() {
        if (row1.size() < getMaxRowSize()) {
            return 1;
        } else if (row2.size() < getMaxRowSize()) {
            return 2;
        } else if (row3.size() < getMaxRowSize()) {
            return 3;
        } else if (row4.size() < getMaxRowSize()) {
            return 4;
        }
        return -1; // No empty row found
    }

    private int getMaxRowSize() {
        // Return the maximum allowed size for a row (e.g., based on game rules)
        return 5;
    }

    public boolean isRowFull(int rowNumber) {
        List<Card> targetRow = getRow(rowNumber);
        return targetRow != null && targetRow.size() >= getMaxRowSize();
    }

    public void handleTurn(Player player, Card cardToPlay, int targetRow) {
        if (isRowFull(targetRow)) {
            // Replace the row with the card if it has a higher value
            List<Card> row = getRow(targetRow);
            if (row != null && cardToPlay.getValue() > getMaxValueInRow(row)) {
                replaceRowWithCard(row, cardToPlay);
            } else {
                // Handle penalty points for the player
                player.addPenaltyPoints(cardToPlay.getPenaltyPoints());
            }
        } else {
            addNewCard(targetRow, cardToPlay);
        }
    }

    private int getMaxValueInRow(List<Card> row) {
        int maxValue = 0;
        for (Card card : row) {
            if (card.getValue() > maxValue) {
                maxValue = card.getValue();
            }
        }
        return maxValue;
    }

    private void replaceRowWithCard(List<Card> row, Card card) {
        row.clear();
        row.add(card);
    }

    public boolean isGameOver() {
        // Define your game over conditions here (e.g., when all players have played all their cards)
        return false;
    }
}

//
