package com.gostop;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(boolean shuffle) {
        this.loadCards();

        if (shuffle) {
            this.shuffle();
        }
    }

    /**
     * Remove the top card of the deck
     * (i.e. last card in the ArrayList).
     *
     * @return card at top of the deck
     */
    public Card draw() {
        if (this.cards.size() == 0) {
            return null;
        }
        int lastCardIndex = this.cards.size() - 1;
        return this.cards.remove(lastCardIndex);
    }

    /**
     * Check the bottom card
     * (i.e. first card in the ArrayList).
     * Context: Last player gets to peek at the bottom.
     *
     * @return card at the bottom of the deck
     */
    public Card peekBottom() {
        return this.cards.get(0);
    }

    /**
     * Fisher-Yates-Durstenfeld Shuffle.
     */
    private void shuffle() {
        for (int i = cards.size() - 1; i >= 1; i--) {
            Random rand = new Random();
            int j = rand.nextInt(i + 1);
            this.swap(i, j);
        }
    }

    /**
     * Swap locations of Cards in the cards array list.
     *
     * @param i first index
     * @param j second index
     */
    private void swap(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    /**
     * Load a new deck of cards.
     */
    private void loadCards() {
        this.cards = new ArrayList<>();

        this.cards.add(new Card(CardSuit.JAN, CardCategory.BRIGHT));
        this.cards.add(new Card(CardSuit.JAN, CardCategory.RIBBON, CardSpecial.RED_LABEL));
        this.cards.add(new Card(CardSuit.JAN, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.JAN, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.FEB, CardCategory.ANIMAL, CardSpecial.BIRD));
        this.cards.add(new Card(CardSuit.FEB, CardCategory.RIBBON, CardSpecial.RED_LABEL));
        this.cards.add(new Card(CardSuit.FEB, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.FEB, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.MAR, CardCategory.BRIGHT));
        this.cards.add(new Card(CardSuit.MAR, CardCategory.RIBBON, CardSpecial.RED_LABEL));
        this.cards.add(new Card(CardSuit.MAR, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.MAR, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.APR, CardCategory.ANIMAL, CardSpecial.BIRD));
        this.cards.add(new Card(CardSuit.APR, CardCategory.RIBBON, CardSpecial.BLANK_RED));
        this.cards.add(new Card(CardSuit.APR, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.APR, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.MAY, CardCategory.ANIMAL));
        this.cards.add(new Card(CardSuit.MAY, CardCategory.RIBBON, CardSpecial.BLANK_RED));
        this.cards.add(new Card(CardSuit.MAY, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.MAY, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.JUN, CardCategory.ANIMAL));
        this.cards.add(new Card(CardSuit.JUN, CardCategory.RIBBON, CardSpecial.BLUE_LABEL));
        this.cards.add(new Card(CardSuit.JUN, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.JUN, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.JUL, CardCategory.ANIMAL));
        this.cards.add(new Card(CardSuit.JUL, CardCategory.RIBBON, CardSpecial.BLANK_RED));
        this.cards.add(new Card(CardSuit.JUL, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.JUL, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.AUG, CardCategory.BRIGHT));
        this.cards.add(new Card(CardSuit.AUG, CardCategory.ANIMAL, CardSpecial.BIRD));
        this.cards.add(new Card(CardSuit.AUG, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.AUG, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.SEP, CardCategory.JUNK_ANIMAL));
        this.cards.add(new Card(CardSuit.SEP, CardCategory.RIBBON, CardSpecial.BLUE_LABEL));
        this.cards.add(new Card(CardSuit.SEP, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.SEP, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.OCT, CardCategory.ANIMAL));
        this.cards.add(new Card(CardSuit.OCT, CardCategory.RIBBON, CardSpecial.BLUE_LABEL));
        this.cards.add(new Card(CardSuit.OCT, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.OCT, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.NOV, CardCategory.BRIGHT));
        this.cards.add(new Card(CardSuit.NOV, CardCategory.JUNK, CardSpecial.DOUBLE));
        this.cards.add(new Card(CardSuit.NOV, CardCategory.JUNK));
        this.cards.add(new Card(CardSuit.NOV, CardCategory.JUNK));

        this.cards.add(new Card(CardSuit.DEC, CardCategory.BRIGHT));
        this.cards.add(new Card(CardSuit.DEC, CardCategory.ANIMAL, CardSpecial.BIRD));
        this.cards.add(new Card(CardSuit.DEC, CardCategory.RIBBON));
        this.cards.add(new Card(CardSuit.DEC, CardCategory.JUNK, CardSpecial.DOUBLE));
    }
}
