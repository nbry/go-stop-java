package com.gostop;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        Testing adding a stack of cards to collection
        Deck myDeck = new Deck(true);
        Stack<Card> gainedCards = new Stack<>();

//        Draw 48 cards and put them in the stack
        for (int i = 0; i < 48; i++) {
            Card drawnCard = myDeck.draw();
            System.out.println("Card: " + drawnCard.toString());
            gainedCards.add(drawnCard);
        }

        CollectionOfCards collection = new CollectionOfCards();
        collection.setSepAnimalIsJunk(true);
        collection.addCards(gainedCards);

        System.out.println("******");
        System.out.println("TOTAL SCORE: " + collection.getScore());
    }

}
