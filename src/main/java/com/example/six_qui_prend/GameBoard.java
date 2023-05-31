package com.example.six_qui_prend;

import java.util.List;

public class GameBoard {

    private List<Card> row1 ;
    private List<Card> row2 ;
    private List<Card> row3 ;
    private List<Card> row4 ;

    public GameBoard(List<Card> firstCards)   {
        // Adding the first cards for each row
        if (firstCards.size() != 4) {
            throw new RuntimeException("Incorrect number of input cards in gameBoard");
        }
        this.row1.add(firstCards.get(0));
        this.row2.add(firstCards.get(1));
        this.row3.add(firstCards.get(2));
        this.row4.add(firstCards.get(3));
    }

    public void addNewCard(Integer rowNumber, Card cardToAdd)  {
        switch (rowNumber) {
            case 1:
                this.row1.add(cardToAdd);
            case 2 :
                this.row2.add(cardToAdd);
            case 3 :
                this.row3.add(cardToAdd);
            case 4 :
                this.row4.add(cardToAdd);
            default:
                System.out.println("Incorrect row number, using default row");
                this.row1.add(cardToAdd);
        }
    }


}
